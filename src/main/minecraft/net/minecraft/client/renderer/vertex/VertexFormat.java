package net.minecraft.client.renderer.vertex;

import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class VertexFormat {
	@Shadow
	@Final
	private final ImmutableList<VertexFormatElement> elements;

	@Shadow
	@Final
	private final IntList offsets;

	@Shadow
	@Final
	private final int vertexSize;

	@Shadow
	public VertexFormat(ImmutableList<VertexFormatElement> elementsIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getIntegerSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ImmutableList<VertexFormatElement> getElements() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean equals(Object p_equals_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int hashCode() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setupBufferState(long pointerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void clearBufferState() {
		throw new UnsupportedOperationException();
	}

	// Forge start
	@Shadow
	public int getOffset(int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasPosition() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasNormal() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasUV(int which) {
		throw new UnsupportedOperationException();
	}
}
