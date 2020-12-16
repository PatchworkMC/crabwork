package com.mojang.realmsclient.gui.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.realmsclient.exception.RealmsServiceException;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class RealmsGenericErrorScreen extends RealmsScreen {
	@Shadow
	@Final
	private final Screen field_224228_a;

	@Shadow
	private final ITextComponent field_224229_b;

	@Shadow
	private final ITextComponent field_224230_c;

	@Shadow
	public RealmsGenericErrorScreen(RealmsServiceException p_i232204_1_, Screen p_i232204_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RealmsGenericErrorScreen(ITextComponent p_i232205_1_, Screen p_i232205_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RealmsGenericErrorScreen(ITextComponent p_i232206_1_, ITextComponent p_i232206_2_, Screen p_i232206_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_224224_a(RealmsServiceException p_224224_1_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void func_237841_a_(ITextComponent p_237841_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_237842_a_(ITextComponent p_237842_1_, ITextComponent p_237842_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void init() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public boolean keyPressed(int key, int scanCode, int modifiers) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		throw new UnsupportedOperationException();
	}
}
