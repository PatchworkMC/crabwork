package net.minecraft.nbt;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class NBTSizeTracker {
    @Shadow
    @Final
    public static NBTSizeTracker INFINITE;
    @Shadow
    @Final
    private long max;
    @Shadow
    private long read;

    @Shadow
    public NBTSizeTracker(long max) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void read(long bits) {
        throw new UnsupportedOperationException();
    }

    /*
     * UTF8 is not a simple encoding system, each character can be either
     * 1, 2, or 3 bytes. Depending on where it's numerical value falls.
     * We have to count up each character individually to see the true
     * length of the data.
     *
     * Basic concept is that it uses the MSB of each byte as a 'read more' signal.
     * So it has to shift each 7-bit segment.
     *
     * This will accurately count the correct byte length to encode this string, plus the 2 bytes for it's length prefix.
     */
    @Shadow
    public String readUTF(String data) {
        throw new UnsupportedOperationException();
    }
}
