package net.minecraft.world.gen.treedecorator;

import com.mojang.serialization.Codec;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class TreeDecoratorType<P extends TreeDecorator> extends net.minecraftforge.registries.ForgeRegistryEntry<TreeDecoratorType<?>> {
	@Shadow
	@Final
	public static TreeDecoratorType<TrunkVineTreeDecorator> TRUNK_VINE;

	@Shadow
	@Final
	public static TreeDecoratorType<LeaveVineTreeDecorator> LEAVE_VINE;

	@Shadow
	@Final
	public static TreeDecoratorType<CocoaTreeDecorator> COCOA;

	@Shadow
	@Final
	public static TreeDecoratorType<BeehiveTreeDecorator> BEEHIVE;

	@Shadow
	@Final
	public static TreeDecoratorType<AlterGroundTreeDecorator> ALTER_GROUND;

	@Shadow
	@Final
	private final Codec<P> field_236875_f_;

	@Shadow
	public TreeDecoratorType(Codec<P> p_i232052_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <P extends TreeDecorator> TreeDecoratorType<P> register(String p_236877_0_, Codec<P> p_236877_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Codec<P> func_236876_a_() {
		throw new UnsupportedOperationException();
	}
}
