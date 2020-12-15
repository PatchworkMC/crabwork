package net.minecraft.client.renderer.vertex;

import com.mojang.blaze3d.platform.GlStateManager;

import java.util.function.IntConsumer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class VertexFormatElement {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private VertexFormatElement.Type type;
    @Shadow
    @Final
    private VertexFormatElement.Usage usage;
    @Shadow
    @Final
    private int index;
    @Shadow
    @Final
    private int elementCount;
    @Shadow
    @Final
    private int sizeBytes;

    @Shadow
    public VertexFormatElement(int indexIn, VertexFormatElement.Type typeIn, VertexFormatElement.Usage usageIn, int count) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isFirstOrUV(int indexIn, VertexFormatElement.Usage usageIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final VertexFormatElement.Type getType() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final VertexFormatElement.Usage getUsage() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final int getIndex() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final int getSize() {
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
    public void setupBufferState(long pointerIn, int strideIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void clearBufferState() {
        throw new UnsupportedOperationException();
    }

    //Forge Start
    @Shadow
    public int getElementCount() {
        throw new UnsupportedOperationException();
    }
    //Forge End

    @OnlyIn(Dist.CLIENT)
    public static enum Type {
        FLOAT(4, "Float", 5126),
        UBYTE(1, "Unsigned Byte", 5121),
        BYTE(1, "Byte", 5120),
        USHORT(2, "Unsigned Short", 5123),
        SHORT(2, "Short", 5122),
        UINT(4, "Unsigned Int", 5125),
        INT(4, "Int", 5124);

        @Shadow
        @Final
        private int size;
        @Shadow
        @Final
        private String displayName;
        @Shadow
        @Final
        private int glConstant;

        @Shadow
        private Type(int sizeIn, String displayNameIn, int glConstantIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public int getSize() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public String getDisplayName() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public int getGlConstant() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static enum Usage {
        POSITION("Position", (p_227914_0_, p_227914_1_, p_227914_2_, p_227914_3_, p_227914_5_) -> {
            GlStateManager.vertexPointer(p_227914_0_, p_227914_1_, p_227914_2_, p_227914_3_);
            GlStateManager.enableClientState(32884);
        }, (p_227912_0_) -> {
            GlStateManager.disableClientState(32884);
        }),
        NORMAL("Normal", (p_227913_0_, p_227913_1_, p_227913_2_, p_227913_3_, p_227913_5_) -> {
            GlStateManager.normalPointer(p_227913_1_, p_227913_2_, p_227913_3_);
            GlStateManager.enableClientState(32885);
        }, (p_227910_0_) -> {
            GlStateManager.disableClientState(32885);
        }),
        COLOR("Vertex Color", (p_227911_0_, p_227911_1_, p_227911_2_, p_227911_3_, p_227911_5_) -> {
            GlStateManager.colorPointer(p_227911_0_, p_227911_1_, p_227911_2_, p_227911_3_);
            GlStateManager.enableClientState(32886);
        }, (p_227908_0_) -> {
            GlStateManager.disableClientState(32886);
            GlStateManager.clearCurrentColor();
        }),
        UV("UV", (p_227909_0_, p_227909_1_, p_227909_2_, p_227909_3_, p_227909_5_) -> {
            GlStateManager.clientActiveTexture('\u84c0' + p_227909_5_);
            GlStateManager.texCoordPointer(p_227909_0_, p_227909_1_, p_227909_2_, p_227909_3_);
            GlStateManager.enableClientState(32888);
            GlStateManager.clientActiveTexture(33984);
        }, (p_227906_0_) -> {
            GlStateManager.clientActiveTexture('\u84c0' + p_227906_0_);
            GlStateManager.disableClientState(32888);
            GlStateManager.clientActiveTexture(33984);
        }),
        PADDING("Padding", (p_227907_0_, p_227907_1_, p_227907_2_, p_227907_3_, p_227907_5_) -> {
        }, (p_227904_0_) -> {
        }),
        GENERIC("Generic", (p_227905_0_, p_227905_1_, p_227905_2_, p_227905_3_, p_227905_5_) -> {
            GlStateManager.enableVertexAttribArray(p_227905_5_);
            GlStateManager.vertexAttribPointer(p_227905_5_, p_227905_0_, p_227905_1_, false, p_227905_2_, p_227905_3_);
        }, GlStateManager::glEnableVertexAttribArray);

        @Shadow
        @Final
        private String displayName;
        @Shadow
        @Final
        private VertexFormatElement.Usage.ISetupState setupState;
        @Shadow
        @Final
        private IntConsumer clearState;

        @Shadow
        private Usage(String displayNameIn, VertexFormatElement.Usage.ISetupState setupStateIn, IntConsumer clearStateIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        private void setupBufferState(int countIn, int glTypeIn, int strideIn, long pointerIn, int indexIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public void clearBufferState(int indexIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public String getDisplayName() {
            throw new UnsupportedOperationException();
        }

        @OnlyIn(Dist.CLIENT)
        interface ISetupState {
            @Shadow
            void setupBufferState(int p_setupBufferState_1_, int p_setupBufferState_2_, int p_setupBufferState_3_, long p_setupBufferState_4_, int p_setupBufferState_6_);
        }
    }
}
