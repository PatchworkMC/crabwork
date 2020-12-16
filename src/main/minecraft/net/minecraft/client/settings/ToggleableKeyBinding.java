package net.minecraft.client.settings;

import java.util.function.BooleanSupplier;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ToggleableKeyBinding extends KeyBinding {
	@Shadow
	@Final
	private final BooleanSupplier getterToggle;

	@Shadow
	public ToggleableKeyBinding(String descriptionIn, int codeIn, String categoryIn, BooleanSupplier getterIn) {
		super(null, null, 0, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPressed(boolean valueIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Override
	public boolean isKeyDown() {
		throw new UnsupportedOperationException();
	}
}
