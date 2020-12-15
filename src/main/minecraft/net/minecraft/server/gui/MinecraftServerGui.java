package net.minecraft.server.gui;

import com.google.common.collect.Lists;
import com.mojang.util.QueueLogAppender;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.DefaultUncaughtExceptionHandler;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinecraftServerGui extends JComponent {
    @Shadow
    @Final
    private static Font SERVER_GUI_FONT;
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private DedicatedServer server;
    @Shadow
    private Thread field_206932_d;
    @Shadow
    @Final
    private Collection<Runnable> field_219051_e;
    @Shadow
    @Final
    private AtomicBoolean field_219052_f;
    @Shadow
    private java.util.concurrent.CountDownLatch latch;

    @Shadow
    private MinecraftServerGui(DedicatedServer serverIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static MinecraftServerGui func_219048_a(final DedicatedServer p_219048_0_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_219045_a(Runnable p_219045_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private JComponent getStatsComponent() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private JComponent getPlayerListComponent() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private JComponent getLogComponent() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void start() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_219050_b() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void func_219046_f() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void appendLine(JTextArea textArea, JScrollPane scrollPane, String line) {
        throw new UnsupportedOperationException();
    }
}
