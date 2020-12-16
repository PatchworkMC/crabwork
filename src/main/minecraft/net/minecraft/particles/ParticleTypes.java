package net.minecraft.particles;

import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@net.minecraftforge.registries.ObjectHolder("minecraft")
public class ParticleTypes {
	@Shadow
	@Final
	public static BasicParticleType AMBIENT_ENTITY_EFFECT;

	@Shadow
	@Final
	public static BasicParticleType ANGRY_VILLAGER;

	@Shadow
	@Final
	public static BasicParticleType BARRIER;

	@Shadow
	@Final
	public static ParticleType<BlockParticleData> BLOCK;

	@Shadow
	@Final
	public static BasicParticleType BUBBLE;

	@Shadow
	@Final
	public static BasicParticleType CLOUD;

	@Shadow
	@Final
	public static BasicParticleType CRIT;

	@Shadow
	@Final
	public static BasicParticleType DAMAGE_INDICATOR;

	@Shadow
	@Final
	public static BasicParticleType DRAGON_BREATH;

	@Shadow
	@Final
	public static BasicParticleType DRIPPING_LAVA;

	@Shadow
	@Final
	public static BasicParticleType FALLING_LAVA;

	@Shadow
	@Final
	public static BasicParticleType LANDING_LAVA;

	@Shadow
	@Final
	public static BasicParticleType DRIPPING_WATER;

	@Shadow
	@Final
	public static BasicParticleType FALLING_WATER;

	@Shadow
	@Final
	public static ParticleType<RedstoneParticleData> DUST;

	@Shadow
	@Final
	public static BasicParticleType EFFECT;

	@Shadow
	@Final
	public static BasicParticleType ELDER_GUARDIAN;

	@Shadow
	@Final
	public static BasicParticleType ENCHANTED_HIT;

	@Shadow
	@Final
	public static BasicParticleType ENCHANT;

	@Shadow
	@Final
	public static BasicParticleType END_ROD;

	@Shadow
	@Final
	public static BasicParticleType ENTITY_EFFECT;

	@Shadow
	@Final
	public static BasicParticleType EXPLOSION_EMITTER;

	@Shadow
	@Final
	public static BasicParticleType EXPLOSION;

	@Shadow
	@Final
	public static ParticleType<BlockParticleData> FALLING_DUST;

	@Shadow
	@Final
	public static BasicParticleType FIREWORK;

	@Shadow
	@Final
	public static BasicParticleType FISHING;

	@Shadow
	@Final
	public static BasicParticleType FLAME;

	@Shadow
	@Final
	public static BasicParticleType SOUL_FIRE_FLAME;

	@Shadow
	@Final
	public static BasicParticleType SOUL;

	@Shadow
	@Final
	public static BasicParticleType FLASH;

	@Shadow
	@Final
	public static BasicParticleType HAPPY_VILLAGER;

	@Shadow
	@Final
	public static BasicParticleType COMPOSTER;

	@Shadow
	@Final
	public static BasicParticleType HEART;

	@Shadow
	@Final
	public static BasicParticleType INSTANT_EFFECT;

	@Shadow
	@Final
	public static ParticleType<ItemParticleData> ITEM;

	@Shadow
	@Final
	public static BasicParticleType ITEM_SLIME;

	@Shadow
	@Final
	public static BasicParticleType ITEM_SNOWBALL;

	@Shadow
	@Final
	public static BasicParticleType LARGE_SMOKE;

	@Shadow
	@Final
	public static BasicParticleType LAVA;

	@Shadow
	@Final
	public static BasicParticleType MYCELIUM;

	@Shadow
	@Final
	public static BasicParticleType NOTE;

	@Shadow
	@Final
	public static BasicParticleType POOF;

	@Shadow
	@Final
	public static BasicParticleType PORTAL;

	@Shadow
	@Final
	public static BasicParticleType RAIN;

	@Shadow
	@Final
	public static BasicParticleType SMOKE;

	@Shadow
	@Final
	public static BasicParticleType SNEEZE;

	@Shadow
	@Final
	public static BasicParticleType SPIT;

	@Shadow
	@Final
	public static BasicParticleType SQUID_INK;

	@Shadow
	@Final
	public static BasicParticleType SWEEP_ATTACK;

	@Shadow
	@Final
	public static BasicParticleType TOTEM_OF_UNDYING;

	@Shadow
	@Final
	public static BasicParticleType UNDERWATER;

	@Shadow
	@Final
	public static BasicParticleType SPLASH;

	@Shadow
	@Final
	public static BasicParticleType WITCH;

	@Shadow
	@Final
	public static BasicParticleType BUBBLE_POP;

	@Shadow
	@Final
	public static BasicParticleType CURRENT_DOWN;

	@Shadow
	@Final
	public static BasicParticleType BUBBLE_COLUMN_UP;

	@Shadow
	@Final
	public static BasicParticleType NAUTILUS;

	@Shadow
	@Final
	public static BasicParticleType DOLPHIN;

	@Shadow
	@Final
	public static BasicParticleType CAMPFIRE_COSY_SMOKE;

	@Shadow
	@Final
	public static BasicParticleType CAMPFIRE_SIGNAL_SMOKE;

	@Shadow
	@Final
	public static BasicParticleType DRIPPING_HONEY;

	@Shadow
	@Final
	public static BasicParticleType FALLING_HONEY;

	@Shadow
	@Final
	public static BasicParticleType LANDING_HONEY;

	@Shadow
	@Final
	public static BasicParticleType FALLING_NECTAR;

	@Shadow
	@Final
	public static BasicParticleType ASH;

	@Shadow
	@Final
	public static BasicParticleType CRIMSON_SPORE;

	@Shadow
	@Final
	public static BasicParticleType WARPED_SPORE;

	@Shadow
	@Final
	public static BasicParticleType DRIPPING_OBSIDIAN_TEAR;

	@Shadow
	@Final
	public static BasicParticleType FALLING_OBSIDIAN_TEAR;

	@Shadow
	@Final
	public static BasicParticleType LANDING_OBSIDIAN_TEAR;

	@Shadow
	@Final
	public static BasicParticleType REVERSE_PORTAL;

	@Shadow
	@Final
	public static BasicParticleType WHITE_ASH;

	@Shadow
	@Final
	public static Codec<IParticleData> CODEC;

	@Shadow
	private static BasicParticleType register(String key, boolean alwaysShow) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T extends IParticleData> ParticleType<T> register(String key, IParticleData.IDeserializer<T> deserializer, final Function<ParticleType<T>, Codec<T>> p_218416_2_) {
		throw new UnsupportedOperationException();
	}
}
