package net.minecraft.client.resources;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.stream.Stream;

import net.minecraft.client.resources.data.LanguageMetadataSection;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.resources.IResourcePack;
import net.minecraft.util.text.LanguageMap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class LanguageManager implements IResourceManagerReloadListener {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Language field_239503_b_;
    @Shadow
    private Map<String, Language> languageMap;
    @Shadow
    private String currentLanguage;
    @Shadow
    private Language field_239504_e_;

    @Shadow
    public LanguageManager(String p_i48112_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static Map<String, Language> func_239506_a_(Stream<IResourcePack> p_239506_0_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onResourceManagerReload(IResourceManager resourceManager) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Language getCurrentLanguage() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setCurrentLanguage(Language currentLanguageIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public SortedSet<Language> getLanguages() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Language getLanguage(String p_191960_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public net.minecraftforge.resource.IResourceType getResourceType() {
        throw new UnsupportedOperationException();
    }
}
