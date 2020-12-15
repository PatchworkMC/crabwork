package net.minecraft.enchantment;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.TridentItem;
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
    private java.util.function.Predicate<Item> delegate;

    @Shadow
    private EnchantmentType() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private EnchantmentType(java.util.function.Predicate<Item> delegate) {
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
