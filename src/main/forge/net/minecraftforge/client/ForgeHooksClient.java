/*
 * Minecraft Forge
 * Copyright (c) 2016-2019.
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

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.input.Input;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormatElement;
import net.minecraft.client.render.VertexFormatElement.Type;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.BasicBakedModel;
import net.minecraft.client.render.model.ModelRotation;
import net.minecraft.client.render.model.json.ModelElementTexture;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.render.model.json.Transformation;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundSystem;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.Window;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.RecipesUpdatedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.ScreenshotEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.model.ModelDynBucket;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.client.model.pipeline.QuadGatheringTransformer;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.model.IModelPart;
import net.minecraftforge.common.model.ITransformation;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.resource.ReloadRequirements;
import net.minecraftforge.resource.SelectiveReloadStateHandler;
import net.minecraftforge.resource.VanillaResourceType;
import net.minecraftforge.versions.forge.ForgeVersion;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.async.ThreadNameCachingStrategy;
import org.apache.logging.log4j.core.impl.ReusableLogEventFactory;
import org.lwjgl.BufferUtils;

import javax.annotation.Nonnull;
import javax.vecmath.Matrix3f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.*;

import static net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType.BOSSINFO;
import static net.minecraftforge.fml.VersionChecker.Status.BETA;
import static net.minecraftforge.fml.VersionChecker.Status.BETA_OUTDATED;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public class ForgeHooksClient
{
    private static final Logger LOGGER = LogManager.getLogger();

    //private static final ResourceLocation ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");

    public static String getArmorTexture(Entity entity, ItemStack armor, String _default, EquipmentSlot slot, String type)
    {
        String result = armor.getItem().getArmorTexture(armor, entity, slot, type);
        return result != null ? result : _default;
    }

    public static boolean onDrawBlockHighlight(WorldRenderer context, Camera info, HitResult target, int subID, float partialTicks)
    {
        switch (target.getType()) {
            case BLOCK:
                if (!(target instanceof BlockHitResult)) return false;
                return MinecraftForge.EVENT_BUS.post(new DrawBlockHighlightEvent.HighlightBlock(context, info, target, subID, partialTicks));
            case ENTITY:
                if (!(target instanceof EntityHitResult)) return false;
                return MinecraftForge.EVENT_BUS.post(new DrawBlockHighlightEvent.HighlightEntity(context, info, target, subID, partialTicks));
        }
        return MinecraftForge.EVENT_BUS.post(new DrawBlockHighlightEvent(context, info, target, subID, partialTicks));
    }

    public static void dispatchRenderLast(WorldRenderer context, float partialTicks)
    {
        MinecraftForge.EVENT_BUS.post(new RenderWorldLastEvent(context, partialTicks));
    }

    public static boolean renderFirstPersonHand(WorldRenderer context, float partialTicks)
    {
        return MinecraftForge.EVENT_BUS.post(new RenderHandEvent(context, partialTicks));
    }

    public static boolean renderSpecificFirstPersonHand(Hand hand, float partialTicks, float interpPitch, float swingProgress, float equipProgress, ItemStack stack)
    {
        return MinecraftForge.EVENT_BUS.post(new RenderSpecificHandEvent(hand, partialTicks, interpPitch, swingProgress, equipProgress, stack));
    }

    public static void onTextureStitchedPre(SpriteAtlasTexture map, Set<Identifier> resourceLocations)
    {
        ModLoader.get().postEvent(new TextureStitchEvent.Pre(map, resourceLocations));
//        ModelLoader.White.INSTANCE.register(map); // TODO Custom TAS
    }

    public static void onTextureStitchedPost(SpriteAtlasTexture map)
    {
        ModLoader.get().postEvent(new TextureStitchEvent.Post(map));
    }

    public static void onBlockColorsInit(BlockColors blockColors)
    {
        ModLoader.get().postEvent(new ColorHandlerEvent.Block(blockColors));
    }

    public static void onItemColorsInit(ItemColors itemColors, BlockColors blockColors)
    {
        ModLoader.get().postEvent(new ColorHandlerEvent.Item(itemColors, blockColors));
    }

    static final ThreadLocal<RenderLayer> renderLayer = new ThreadLocal<RenderLayer>();

    public static void setRenderLayer(RenderLayer layer)
    {
        renderLayer.set(layer);
    }

    public static <A extends BipedEntityModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot slot, A _default)
    {
        A model = itemStack.getItem().getArmorModel(entityLiving, itemStack, slot, _default);
        return model == null ? _default : model;
    }

    //This properly moves the domain, if provided, to the front of the string before concatenating
    public static String fixDomain(String base, String complex)
    {
        int idx = complex.indexOf(':');
        if (idx == -1)
        {
            return base + complex;
        }

        String name = complex.substring(idx + 1, complex.length());
        if (idx > 1)
        {
            String domain = complex.substring(0, idx);
            return domain + ':' + base + name;
        }
        else
        {
            return base + name;
        }
    }
/* TODO mouse input
    public static boolean postMouseEvent()
    {
        return MinecraftForge.EVENT_BUS.post(new MouseEvent());
    }
*/
    public static float getOffsetFOV(PlayerEntity entity, float fov)
    {
        FOVUpdateEvent fovUpdateEvent = new FOVUpdateEvent(entity, fov);
        MinecraftForge.EVENT_BUS.post(fovUpdateEvent);
        return fovUpdateEvent.getNewfov();
    }

    public static double getFOVModifier(GameRenderer renderer, Camera info, double renderPartialTicks, double fov) {
        EntityViewRenderEvent.FOVModifier event = new EntityViewRenderEvent.FOVModifier(renderer, info, renderPartialTicks, fov);
        MinecraftForge.EVENT_BUS.post(event);
        return event.getFOV();
    }

    private static int skyX, skyZ;

    private static boolean skyInit;
    private static int skyRGBMultiplier;

    public static int getSkyBlendColour(World world, BlockPos center)
    {
        if (center.getX() == skyX && center.getZ() == skyZ && skyInit)
        {
            return skyRGBMultiplier;
        }
        skyInit = true;

        GameOptions settings = MinecraftClient.getInstance().options;
        int[] ranges = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34 };
        int distance = 0;
        if (settings.fancyGraphics && ranges.length > 0)
        {
            distance = ranges[MathHelper.clamp(settings.viewDistance, 0, ranges.length-1)];
        }

        int r = 0;
        int g = 0;
        int b = 0;

        int divider = 0;
        for (int x = -distance; x <= distance; ++x)
        {
            for (int z = -distance; z <= distance; ++z)
            {
                BlockPos pos = center.add(x, 0, z);
                Biome biome = world.getBiome(pos);
                int colour = biome.getSkyColor(biome.computeTemperature(pos));
                r += (colour & 0xFF0000) >> 16;
                g += (colour & 0x00FF00) >> 8;
                b += colour & 0x0000FF;
                divider++;
            }
        }

        int multiplier = (r / divider & 255) << 16 | (g / divider & 255) << 8 | b / divider & 255;

        skyX = center.getX();
        skyZ = center.getZ();
        skyRGBMultiplier = multiplier;
        return skyRGBMultiplier;
    }
    /**
     * Initialization of Forge Renderers.
     */
    static
    {
        //FluidRegistry.renderIdFluid = RenderingRegistry.getNextAvailableRenderId();
        //RenderingRegistry.registerBlockHandler(RenderBlockFluid.instance);
    }

    public static void renderMainMenu(TitleScreen gui, TextRenderer font, int width, int height)
    {
        VersionChecker.Status status = ForgeVersion.getStatus();
        if (status == BETA || status == BETA_OUTDATED)
        {
            // render a warning at the top of the screen,
            String line = I18n.translate("forge.update.beta.1", Formatting.RED, Formatting.RESET);
            gui.drawString(font, line, (width - font.getStringWidth(line)) / 2, 4 + (0 * (font.fontHeight + 1)), -1);
            line = I18n.translate("forge.update.beta.2");
            gui.drawString(font, line, (width - font.getStringWidth(line)) / 2, 4 + (1 * (font.fontHeight + 1)), -1);
        }

        String line = null;
        switch(status)
        {
            //case FAILED:        line = " Version check failed"; break;
            //case UP_TO_DATE:    line = "Forge up to date"}; break;
            //case AHEAD:         line = "Using non-recommended Forge build, issues may arise."}; break;
            case OUTDATED:
            case BETA_OUTDATED: line = I18n.translate("forge.update.newversion", ForgeVersion.getTarget()); break;
            default: break;
        }

        forgeStatusLine = line;
    }

    public static String forgeStatusLine;
    public static SoundInstance playSound(SoundSystem manager, SoundInstance sound)
    {
        PlaySoundEvent e = new PlaySoundEvent(manager, sound);
        MinecraftForge.EVENT_BUS.post(e);
        return e.getResultSound();
    }

    //static RenderBlocks VertexBufferRB;
    static int worldRenderPass;

    public static int getWorldRenderPass()
    {
        return worldRenderPass;
    }

    public static void drawScreen(Screen screen, int mouseX, int mouseY, float partialTicks)
    {
        if (!MinecraftForge.EVENT_BUS.post(new GuiScreenEvent.DrawScreenEvent.Pre(screen, mouseX, mouseY, partialTicks)))
            screen.render(mouseX, mouseY, partialTicks);
        MinecraftForge.EVENT_BUS.post(new GuiScreenEvent.DrawScreenEvent.Post(screen, mouseX, mouseY, partialTicks));
    }

    public static float getFogDensity(BackgroundRenderer fogRenderer, GameRenderer renderer, Camera info, float partial, float density)
    {
        EntityViewRenderEvent.FogDensity event = new EntityViewRenderEvent.FogDensity(fogRenderer, renderer, info, partial, density);
        if (MinecraftForge.EVENT_BUS.post(event)) return event.getDensity();
        return -1;
    }

    public static void onFogRender(BackgroundRenderer fogRenderer, GameRenderer renderer, Camera info, float partial, int mode, float distance)
    {
        MinecraftForge.EVENT_BUS.post(new EntityViewRenderEvent.RenderFogEvent(fogRenderer, renderer, info, partial, mode, distance));
    }

    public static EntityViewRenderEvent.CameraSetup onCameraSetup(GameRenderer renderer, Camera info, float partial, float yaw, float pitch, float roll)
    {
        EntityViewRenderEvent.CameraSetup event = new EntityViewRenderEvent.CameraSetup(renderer, info, partial, yaw, pitch, roll);
        MinecraftForge.EVENT_BUS.post(event);
        return event;
    }

    public static void onModelBake(BakedModelManager modelManager, Map<Identifier, BakedModel> modelRegistry, ModelLoader modelLoader)
    {
        ModLoader.get().postEvent(new ModelBakeEvent(modelManager, modelRegistry, modelLoader));
        modelLoader.onPostBakeEvent(modelRegistry);
    }

    @SuppressWarnings("deprecation")
    public static Matrix4f getMatrix(Transformation transform)
    {
        Matrix4f m = new Matrix4f(), t = new Matrix4f();
        m.setIdentity();
        m.setTranslation(TRSRTransformation.toVecmath(transform.translation));
        t.setIdentity();
        t.rotY(transform.rotation.y());
        m.mul(t);
        t.setIdentity();
        t.rotX(transform.rotation.x());
        m.mul(t);
        t.setIdentity();
        t.rotZ(transform.rotation.z());
        m.mul(t);
        t.setIdentity();
        t.m00 = transform.scale.x();
        t.m11 = transform.scale.y();
        t.m22 = transform.scale.z();
        m.mul(t);
        return m;
    }

    private static final Matrix4f flipX;
    static {
        flipX = new Matrix4f();
        flipX.setIdentity();
        flipX.m00 = -1;
    }

    public static BakedModel handleCameraTransforms(BakedModel model, ModelTransformation.Type cameraTransformType, boolean leftHandHackery)
    {
        Pair<? extends BakedModel, Matrix4f> pair = model.handlePerspective(cameraTransformType);

        if (pair.getRight() != null)
        {
            Matrix4f matrix = new Matrix4f(pair.getRight());
            if (leftHandHackery)
            {
                matrix.mul(flipX, matrix);
                matrix.mul(matrix, flipX);
            }
            multiplyCurrentGlMatrix(matrix);
        }
        return pair.getLeft();
    }

    private static final FloatBuffer matrixBuf = BufferUtils.createFloatBuffer(16);

    public static void multiplyCurrentGlMatrix(Matrix4f matrix)
    {
        matrixBuf.clear();
        float[] t = new float[4];
        for(int i = 0; i < 4; i++)
        {
            matrix.getColumn(i, t);
            matrixBuf.put(t);
        }
        matrixBuf.flip();
        glMultMatrixf(matrixBuf);
    }

    // moved and expanded from WorldVertexBufferUploader.draw

    public static void preDraw(Type attrType, VertexFormat format, int element, int stride, ByteBuffer buffer)
    {
        VertexFormatElement attr = format.getElement(element);
        int count = attr.getCount();
        int constant = attr.getFormat().getGlId();
        buffer.position(format.getElementOffset(element));
        switch(attrType)
        {
            case POSITION:
                glVertexPointer(count, constant, stride, buffer);
                glEnableClientState(GL_VERTEX_ARRAY);
                break;
            case NORMAL:
                if(count != 3)
                {
                    throw new IllegalArgumentException("Normal attribute should have the size 3: " + attr);
                }
                glNormalPointer(constant, stride, buffer);
                glEnableClientState(GL_NORMAL_ARRAY);
                break;
            case COLOR:
                glColorPointer(count, constant, stride, buffer);
                glEnableClientState(GL_COLOR_ARRAY);
                break;
            case UV:
                GLX.glClientActiveTexture(GLX.GL_TEXTURE0 + attr.getIndex());
                glTexCoordPointer(count, constant, stride, buffer);
                glEnableClientState(GL_TEXTURE_COORD_ARRAY);
                GLX.glClientActiveTexture(GLX.GL_TEXTURE0);
                break;
            case PADDING:
                break;
            case GENERIC:
                glEnableVertexAttribArray(attr.getIndex());
                glVertexAttribPointer(attr.getIndex(), count, constant, false, stride, buffer);
                break;
            default:
                LOGGER.fatal("Unimplemented vanilla attribute upload: {}", attrType.getName());
        }
    }

    public static void postDraw(Type attrType, VertexFormat format, int element, int stride, ByteBuffer buffer)
    {
        VertexFormatElement attr = format.getElement(element);
        switch(attrType)
        {
            case POSITION:
                glDisableClientState(GL_VERTEX_ARRAY);
                break;
            case NORMAL:
                glDisableClientState(GL_NORMAL_ARRAY);
                break;
            case COLOR:
                glDisableClientState(GL_COLOR_ARRAY);
                // is this really needed?
                GlStateManager.clearCurrentColor();
                break;
            case UV:
                GLX.glClientActiveTexture(GLX.GL_TEXTURE0 + attr.getIndex());
                glDisableClientState(GL_TEXTURE_COORD_ARRAY);
                GLX.glClientActiveTexture(GLX.GL_TEXTURE0);
                break;
            case PADDING:
                break;
            case GENERIC:
                glDisableVertexAttribArray(attr.getIndex());
                break;
            default:
                LOGGER.fatal("Unimplemented vanilla attribute upload: {}", attrType.getName());
        }
    }

    public static void transform(net.minecraft.client.util.math.Vector3f vec, Matrix4f m)
    {
        Vector4f tmp = new Vector4f(vec.x(), vec.y(), vec.z(), 1f);
        m.transform(tmp);
        if(Math.abs(tmp.w - 1f) > 1e-5) tmp.scale(1f / tmp.w);
        vec.set(tmp.x, tmp.y, tmp.z);
    }

    public static Matrix4f getMatrix(ModelRotation modelRotation)
    {
        Matrix4f ret = new Matrix4f(TRSRTransformation.toVecmath(modelRotation.getQuaternion()), new Vector3f(), 1), tmp = new Matrix4f();
        tmp.setIdentity();
        tmp.m03 = tmp.m13 = tmp.m23 = .5f;
        ret.mul(tmp, ret);
        tmp.invert();
        //tmp.m03 = tmp.m13 = tmp.m23 = -.5f;
        ret.mul(tmp);
        return ret;
    }

    public static void putQuadColor(BufferBuilder renderer, BakedQuad quad, int color)
    {
        float cb = color & 0xFF;
        float cg = (color >>> 8) & 0xFF;
        float cr = (color >>> 16) & 0xFF;
        float ca = (color >>> 24) & 0xFF;
        VertexFormat format = quad.getFormat();
        int size = format.getVertexSizeInteger();
        int offset = format.getColorOffset() / 4; // assumes that color is aligned
        boolean hasColor = format.hasColorElement();
        for(int i = 0; i < 4; i++)
        {
            int vc = hasColor ? quad.getVertexData()[offset + size * i] : 0xFFFFFFFF;
            float vcr = vc & 0xFF;
            float vcg = (vc >>> 8) & 0xFF;
            float vcb = (vc >>> 16) & 0xFF;
            float vca = (vc >>> 24) & 0xFF;
            int ncr = Math.min(0xFF, (int)(cr * vcr / 0xFF));
            int ncg = Math.min(0xFF, (int)(cg * vcg / 0xFF));
            int ncb = Math.min(0xFF, (int)(cb * vcb / 0xFF));
            int nca = Math.min(0xFF, (int)(ca * vca / 0xFF));
            renderer.putColorRGBA(renderer.getColorIndex(4 - i), ncr, ncg, ncb, nca);
        }
    }

    public static Sprite[] getFluidSprites(BlockRenderView world, BlockPos pos, FluidState fluidStateIn)
    {
        SpriteAtlasTexture atlas = MinecraftClient.getInstance().getSpriteAtlas();
        return new Sprite[] {
                atlas.getSprite(fluidStateIn.getFluid().getAttributes().getStill(world, pos)),
                atlas.getSprite(fluidStateIn.getFluid().getAttributes().getFlowing(world, pos)),
        };
    }

    public static void gatherFluidTextures(Set<Identifier> textures)
    {
        ForgeRegistries.FLUIDS.getValues().stream()
                .flatMap(f -> f.getAttributes().getTextures())
                .filter(Objects::nonNull)
                .forEach(textures::add);
    }

    private static class LightGatheringTransformer extends QuadGatheringTransformer {

        private static final VertexFormat FORMAT = new VertexFormat().add(VertexFormats.TEXTURE_ELEMENT).add(VertexFormats.OVERLAY_ELEMENT);

        int blockLight, skyLight;

        { setVertexFormat(FORMAT); }

        boolean hasLighting()
        {
            return dataLength[1] >= 2;
        }

        @Override
        protected void processQuad()
        {
            // Reset light data
            blockLight = 0;
            skyLight = 0;
            // Compute average light for all 4 vertices
            for (int i = 0; i < 4; i++)
            {
                blockLight += (int) ((quadData[1][i][0] * 0xFFFF) / 0x20);
                skyLight += (int) ((quadData[1][i][1] * 0xFFFF) / 0x20);
            }
            // Values must be multiplied by 16, divided by 4 for average => x4
            blockLight *= 4;
            skyLight *= 4;
        }

        // Dummy overrides

        @Override
        public void setQuadTint(int tint) {}

        @Override
        public void setQuadOrientation(Direction orientation) {}

        @Override
        public void setApplyDiffuseLighting(boolean diffuse) {}

        @Override
        public void setTexture(Sprite texture) {}
    }

    private static final LightGatheringTransformer lightGatherer = new LightGatheringTransformer();

    public static void renderLitItem(ItemRenderer ri, BakedModel model, int color, ItemStack stack)
    {
        List<BakedQuad> allquads = new ArrayList<>();
        Random random = new Random();
        long seed = 42L;

        for (Direction enumfacing : Direction.values())
        {
            random.setSeed(seed);
            allquads.addAll(model.getQuads(null, enumfacing, random));
        }

        random.setSeed(seed);
        allquads.addAll(model.getQuads(null, null, random));

        if (allquads.isEmpty()) return;

        // Current list of consecutive quads with the same lighting
        List<BakedQuad> segment = new ArrayList<>();

        // Lighting of the current segment
        int segmentBlockLight = 0;
        int segmentSkyLight = 0;
        // Diffuse lighting state
        boolean segmentShading = true;
        // State changed by the current segment
        boolean segmentLightingDirty = false;
        boolean segmentShadingDirty = false;
        // If the current segment contains lighting data
        boolean hasLighting = false;

        for (int i = 0; i < allquads.size(); i++)
        {
            BakedQuad q = allquads.get(i);

            // Lighting of the current quad
            int bl = 0;
            int sl = 0;

            // Fail-fast on ITEM, as it cannot have light data
            if (q.getFormat() != VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL && q.getFormat().hasUvElement(1))
            {
                q.pipe(lightGatherer);
                if (lightGatherer.hasLighting())
                {
                    bl = lightGatherer.blockLight;
                    sl = lightGatherer.skyLight;
                }
            }

            boolean shade = q.shouldApplyDiffuseLighting();

            boolean lightingDirty = segmentBlockLight != bl || segmentSkyLight != sl;
            boolean shadeDirty = shade != segmentShading;

            // If lighting or color data has changed, draw the segment and flush it
            if (lightingDirty || shadeDirty)
            {
                if (i > 0) // Make sure this isn't the first quad being processed
                {
                    drawSegment(ri, color, stack, segment, segmentBlockLight, segmentSkyLight, segmentShading, segmentLightingDirty && (hasLighting || segment.size() < i), segmentShadingDirty);
                }
                segmentBlockLight = bl;
                segmentSkyLight = sl;
                segmentShading = shade;
                segmentLightingDirty = lightingDirty;
                segmentShadingDirty = shadeDirty;
                hasLighting = segmentBlockLight > 0 || segmentSkyLight > 0 || !segmentShading;
            }

            segment.add(q);
        }

        drawSegment(ri, color, stack, segment, segmentBlockLight, segmentSkyLight, segmentShading, segmentLightingDirty && (hasLighting || segment.size() < allquads.size()), segmentShadingDirty);

        // Clean up render state if necessary
        if (hasLighting)
        {
            GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, GLX.lastBrightnessX, GLX.lastBrightnessY);
            GlStateManager.enableLighting();
        }
    }

    private static void drawSegment(ItemRenderer ri, int baseColor, ItemStack stack, List<BakedQuad> segment, int bl, int sl, boolean shade, boolean updateLighting, boolean updateShading)
    {
        BufferBuilder bufferbuilder = Tessellator.getInstance().getBuffer();
        bufferbuilder.begin(GL_QUADS, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL);

        float lastBl = GLX.lastBrightnessX;
        float lastSl = GLX.lastBrightnessY;

        if (updateShading)
        {
            if (shade)
            {
                // (Re-)enable lighting for normal look with shading
                GlStateManager.enableLighting();
            }
            else
            {
                // Disable lighting to simulate a lack of diffuse lighting
                GlStateManager.disableLighting();
            }
        }

        if (updateLighting)
        {
            // Force lightmap coords to simulate synthetic lighting
            GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, Math.max(bl, lastBl), Math.max(sl, lastSl));
        }

        ri.renderQuads(bufferbuilder, segment, baseColor, stack);
        Tessellator.getInstance().draw();

        // Preserve this as it represents the "world" lighting
        GLX.lastBrightnessX = lastBl;
        GLX.lastBrightnessY = lastSl;

        segment.clear();
    }

    /**
     * internal, relies on fixed format of FaceBakery
     */
    public static void fillNormal(int[] faceData, Direction facing)
    {
        Vector3f v1 = getVertexPos(faceData, 3);
        Vector3f t  = getVertexPos(faceData, 1);
        Vector3f v2 = getVertexPos(faceData, 2);
        v1.sub(t);
        t.set(getVertexPos(faceData, 0));
        v2.sub(t);
        v1.cross(v2, v1);
        v1.normalize();

        int x = ((byte) Math.round(v1.x * 127)) & 0xFF;
        int y = ((byte) Math.round(v1.y * 127)) & 0xFF;
        int z = ((byte) Math.round(v1.z * 127)) & 0xFF;

        int normal = x | (y << 0x08) | (z << 0x10);

        for(int i = 0; i < 4; i++)
        {
            faceData[i * 7 + 6] = normal;
        }
    }

    private static Vector3f getVertexPos(int[] data, int vertex)
    {
        int idx = vertex * 7;

        float x = Float.intBitsToFloat(data[idx]);
        float y = Float.intBitsToFloat(data[idx + 1]);
        float z = Float.intBitsToFloat(data[idx + 2]);

        return new Vector3f(x, y, z);
    }

    @SuppressWarnings("deprecation")
    public static Optional<TRSRTransformation> applyTransform(Transformation transform, Optional<? extends IModelPart> part)
    {
        if(part.isPresent()) return Optional.empty();
        return Optional.of(TRSRTransformation.blockCenterToCorner(TRSRTransformation.from(transform)));
    }

    public static Optional<TRSRTransformation> applyTransform(ModelRotation rotation, Optional<? extends IModelPart> part)
    {
        if(part.isPresent()) return Optional.empty();
        return Optional.of(TRSRTransformation.from(rotation));
    }

    public static Optional<TRSRTransformation> applyTransform(Matrix4f matrix, Optional<? extends IModelPart> part)
    {
        if(part.isPresent()) return Optional.empty();
        return Optional.of(new TRSRTransformation(matrix));
    }

    public static void loadEntityShader(Entity entity, GameRenderer entityRenderer)
    {
        if (entity != null)
        {
            Identifier shader = ClientRegistry.getEntityShader(entity.getClass());
            if (shader != null)
            {
                entityRenderer.loadShader(shader);
            }
        }
    }

    public static BakedModel getDamageModel(BakedModel ibakedmodel, Sprite texture, BlockState state, BlockRenderView world, BlockPos pos, long randomPosition)
    {
        state = state.getBlock().getExtendedState(state, world, pos);
        return (new BasicBakedModel.Builder(state, ibakedmodel, texture, new Random(), randomPosition)).build();
    }

    private static int slotMainHand = 0;

    public static boolean shouldCauseReequipAnimation(@Nonnull ItemStack from, @Nonnull ItemStack to, int slot)
    {
        boolean fromInvalid = from.isEmpty();
        boolean toInvalid   = to.isEmpty();

        if (fromInvalid && toInvalid) return false;
        if (fromInvalid || toInvalid) return true;

        boolean changed = false;
        if (slot != -1)
        {
            changed = slot != slotMainHand;
            slotMainHand = slot;
        }
        return from.getItem().shouldCauseReequipAnimation(from, to, changed);
    }

    public static ModelElementTexture applyUVLock(ModelElementTexture blockFaceUV, Direction originalSide, ITransformation rotation)
    {
        TRSRTransformation global = new TRSRTransformation(rotation.getMatrixVec());
        Matrix4f uv = global.getUVLockTransform(originalSide).getMatrixVec();
        Vector4f vec = new Vector4f(0, 0, 0, 1);
        float u0 = blockFaceUV.getU(blockFaceUV.method_3414(0));
        float v0 = blockFaceUV.getV(blockFaceUV.method_3414(0));
        vec.x = u0 / 16;
        vec.y = v0 / 16;
        uv.transform(vec);
        float uMin = 16 * vec.x; // / vec.w;
        float vMin = 16 * vec.y; // / vec.w;
        float u1 = blockFaceUV.getU(blockFaceUV.method_3414(2));
        float v1 = blockFaceUV.getV(blockFaceUV.method_3414(2));
        vec.x = u1 / 16;
        vec.y = v1 / 16;
        vec.z = 0;
        vec.w = 1;
        uv.transform(vec);
        float uMax = 16 * vec.x; // / vec.w;
        float vMax = 16 * vec.y; // / vec.w;
        if (uMin > uMax && u0 < u1 || uMin < uMax && u0 > u1)
        {
            float t = uMin;
            uMin = uMax;
            uMax = t;
        }
        if (vMin > vMax && v0 < v1 || vMin < vMax && v0 > v1)
        {
            float t = vMin;
            vMin = vMax;
            vMax = t;
        }
        float a = (float)Math.toRadians(blockFaceUV.rotation);
        Vector3f rv = new Vector3f(MathHelper.cos(a), MathHelper.sin(a), 0);
        Matrix3f rot = new Matrix3f();
        uv.getRotationScale(rot);
        rot.transform(rv);
        int angle = MathHelper.floorMod(-(int)Math.round(Math.toDegrees(Math.atan2(rv.y, rv.x)) / 90) * 90, 360);
        return new ModelElementTexture(new float[]{ uMin, vMin, uMax, vMax }, angle);
    }

    public static RenderGameOverlayEvent.BossInfo bossBarRenderPre(Window res, ClientBossBar bossInfo, int x, int y, int increment)
    {
        RenderGameOverlayEvent.BossInfo evt = new RenderGameOverlayEvent.BossInfo(new RenderGameOverlayEvent(Animation.getPartialTickTime(), res),
                BOSSINFO, bossInfo, x, y, increment);
        MinecraftForge.EVENT_BUS.post(evt);
        return evt;
    }

    public static void bossBarRenderPost(Window res)
    {
        MinecraftForge.EVENT_BUS.post(new RenderGameOverlayEvent.Post(new RenderGameOverlayEvent(Animation.getPartialTickTime(), res), BOSSINFO));
    }

    public static ScreenshotEvent onScreenshot(NativeImage image, File screenshotFile)
    {
        ScreenshotEvent event = new ScreenshotEvent(image, screenshotFile);
        MinecraftForge.EVENT_BUS.post(event);
        return event;
    }

    @SuppressWarnings("deprecation")
    public static Pair<? extends BakedModel,Matrix4f> handlePerspective(BakedModel model, ModelTransformation.Type type)
    {
        TRSRTransformation tr = TRSRTransformation.from(model.getTransformation().getTransformation(type));
        Matrix4f mat = null;
        if(!tr.equals(TRSRTransformation.identity())) mat = tr.getMatrixVec();
        return Pair.of(model, mat);
    }

    public static void onInputUpdate(PlayerEntity player, Input movementInput)
    {
        MinecraftForge.EVENT_BUS.post(new InputUpdateEvent(player, movementInput));
    }

    public static void refreshResources(MinecraftClient mc, VanillaResourceType... types) {
        SelectiveReloadStateHandler.INSTANCE.beginReload(ReloadRequirements.include(types));
        mc.reloadResources();
        SelectiveReloadStateHandler.INSTANCE.endReload();
    }

    public static boolean onGuiMouseClickedPre(Screen guiScreen, double mouseX, double mouseY, int button)
    {
        Event event = new GuiScreenEvent.MouseClickedEvent.Pre(guiScreen, mouseX, mouseY, button);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiMouseClickedPost(Screen guiScreen, double mouseX, double mouseY, int button)
    {
        Event event = new GuiScreenEvent.MouseClickedEvent.Post(guiScreen, mouseX, mouseY, button);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiMouseReleasedPre(Screen guiScreen, double mouseX, double mouseY, int button)
    {
        Event event = new GuiScreenEvent.MouseReleasedEvent.Pre(guiScreen, mouseX, mouseY, button);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiMouseReleasedPost(Screen guiScreen, double mouseX, double mouseY, int button)
    {
        Event event = new GuiScreenEvent.MouseReleasedEvent.Post(guiScreen, mouseX, mouseY, button);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiMouseDragPre(Screen guiScreen, double mouseX, double mouseY, int mouseButton, double dragX, double dragY)
    {
        Event event = new GuiScreenEvent.MouseDragEvent.Pre(guiScreen, mouseX, mouseY, mouseButton, dragX, dragY);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiMouseDragPost(Screen guiScreen, double mouseX, double mouseY, int mouseButton, double dragX, double dragY)
    {
        Event event = new GuiScreenEvent.MouseDragEvent.Post(guiScreen, mouseX, mouseY, mouseButton, dragX, dragY);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiMouseScrollPre(Mouse mouseHelper, Screen guiScreen, double scrollDelta)
    {
        Window mainWindow = guiScreen.getMinecraft().window;
        double mouseX = mouseHelper.getX() * (double) mainWindow.getScaledWidth() / (double) mainWindow.getWidth();
        double mouseY = mouseHelper.getY() * (double) mainWindow.getScaledHeight() / (double) mainWindow.getHeight();
        Event event = new GuiScreenEvent.MouseScrollEvent.Pre(guiScreen, mouseX, mouseY, scrollDelta);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiMouseScrollPost(Mouse mouseHelper, Screen guiScreen, double scrollDelta)
    {
        Window mainWindow = guiScreen.getMinecraft().window;
        double mouseX = mouseHelper.getX() * (double) mainWindow.getScaledWidth() / (double) mainWindow.getWidth();
        double mouseY = mouseHelper.getY() * (double) mainWindow.getScaledHeight() / (double) mainWindow.getHeight();
        Event event = new GuiScreenEvent.MouseScrollEvent.Post(guiScreen, mouseX, mouseY, scrollDelta);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiKeyPressedPre(Screen guiScreen, int keyCode, int scanCode, int modifiers)
    {
        Event event = new GuiScreenEvent.KeyboardKeyPressedEvent.Pre(guiScreen, keyCode, scanCode, modifiers);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiKeyPressedPost(Screen guiScreen, int keyCode, int scanCode, int modifiers)
    {
        Event event = new GuiScreenEvent.KeyboardKeyPressedEvent.Post(guiScreen, keyCode, scanCode, modifiers);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiKeyReleasedPre(Screen guiScreen, int keyCode, int scanCode, int modifiers)
    {
        Event event = new GuiScreenEvent.KeyboardKeyReleasedEvent.Pre(guiScreen, keyCode, scanCode, modifiers);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiKeyReleasedPost(Screen guiScreen, int keyCode, int scanCode, int modifiers)
    {
        Event event = new GuiScreenEvent.KeyboardKeyReleasedEvent.Post(guiScreen, keyCode, scanCode, modifiers);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiCharTypedPre(Screen guiScreen, char codePoint, int modifiers)
    {
        Event event = new GuiScreenEvent.KeyboardCharTypedEvent.Pre(guiScreen, codePoint, modifiers);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onGuiCharTypedPost(Screen guiScreen, char codePoint, int modifiers)
    {
        Event event = new GuiScreenEvent.KeyboardCharTypedEvent.Post(guiScreen, codePoint, modifiers);
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static void onRecipesUpdated(RecipeManager mgr)
    {
        Event event = new RecipesUpdatedEvent(mgr);
        MinecraftForge.EVENT_BUS.post(event);
    }

    // Resets cached thread fields in ThreadNameCachingStrategy and ReusableLogEventFactory to be repopulated during their next access.
    // This serves a workaround for no built-in method of triggering this type of refresh as brought up by LOG4J2-2178.
    public static void invalidateLog4jThreadCache()
    {
        if (System.getProperty("java.version").compareTo("1.8.0_102") >= 0) return; // skip for later JDKs, because it's not CACHED see LOG4J2-2052
        try
        {
            Field nameField = ThreadNameCachingStrategy.class.getDeclaredField("THREADLOCAL_NAME");
            Field logEventField = ReusableLogEventFactory.class.getDeclaredField("mutableLogEventThreadLocal");
            nameField.setAccessible(true);
            logEventField.setAccessible(true);
            ((ThreadLocal<?>) nameField.get(null)).set(null);
            ((ThreadLocal<?>) logEventField.get(null)).set(null);
        }
        catch (ReflectiveOperationException | NoClassDefFoundError e)
        {
            LOGGER.error("Unable to invalidate log4j thread cache, thread fields in logs may be inaccurate", e);
        }
    }

    public static void fireMouseInput(int button, int action, int mods)
    {
        MinecraftForge.EVENT_BUS.post(new InputEvent.MouseInputEvent(button, action, mods));
    }

    public static void fireKeyInput(int key, int scanCode, int action, int modifiers)
    {
        MinecraftForge.EVENT_BUS.post(new InputEvent.KeyInputEvent(key, scanCode, action, modifiers));
    }

    public static boolean onMouseScroll(Mouse mouseHelper, double scrollDelta)
    {
        Event event = new InputEvent.MouseScrollEvent(scrollDelta, mouseHelper.wasLeftButtonClicked(), mouseHelper.isMiddleDown(), mouseHelper.wasRightButtonClicked(), mouseHelper.getX(), mouseHelper.getY());
        return MinecraftForge.EVENT_BUS.post(event);
    }

    public static boolean onRawMouseClicked(int button, int action, int mods)
    {
        return MinecraftForge.EVENT_BUS.post(new InputEvent.RawMouseEvent(button, action, mods));
    }
}
