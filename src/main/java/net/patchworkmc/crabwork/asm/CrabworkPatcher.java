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

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

class CrabworkPatcher {
	private static final String ADD_IF_NOT_PRESENT = "Lnet/patchworkmc/crabwork/asm/AddIfNotPresent;";
	private static final String FINAL = "Lnet/patchworkmc/crabwork/asm/Final;";
	private static final String MERGE_CLASS_INITIALIZER = "Lnet/patchworkmc/crabwork/asm/MergeClassInitializer;";
	private static final String REMOVE = "Lnet/patchworkmc/crabwork/asm/Remove;";
	private static final String RENAME = "Lnet/patchworkmc/crabwork/asm/Rename;";
	private static final String SHADOW = "Lnet/patchworkmc/crabwork/asm/Shadow;";

	static void merge(ClassNode original, ClassNode patch) {
		// Step 1 - Copy attributes
		{
			if (!"java/lang/Object".equals(patch.superName)) {
				original.superName = patch.superName;
			}

			if (original.interfaces == null) {
				original.interfaces = new ArrayList<>();
			}

			if (patch.interfaces != null) {
				patch.interfaces.removeAll(original.interfaces);
				original.interfaces.addAll(patch.interfaces);
			}
		}

		// Step 2 - Ignore everything which is shadowed
		patch.fields.removeIf(field -> has(SHADOW, field.visibleAnnotations));
		patch.methods.removeIf(field -> has(SHADOW, field.visibleAnnotations));

		// Step 3 - Remove methods or fields
		{
			patch.fields.removeIf(field -> {
				if (has(REMOVE, field.visibleAnnotations)) {
					removeField(original, field.name, field.desc);
					return true;
				}

				return false;
			});

			patch.methods.removeIf(method -> {
				if (has(REMOVE, method.visibleAnnotations)) {
					removeMethod(original, method.name, method.desc);
					return true;
				}

				return false;
			});
		}

		// Step 4 - Fix final fields and methods
		{
			for (FieldNode field : patch.fields) {
				if (has(FINAL, field.visibleAnnotations)) {
					field.access |= Opcodes.ACC_FINAL;
				} else {
					field.access &= ~Opcodes.ACC_FINAL;
				}
			}

			for (MethodNode method : patch.methods) {
				if (has(FINAL, method.visibleAnnotations)) {
					method.access |= Opcodes.ACC_FINAL;
				} else {
					method.access &= ~Opcodes.ACC_FINAL;
				}
			}
		}

		// Step 5 - Merge fields
		for (FieldNode field : patch.fields) {
			boolean allow = true;

			if (has(ADD_IF_NOT_PRESENT, field.visibleAnnotations)) {
				for (FieldNode originalField : original.fields) {
					if (originalField.name.equals(field.name) && originalField.desc.equals(field.desc)) {
						allow = false;
						break;
					}
				}
			}

			if (allow) {
				removeField(original, field.name, field.desc);

				Rename rename = findRename(field.visibleAnnotations);

				if (rename != null) {
					field.name = rename.name();
					field.desc = rename.descriptor();
				}

				original.fields.add(field);
			}
		}

		// Step 6 - Merge methods
		for (MethodNode method : patch.methods) {
			if (!method.name.equals("<clinit>") || has(MERGE_CLASS_INITIALIZER, patch.visibleAnnotations)) {
				removeMethod(original, method.name, method.desc);

				Rename rename = findRename(method.visibleAnnotations);

				if (rename != null) {
					method.name = rename.name();
					method.desc = rename.descriptor();
				}

				original.methods.add(method);
			}
		}
	}

	private static void removeField(ClassNode classNode, String name, String descriptor) {
		classNode.fields.removeIf(fieldNode -> fieldNode.name.equals(name) && fieldNode.desc.equals(descriptor));
	}

	private static void removeMethod(ClassNode classNode, String name, String descriptor) {
		classNode.methods.removeIf(methodNode -> methodNode.name.equals(name) && methodNode.desc.equals(descriptor));
	}

	private static boolean has(String type, List<AnnotationNode> annotations) {
		for (AnnotationNode annotation : safe(annotations)) {
			if (type.equals(annotation.desc)) {
				return true;
			}
		}

		return false;
	}

	// Makes sure the list isn't null
	private static List<AnnotationNode> safe(List<AnnotationNode> annotations) {
		if (annotations == null) {
			return Collections.emptyList();
		} else {
			return annotations;
		}
	}

	private static Rename findRename(List<AnnotationNode> annotations) {
		for (AnnotationNode annotation : safe(annotations)) {
			if (RENAME.equals(annotation.desc)) {
				final String[] newName = new String[1];
				final String[] newDescriptor = new String[1];

				annotation.accept(new AnnotationVisitor(Opcodes.ASM9) {
					@Override
					public void visit(String name, Object value) {
						if ("name".equals(name)) {
							newName[0] = String.valueOf(value);
						} else if ("descriptor".equals(name)) {
							newDescriptor[0] = String.valueOf(value);
						}
					}
				});

				return new Rename() {
					@Override
					public Class<? extends Annotation> annotationType() {
						return getClass();
					}

					@Override
					public String name() {
						return newName[0];
					}

					@Override
					public String descriptor() {
						return newDescriptor[0];
					}
				};
			}
		}

		return null;
	}
}
