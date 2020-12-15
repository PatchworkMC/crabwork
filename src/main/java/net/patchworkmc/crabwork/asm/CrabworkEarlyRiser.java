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

package net.patchworkmc.crabwork.asm;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.chocohead.mm.api.ClassTinkerers;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import net.fabricmc.loader.api.FabricLoader;

public interface CrabworkEarlyRiser {
	static void run() throws IOException {
		Path path = FabricLoader.getInstance().getModContainer("patchwork").get().getRootPath();

		Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path f, BasicFileAttributes attrs) throws IOException {
				Path file = path.relativize(f);
				String name = file.toString().replace(File.separatorChar, '/');

				if (name.endsWith(".class") && (name.startsWith("net/minecraft/") || name.startsWith("com/mojang/"))) {
					ClassNode patch = new ClassNode();
					byte[] patchBytes = Files.readAllBytes(f);
					new ClassReader(patchBytes).accept(patch, 0);

					String actualName = name.substring(0, name.length() - 6).replace('/', '.');

					// Looks like the class was added instead
					ClassTinkerers.define(actualName, patchBytes);
					ClassTinkerers.addReplacement(actualName, original -> {
						CrabworkPatcher.merge(original, patch);
					});
				}

				return FileVisitResult.CONTINUE;
			}
		});
	}
}
