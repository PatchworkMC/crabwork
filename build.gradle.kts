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
    maven {
        name = "PatchworkMC"
        url = uri("https://dl.bintray.com/patchworkmc/Patchwork-Maven/")
    }

    // For Fabric-ASM
    maven {
        name = "JitPack"
        url = uri("https://jitpack.io/")
    }
}

dependencies {
    minecraft("net.minecraft", "minecraft", "1.14.4")
    mappings("net.fabricmc", "yarn", "1.14.4+build.18", classifier = "v2")
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
    from(rootProject.file("LICENSE"))
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
            val releasesRepoUrl = uri("${rootProject.buildDir}/repos/releases")
            val snapshotsRepoUrl = uri("${rootProject.buildDir}/repos/snapshots")
            name = "Project"
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
        }
    }

}

checkstyle {
    configFile = rootProject.file("checkstyle.xml")
    toolVersion = "8.38"
}

license {
    header = file("HEADER")
    include("**/*.java")
}
