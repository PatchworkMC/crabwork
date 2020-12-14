/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

import net.fabricmc.lorenztiny.TinyMappingFormat
import org.cadixdev.lorenz.MappingSet
import org.cadixdev.lorenz.io.MappingFormats
import org.cadixdev.lorenz.model.ClassMapping
import java.nio.file.FileSystems
import java.nio.file.Files
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

buildscript {
    repositories {
        jcenter()

        maven {
            name = "FabricMC"
            url = uri("https://maven.fabricmc.net/")
        }
    }

    dependencies {
        classpath("net.fabricmc", "lorenz-tiny", "3.0.0")
    }
}

plugins {
    id("fabric-loom") version "0.5.43"
    id("org.cadixdev.licenser") version "0.5.0"
    checkstyle
    `maven-publish`
    signing
}

group = "net.patchworkmc"
version = "1.0.0-SNAPSHOT"

repositories {
    jcenter()

    maven {
        name = "FabricMC"
        url = uri("https://maven.fabricmc.net/")
    }

    maven {
        name = "PatchworkMC"
        url = uri("https://dl.bintray.com/patchworkmc/Patchwork-Maven/")
    }

    maven {
        name = "MinecraftForge"
        url = uri("https://files.minecraftforge.net/maven/")
    }

    // For Fabric-ASM
    maven {
        name = "JitPack"
        url = uri("https://jitpack.io/")
    }
}

dependencies {
    minecraft("net.minecraft", "minecraft", "1.14.4")
    mappings(McpMappings("1.14.4", "snapshot", "20190719-1.14.3"))
    modImplementation("net.fabricmc", "fabric-loader", "0.10.8")

    // Fabric-API
    modImplementation("net.fabricmc.fabric-api", "fabric-api", "0.23.2+1.14")

    // Annotations
    implementation("com.google.code.findbugs", "jsr305", "3.0.2")

    val include = mutableSetOf<Dependency>()

    // EventBus
    include += implementation("net.patchworkmc", "patchwork-eventbus", "2.0.1", classifier = "all")
    include += implementation("net.jodah", "typetools", "0.6.0")

    // Patching
    include += modImplementation("com.github.Chocohead", "Fabric-ASM", "v2.1")

    include.forEach {
        include(it)
    }
}

sourceSets {
    main {
        java.srcDirs(file("src/main/forge"))
        java.srcDirs(file("src/main/minecraft"))
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    withJavadocJar()
    withSourcesJar()
}

minecraft {
    accessWidener = file("src/main/resources/crabwork.aw")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"

    if (JavaVersion.current().isJava9Compatible) {
        options.release.set(8)
    } else {
        sourceCompatibility = "8"
        targetCompatibility = "8"
    }
}

tasks.withType<Javadoc> {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

tasks.withType<AbstractArchiveTask> {
    from(file("LICENSE"))
}

tasks.processResources {
    filesMatching("fabric.mod.json") {
        expand("version" to project.version)
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            extensions.getByType<SigningExtension>().apply {
                if (signatory != null) {
                    sign(this@create)
                }
            }
        }
    }

    repositories {
        maven {
            val releasesRepoUrl = uri("${buildDir}/repos/releases")
            val snapshotsRepoUrl = uri("${buildDir}/repos/snapshots")
            name = "Project"
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
        }
    }

}

checkstyle {
    configFile = file("checkstyle.xml")
    toolVersion = "8.38"
}

license {
    header = file("HEADER")
    include("**/*.java")
}

class McpMappings(private val minecraft: String, private val channel: String, private val mcp: String) :
    SelfResolvingDependency {

    private val output = file(".gradle/mcp/$version.zip")
    private var reason: String? = null

    override fun getGroup(): String = "de.oceanlabs"
    override fun getName(): String = "mcp_$channel"
    override fun getVersion(): String = "$mcp+$minecraft"

    override fun contentEquals(dependency: Dependency): Boolean {
        return this == dependency
    }

    override fun copy(): Dependency = McpMappings(minecraft, channel, mcp)

    override fun getReason(): String? = reason

    override fun because(reason: String?) {
        this.reason = reason
    }

    override fun getBuildDependencies(): TaskDependency = TaskDependency {
        setOf()
    }

    override fun resolve(): MutableSet<File> {
        if (!output.exists()) {
            output.parentFile.mkdirs()

            val intermediaryJar = configurations.detachedConfiguration(
                dependencies.create(
                    "net.fabricmc",
                    "intermediary",
                    minecraft,
                    classifier = "v2"
                )
            ).singleFile

            val mcpConfigJar = configurations.detachedConfiguration(
                dependencies.create(
                    "de.oceanlabs.mcp",
                    "mcp_config",
                    minecraft
                )
            ).singleFile

            val mcpMappingsZip = File.createTempFile(version, ".zip")
            mcpMappingsZip.parentFile.mkdirs()
            mcpMappingsZip.delete()

            uri("https://files.minecraftforge.net/maven/de/oceanlabs/mcp/mcp_$channel/$mcp/mcp_$channel-$mcp.zip").toURL()
                .openStream().use { web ->
                    mcpMappingsZip.outputStream().use { file ->
                        web.copyTo(file)
                    }
                }

            val intermediary = FileSystems.newFileSystem(intermediaryJar.toPath(), null as? ClassLoader?).use {
                TinyMappingFormat.DETECT.read(it.getPath("mappings", "mappings.tiny"), "intermediary", "official")
            }

            val mcpConfig = FileSystems.newFileSystem(mcpConfigJar.toPath(), null as? ClassLoader?).use {
                MappingFormats.TSRG.read(it.getPath("config", "joined.tsrg"))
            }

            val (fields, methods) = FileSystems.newFileSystem(mcpMappingsZip.toPath(), null as? ClassLoader?)
                .use { fs ->
                    val fields = Files.readAllLines(fs.getPath("fields.csv"))
                        .filter { it.isNotEmpty() }
                        .map { it.split(",") } // Technically we should use a CSV parser...
                        .map { (getSrgId(it[0]) ?: return@map null) to it[1] }
                        .filterNotNull()
                        .toMap()

                    val methods = Files.readAllLines(fs.getPath("methods.csv"))
                        .filter { it.isNotEmpty() }
                        .map { it.split(",") } // Technically we should use a CSV parser...
                        .map { (getSrgId(it[0]) ?: return@map null) to it[1] }
                        .filterNotNull()
                        .toMap()

                    fields to methods
                }

            // Combine MCPConfig with the fields and methods
            mcpConfig.iterate {
                for (fieldMapping in it.fieldMappings) {
                    getSrgId(fieldMapping.deobfuscatedName)?.let { id -> fields[id] }?.also { name ->
                        fieldMapping.deobfuscatedName = name
                    }
                }

                for (methodMapping in it.methodMappings) {
                    getSrgId(methodMapping.deobfuscatedName)?.let { id -> methods[id] }?.also { name ->
                        methodMapping.deobfuscatedName = name
                    }
                }
            }

            ZipOutputStream(output.outputStream()).use {
                it.putNextEntry(ZipEntry("mappings/"))
                it.closeEntry()
                it.putNextEntry(ZipEntry("mappings/mappings.tiny"))
                it.bufferedWriter().use { writer ->
                    TinyMappingFormat.STANDARD.createWriter(
                        writer,
                        "intermediary",
                        "named"
                    ).write(intermediary.merge(mcpConfig))
                }
            }
        }

        return mutableSetOf(output)
    }

    override fun resolve(transitive: Boolean): MutableSet<File> = resolve()

    // Technically using the SRG ID is more accurate
    private val pattern = Regex(".*_(\\d+)_.*")

    private fun getSrgId(name: String): Int? {
        return name.replace(pattern, "$1").toIntOrNull()
    }

    private fun MappingSet.iterate(consumer: (ClassMapping<*, *>) -> Unit) {
        for (classMapping in topLevelClassMappings) {
            iterate0(classMapping, consumer)
        }
    }

    private fun iterate0(classMapping: ClassMapping<*, *>, consumer: (ClassMapping<*, *>) -> Unit) {
        consumer(classMapping)

        for (innerClassMapping in classMapping.innerClassMappings) {
            iterate0(innerClassMapping, consumer)
        }
    }
}
