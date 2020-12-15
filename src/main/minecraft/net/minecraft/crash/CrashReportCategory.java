package net.minecraft.crash;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class CrashReportCategory {
    @Shadow
    @Final
    private CrashReport crashReport;
    @Shadow
    @Final
    private String name;
    @Shadow
    @Final
    private List<CrashReportCategory.Entry> children;
    @Shadow
    private StackTraceElement[] stackTrace;

    @Shadow
    public CrashReportCategory(CrashReport report, String name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static String getCoordinateInfo(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static String getCoordinateInfo(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static String getCoordinateInfo(int x, int y, int z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void addBlockInfo(CrashReportCategory category, BlockPos pos, @Nullable BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CrashReportCategory addDetail(String nameIn, ICrashReportDetail<String> detail) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CrashReportCategory addDetail(String sectionName, Object value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addCrashSectionThrowable(String sectionName, Throwable throwable) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getPrunedStackTrace(int size) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean firstTwoElementsOfStackTraceMatch(StackTraceElement s1, StackTraceElement s2) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void trimStackTraceEntriesFromBottom(int amount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void appendToStringBuilder(StringBuilder builder) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public StackTraceElement[] getStackTrace() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void applyStackTrace(Throwable t) {
        throw new UnsupportedOperationException();
    }

    static class Entry {
        @Shadow
        @Final
        private String key;
        @Shadow
        @Final
        private String value;

        @Shadow
        public Entry(String key, @Nullable Object value) {
            throw new UnsupportedOperationException();

        }

        @Shadow
        public String getKey() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public String getValue() {
            throw new UnsupportedOperationException();
        }
    }
}
