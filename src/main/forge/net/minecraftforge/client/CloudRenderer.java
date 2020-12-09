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

package net.minecraftforge.client;

import javax.annotation.Nonnull;
import java.nio.ByteBuffer;
import java.util.function.Predicate;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.options.CloudRenderMode;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.GlAllocationUtils;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.resource.IResourceType;
import net.minecraftforge.resource.ISelectiveResourceReloadListener;
import net.minecraftforge.resource.VanillaResourceType;

public class CloudRenderer implements ISelectiveResourceReloadListener
{
    // Shared constants.
    private static final float PX_SIZE = 1 / 256F;

    // Building constants.
    private static final VertexFormat FORMAT = VertexFormats.POSITION_TEXTURE_COLOR;
    private static final int TOP_SECTIONS = 12;    // Number of slices a top face will span.
    private static final int HEIGHT = 4;
    private static final float INSET = 0.001F;
    private static final float ALPHA = 0.8F;

    // Debug
    private static final boolean WIREFRAME = false;

    // Instance fields
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final Identifier texture = new Identifier("textures/environment/clouds.png");

    private int displayList = -1;
    private VertexBuffer vbo;
    private CloudRenderMode cloudMode = CloudRenderMode.OFF;
    private int renderDistance = -1;

    private NativeImageBackedTexture COLOR_TEX = null;

    private int texW;
    private int texH;

    public CloudRenderer()
    {
        // Resource manager should always be reloadable.
        ((ReloadableResourceManager) mc.getResourceManager()).registerListener(this);
    }

    private int getScale()
    {
        return cloudMode == CloudRenderMode.FANCY ? 12 : 8;
    }

    private float ceilToScale(float value)
    {
        float scale = getScale();
        return MathHelper.ceil(value / scale) * scale;
    }

    private void vertices(BufferBuilder buffer)
    {
        boolean fancy = cloudMode == CloudRenderMode.FANCY;    // Defines whether to hide all but the bottom.

        float scale = getScale();
        float CULL_DIST = 2 * scale;

        float bCol = fancy ? 0.7F : 1F;

        float sectEnd = ceilToScale((renderDistance * 2) * 16);
        float sectStart = -sectEnd;

        float sectStep = ceilToScale(sectEnd * 2 / TOP_SECTIONS);
        float sectPx = PX_SIZE / scale;

        buffer.begin(GL11.GL_QUADS, FORMAT);

        float sectX0 = sectStart;
        float sectX1 = sectX0;

        while (sectX1 < sectEnd)
        {
            sectX1 += sectStep;

            if (sectX1 > sectEnd)
                sectX1 = sectEnd;

            float sectZ0 = sectStart;
            float sectZ1 = sectZ0;

            while (sectZ1 < sectEnd)
            {
                sectZ1 += sectStep;

                if (sectZ1 > sectEnd)
                    sectZ1 = sectEnd;

                float u0 = sectX0 * sectPx;
                float u1 = sectX1 * sectPx;
                float v0 = sectZ0 * sectPx;
                float v1 = sectZ1 * sectPx;

                // Bottom
                buffer.vertex(sectX0, 0, sectZ0).texture(u0, v0).color(bCol, bCol, bCol, ALPHA).next();
                buffer.vertex(sectX1, 0, sectZ0).texture(u1, v0).color(bCol, bCol, bCol, ALPHA).next();
                buffer.vertex(sectX1, 0, sectZ1).texture(u1, v1).color(bCol, bCol, bCol, ALPHA).next();
                buffer.vertex(sectX0, 0, sectZ1).texture(u0, v1).color(bCol, bCol, bCol, ALPHA).next();

                if (fancy)
                {
                    // Top
                    buffer.vertex(sectX0, HEIGHT, sectZ0).texture(u0, v0).color(1, 1, 1, ALPHA).next();
                    buffer.vertex(sectX0, HEIGHT, sectZ1).texture(u0, v1).color(1, 1, 1, ALPHA).next();
                    buffer.vertex(sectX1, HEIGHT, sectZ1).texture(u1, v1).color(1, 1, 1, ALPHA).next();
                    buffer.vertex(sectX1, HEIGHT, sectZ0).texture(u1, v0).color(1, 1, 1, ALPHA).next();

                    float slice;
                    float sliceCoord0;
                    float sliceCoord1;

                    for (slice = sectX0; slice < sectX1;)
                    {
                        sliceCoord0 = slice * sectPx;
                        sliceCoord1 = sliceCoord0 + PX_SIZE;

                        // X sides
                        if (slice > -CULL_DIST)
                        {
                            slice += INSET;
                            buffer.vertex(slice, 0,      sectZ1).texture(sliceCoord0, v1).color(0.9F, 0.9F, 0.9F, ALPHA).next();
                            buffer.vertex(slice, HEIGHT, sectZ1).texture(sliceCoord1, v1).color(0.9F, 0.9F, 0.9F, ALPHA).next();
                            buffer.vertex(slice, HEIGHT, sectZ0).texture(sliceCoord1, v0).color(0.9F, 0.9F, 0.9F, ALPHA).next();
                            buffer.vertex(slice, 0,      sectZ0).texture(sliceCoord0, v0).color(0.9F, 0.9F, 0.9F, ALPHA).next();
                            slice -= INSET;
                        }

                        slice += scale;

                        if (slice <= CULL_DIST)
                        {
                            slice -= INSET;
                            buffer.vertex(slice, 0,      sectZ0).texture(sliceCoord0, v0).color(0.9F, 0.9F, 0.9F, ALPHA).next();
                            buffer.vertex(slice, HEIGHT, sectZ0).texture(sliceCoord1, v0).color(0.9F, 0.9F, 0.9F, ALPHA).next();
                            buffer.vertex(slice, HEIGHT, sectZ1).texture(sliceCoord1, v1).color(0.9F, 0.9F, 0.9F, ALPHA).next();
                            buffer.vertex(slice, 0,      sectZ1).texture(sliceCoord0, v1).color(0.9F, 0.9F, 0.9F, ALPHA).next();
                            slice += INSET;
                        }
                    }

                    for (slice = sectZ0; slice < sectZ1;)
                    {
                        sliceCoord0 = slice * sectPx;
                        sliceCoord1 = sliceCoord0 + PX_SIZE;

                        // Z sides
                        if (slice > -CULL_DIST)
                        {
                            slice += INSET;
                            buffer.vertex(sectX0, 0,      slice).texture(u0, sliceCoord0).color(0.8F, 0.8F, 0.8F, ALPHA).next();
                            buffer.vertex(sectX0, HEIGHT, slice).texture(u0, sliceCoord1).color(0.8F, 0.8F, 0.8F, ALPHA).next();
                            buffer.vertex(sectX1, HEIGHT, slice).texture(u1, sliceCoord1).color(0.8F, 0.8F, 0.8F, ALPHA).next();
                            buffer.vertex(sectX1, 0,      slice).texture(u1, sliceCoord0).color(0.8F, 0.8F, 0.8F, ALPHA).next();
                            slice -= INSET;
                        }

                        slice += scale;

                        if (slice <= CULL_DIST)
                        {
                            slice -= INSET;
                            buffer.vertex(sectX1, 0,      slice).texture(u1, sliceCoord0).color(0.8F, 0.8F, 0.8F, ALPHA).next();
                            buffer.vertex(sectX1, HEIGHT, slice).texture(u1, sliceCoord1).color(0.8F, 0.8F, 0.8F, ALPHA).next();
                            buffer.vertex(sectX0, HEIGHT, slice).texture(u0, sliceCoord1).color(0.8F, 0.8F, 0.8F, ALPHA).next();
                            buffer.vertex(sectX0, 0,      slice).texture(u0, sliceCoord0).color(0.8F, 0.8F, 0.8F, ALPHA).next();
                            slice += INSET;
                        }
                    }
                }

                sectZ0 = sectZ1;
            }

            sectX0 = sectX1;
        }
    }

    private void dispose()
    {
        if (vbo != null)
        {
            vbo.delete();
            vbo = null;
        }
        if (displayList >= 0)
        {
            GlAllocationUtils.deleteSingletonList(displayList);
            displayList = -1;
        }
    }

    private void build()
    {
        Tessellator tess = Tessellator.getInstance();
        BufferBuilder buffer = tess.getBufferBuilder();

        if (GLX.useVbo())
            vbo = new GlBuffer(FORMAT);
        else
            GlStateManager.newList(displayList = GlAllocationUtils.genLists(1), GL11.GL_COMPILE);

        vertices(buffer);

        if (GLX.useVbo())
        {
            buffer.end();
            buffer.clear();
            vbo.set(buffer.getByteBuffer());
        }
        else
        {
            tess.draw();
            GlStateManager.endList();
        }
    }

    private int fullCoord(double coord, int scale)
    {   // Corrects misalignment of UV offset when on negative coords.
        return ((int) coord / scale) - (coord < 0 ? 1 : 0);
    }

    private boolean isBuilt()
    {
        return GLX.useVbo() ? vbo != null : displayList >= 0;
    }

    public void checkSettings()
    {
        boolean newEnabled = ForgeConfig.CLIENT.forgeCloudsEnabled.get()
                && mc.options.getCloudRenderMode() != CloudRenderMode.OFF
                && mc.world != null
                && mc.world.dimension.hasVisibleSky();

        if (isBuilt()
                    && (!newEnabled
                    || mc.options.getCloudRenderMode() != cloudMode
                    || mc.options.viewDistance != renderDistance))
        {
            dispose();
        }

        cloudMode = mc.options.getCloudRenderMode();
        renderDistance = mc.options.viewDistance;

        if (newEnabled && !isBuilt())
        {
            build();
        }
    }

    public boolean render(int cloudTicks, float partialTicks)
    {
        if (!isBuilt())
            return false;

        Entity entity = mc.getCameraEntity();

        double totalOffset = cloudTicks + partialTicks;

        double x = entity.prevX + (entity.x - entity.prevX) * partialTicks
                + totalOffset * 0.03;
        double y = mc.world.dimension.getCloudHeight()
                - (entity.lastRenderY + (entity.y - entity.lastRenderY) * partialTicks)
                + 0.33;
        double z = entity.prevZ + (entity.z - entity.prevZ) * partialTicks;

        int scale = getScale();

        if (cloudMode == CloudRenderMode.FANCY)
            z += 0.33 * scale;

        // Integer UVs to translate the texture matrix by.
        int offU = fullCoord(x, scale);
        int offV = fullCoord(z, scale);

        GlStateManager.pushMatrix();

        // Translate by the remainder after the UV offset.
        GlStateManager.translated((offU * scale) - x, y, (offV * scale) - z);

        // Modulo to prevent texture samples becoming inaccurate at extreme offsets.
        offU = offU % texW;
        offV = offV % texH;

        // Translate the texture.
        GlStateManager.matrixMode(GL11.GL_TEXTURE);
        GlStateManager.translatef(offU * PX_SIZE, offV * PX_SIZE, 0);
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);

        GlStateManager.disableCull();

        GlStateManager.enableBlend();
        GlStateManager.blendFuncSeparate(
                GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        // Color multiplier.
        Vec3d color = mc.world.getCloudColor(partialTicks);
        float r = (float) color.x;
        float g = (float) color.y;
        float b = (float) color.z;

        if (COLOR_TEX == null)
            COLOR_TEX = new NativeImageBackedTexture(1, 1, false);

        // Apply a color multiplier through a texture upload if shaders aren't supported.
        COLOR_TEX.getImage().setPixelRgba(0, 0, 255 << 24
                | ((int) (r * 255)) << 16
                | ((int) (g * 255)) << 8
                | (int) (b * 255));
        COLOR_TEX.upload();

        GlStateManager.activeTexture(GLX.GL_TEXTURE1);
        GlStateManager.bindTexture(COLOR_TEX.getGlId());
        GlStateManager.enableTexture();

        // Bind the clouds texture last so the shader's sampler2D is correct.
        GlStateManager.activeTexture(GLX.GL_TEXTURE0);
        mc.textureManager.bindTexture(texture);

        ByteBuffer buffer = Tessellator.getInstance().getBufferBuilder().getByteBuffer();

        // Set up pointers for the display list/VBO.
        if (GLX.useVbo())
        {
            vbo.bind();

            int stride = FORMAT.getVertexSize();
            GlStateManager.vertexPointer(3, GL11.GL_FLOAT, stride, 0);
            GlStateManager.enableClientState(GL11.GL_VERTEX_ARRAY);
            GlStateManager.texCoordPointer(2, GL11.GL_FLOAT, stride, 12);
            GlStateManager.enableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
            GlStateManager.colorPointer(4, GL11.GL_UNSIGNED_BYTE, stride, 20);
            GlStateManager.enableClientState(GL11.GL_COLOR_ARRAY);
        }
        else
        {
            buffer.limit(FORMAT.getVertexSize());
            for (int i = 0; i < FORMAT.getElementCount(); i++)
                FORMAT.getElements().get(i).getType().preDraw(FORMAT, i, FORMAT.getVertexSize(), buffer);
            buffer.position(0);
        }

        // Depth pass to prevent insides rendering from the outside.
        GlStateManager.colorMask(false, false, false, false);
        if (GLX.useVbo())
            vbo.draw(GL11.GL_QUADS);
        else
            GlStateManager.callList(displayList);

        // Full render.
        GlStateManager.colorMask(true, true, true, true);

        // Wireframe for debug.
        if (WIREFRAME)
        {
            GlStateManager.polygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
            GlStateManager.lineWidth(2.0F);
            GlStateManager.disableTexture();
            GlStateManager.depthMask(false);
            GlStateManager.disableFog();
            if (GLX.useVbo())
                vbo.draw(GL11.GL_QUADS);
            else
                GlStateManager.callList(displayList);
            GlStateManager.polygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture();
            GlStateManager.enableFog();
        }

        if (GLX.useVbo())
        {
            vbo.draw(GL11.GL_QUADS);
            vbo.unbind(); // Unbind buffer and disable pointers.
        }
        else
        {
            GlStateManager.callList(displayList);
        }

        buffer.limit(0);
        for (int i = 0; i < FORMAT.getElementCount(); i++)
            FORMAT.getElements().get(i).getType().postDraw(FORMAT, i, FORMAT.getVertexSize(), buffer);
        buffer.position(0);

        // Disable our coloring.
        GlStateManager.activeTexture(GLX.GL_TEXTURE1);
        GlStateManager.disableTexture();
        GlStateManager.activeTexture(GLX.GL_TEXTURE0);

        // Reset texture matrix.
        GlStateManager.matrixMode(GL11.GL_TEXTURE);
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);

        GlStateManager.disableBlend();
        GlStateManager.enableCull();

        GlStateManager.popMatrix();

        return true;
    }

    private void reloadTextures()
    {
        if (mc.textureManager != null)
        {
            mc.textureManager.bindTexture(texture);
            texW = GlStateManager.getTexLevelParameter(GL11.GL_TEXTURE_2D, 0, GL11.GL_TEXTURE_WIDTH);
            texH = GlStateManager.getTexLevelParameter(GL11.GL_TEXTURE_2D, 0, GL11.GL_TEXTURE_HEIGHT);
        }
    }

    @Override
    public void onResourceManagerReload(@Nonnull ResourceManager resourceManager, @Nonnull Predicate<IResourceType> resourcePredicate)
    {
        if (resourcePredicate.test(VanillaResourceType.TEXTURES))
        {
            reloadTextures();
        }
    }

    private static CloudRenderer cloudRenderer;
    private static CloudRenderer getCloudRenderer()
    {
        if (cloudRenderer == null)
            cloudRenderer = new CloudRenderer();
        return cloudRenderer;
    }

    public static void updateCloudSettings()
    {
        getCloudRenderer().checkSettings();
    }

    public static boolean renderClouds(int cloudTicks, float partialTicks, ClientWorld world, MinecraftClient client)
    {
        IRenderHandler renderer = world.dimension.getCloudRenderer();
        if (renderer != null)
        {
            renderer.render(cloudTicks, partialTicks, world, client);
            return true;
        }
        return getCloudRenderer().render(cloudTicks, partialTicks);
    }

}
