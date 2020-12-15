package net.minecraft.client.gui;

import com.google.common.collect.Maps;

import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.EnchantmentScreen;
import net.minecraft.client.gui.screen.GrindstoneScreen;
import net.minecraft.client.gui.screen.HopperScreen;
import net.minecraft.client.gui.screen.LecternScreen;
import net.minecraft.client.gui.screen.LoomScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.AnvilScreen;
import net.minecraft.client.gui.screen.inventory.BeaconScreen;
import net.minecraft.client.gui.screen.inventory.BlastFurnaceScreen;
import net.minecraft.client.gui.screen.inventory.BrewingStandScreen;
import net.minecraft.client.gui.screen.inventory.CartographyTableScreen;
import net.minecraft.client.gui.screen.inventory.ChestScreen;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.client.gui.screen.inventory.DispenserScreen;
import net.minecraft.client.gui.screen.inventory.FurnaceScreen;
import net.minecraft.client.gui.screen.inventory.MerchantScreen;
import net.minecraft.client.gui.screen.inventory.ShulkerBoxScreen;
import net.minecraft.client.gui.screen.inventory.SmithingTableScreen;
import net.minecraft.client.gui.screen.inventory.SmokerScreen;
import net.minecraft.client.gui.screen.inventory.StonecutterScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class ScreenManager {
    @Shadow
    @Final
    private static Logger LOG;
    @Shadow
    @Final
    private static Map<ContainerType<?>, ScreenManager.IScreenFactory<?, ?>> FACTORIES;

    @Shadow
    public static <T extends Container> void openScreen(@Nullable ContainerType<T> type, Minecraft mc, int windowId, ITextComponent title) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static <T extends Container> java.util.Optional<IScreenFactory<T, ?>> getScreenFactory(@Nullable ContainerType<T> type, Minecraft mc, int windowId, ITextComponent title) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    private static <T extends Container> ScreenManager.IScreenFactory<T, ?> getFactory(ContainerType<T> type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static <M extends Container, U extends Screen & IHasContainer<M>> void registerFactory(ContainerType<? extends M> type, ScreenManager.IScreenFactory<M, U> factory) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean isMissingScreen() {
        throw new UnsupportedOperationException();
    }

    @OnlyIn(Dist.CLIENT)
    public interface IScreenFactory<T extends Container, U extends Screen & IHasContainer<T>> {
        @Shadow
        default void createScreen(ITextComponent title, ContainerType<T> type, Minecraft mc, int windowId) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        U create(T p_create_1_, PlayerInventory p_create_2_, ITextComponent p_create_3_);
    }
}
