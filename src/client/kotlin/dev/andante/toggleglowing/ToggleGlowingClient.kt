package dev.andante.toggleglowing

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW

object ToggleGlowingClient : ClientModInitializer {
	val KEYBINDING = KeyBinding(
		"key.toggle-glowing.toggle",
		InputUtil.Type.KEYSYM,
		GLFW.GLFW_KEY_N,
		"key.categories.misc"
	)

	var glowing: Boolean = true
		private set

	override fun onInitializeClient() {
		KeyBindingHelper.registerKeyBinding(KEYBINDING)

		ClientTickEvents.END_CLIENT_TICK.register { _ ->
			if (KEYBINDING.wasPressed()) {
				glowing = !glowing
			}
		}
	}
}
