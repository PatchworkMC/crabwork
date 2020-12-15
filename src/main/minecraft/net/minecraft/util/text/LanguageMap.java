package net.minecraft.util.text;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.JSONUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class LanguageMap {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Gson field_240591_b_;
    @Shadow
    @Final
    private static Pattern NUMERIC_VARIABLE_PATTERN;
    @Shadow
    private static volatile LanguageMap field_240592_d_;

    @Shadow
    private static LanguageMap func_240595_c_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void func_240593_a_(InputStream p_240593_0_, BiConsumer<String, String> p_240593_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static LanguageMap getInstance() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static void func_240594_a_(LanguageMap p_240594_0_) {
        throw new UnsupportedOperationException();
    }

    // FORGE START
    @Shadow
    public Map<String, String> getLanguageData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract String func_230503_a_(String p_230503_1_);

    @Shadow
    public abstract boolean func_230506_b_(String p_230506_1_);

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public abstract boolean func_230505_b_();

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public abstract IReorderingProcessor func_241870_a(ITextProperties p_241870_1_);

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public List<IReorderingProcessor> func_244260_a(List<ITextProperties> p_244260_1_) {
        throw new UnsupportedOperationException();
    }
}
