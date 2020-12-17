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

package net.minecraft.enchantment;

import net.minecraft.item.Item;

import net.patchworkmc.crabwork.asm.Shadow;

public enum EnchantmentType implements net.minecraftforge.common.IExtensibleEnum {
	ARMOR {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	ARMOR_FEET {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	ARMOR_LEGS {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	ARMOR_CHEST {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	ARMOR_HEAD {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	WEAPON {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	DIGGER {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	FISHING_ROD {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	TRIDENT {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	BREAKABLE {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	BOW {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	WEARABLE {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	CROSSBOW {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	},
	VANISHABLE {
		@Shadow
		public boolean canEnchantItem(Item itemIn) {
			throw new UnsupportedOperationException();
		}
	};

	@Shadow
	private final java.util.function.Predicate<Item> delegate;

	@Shadow
	EnchantmentType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	EnchantmentType(java.util.function.Predicate<Item> delegate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static EnchantmentType create(String name, java.util.function.Predicate<Item> delegate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canEnchantItem(Item itemIn) {
		throw new UnsupportedOperationException();
	}
}
