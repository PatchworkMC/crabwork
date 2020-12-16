package net.minecraft.client.settings;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.util.InputMappings;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class KeyBinding implements Comparable<KeyBinding>, net.minecraftforge.client.extensions.IForgeKeybinding {
	@Shadow
	@Final
	private static Map<String, KeyBinding> KEYBIND_ARRAY;

	@Shadow
	@Final
	private static net.minecraftforge.client.settings.KeyBindingMap HASH;

	@Shadow
	@Final
	private static Set<String> KEYBIND_SET;

	@Shadow
	@Final
	private static Map<String, Integer> CATEGORY_ORDER;

	@Shadow
	boolean pressed;

	@Shadow
	@Final
	private final String keyDescription;

	@Shadow
	@Final
	private final InputMappings.Input keyCodeDefault;

	@Shadow
	@Final
	private final String keyCategory;

	@Shadow
	private final InputMappings.Input keyCode;

	@Shadow
	private final int pressTime;

	/****************** Forge Start *****************************/
	@Shadow
	private final net.minecraftforge.client.settings.KeyModifier keyModifierDefault;

	@Shadow
	private final net.minecraftforge.client.settings.KeyModifier keyModifier;

	@Shadow
	private final net.minecraftforge.client.settings.IKeyConflictContext keyConflictContext;

	@Shadow
	public KeyBinding(String description, int keyCode, String category) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public KeyBinding(String description, InputMappings.Type type, int code, String category) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Convenience constructor for creating KeyBindings with keyConflictContext set.
	 */
	@Shadow
	public KeyBinding(String description, net.minecraftforge.client.settings.IKeyConflictContext keyConflictContext, final InputMappings.Type inputType, final int keyCode, String category) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Convenience constructor for creating KeyBindings with keyConflictContext set.
	 */
	@Shadow
	public KeyBinding(String description, net.minecraftforge.client.settings.IKeyConflictContext keyConflictContext, InputMappings.Input keyCode, String category) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Convenience constructor for creating KeyBindings with keyConflictContext and keyModifier set.
	 */
	@Shadow
	public KeyBinding(String description, net.minecraftforge.client.settings.IKeyConflictContext keyConflictContext, net.minecraftforge.client.settings.KeyModifier keyModifier, final InputMappings.Type inputType, final int keyCode, String category) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Convenience constructor for creating KeyBindings with keyConflictContext and keyModifier set.
	 */
	@Shadow
	public KeyBinding(String description, net.minecraftforge.client.settings.IKeyConflictContext keyConflictContext, net.minecraftforge.client.settings.KeyModifier keyModifier, InputMappings.Input keyCode, String category) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void onTick(InputMappings.Input key) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public static void setKeyBindState(InputMappings.Input key, boolean held) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public static void updateKeyBindState() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public static void unPressAllKeys() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public static void resetKeyBindingArrayAndHash() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public static Supplier<ITextComponent> getDisplayString(String key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isKeyDown() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getKeyCategory() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isPressed() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPressed(boolean valueIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void unpressKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getKeyDescription() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public InputMappings.Input getDefault() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void bind(InputMappings.Input key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int compareTo(KeyBinding p_compareTo_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean conflicts(KeyBinding binding) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isInvalid() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean matchesKey(int keysym, int scancode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean matchesMouseKey(int key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent func_238171_j_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isDefault() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getTranslationKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public InputMappings.Input getKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public net.minecraftforge.client.settings.IKeyConflictContext getKeyConflictContext() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public void setKeyConflictContext(net.minecraftforge.client.settings.IKeyConflictContext keyConflictContext) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public net.minecraftforge.client.settings.KeyModifier getKeyModifierDefault() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public net.minecraftforge.client.settings.KeyModifier getKeyModifier() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public void setKeyModifierAndCode(net.minecraftforge.client.settings.KeyModifier keyModifier, InputMappings.Input keyCode) {
		throw new UnsupportedOperationException();
	}
	/****************** Forge End *****************************/
}
