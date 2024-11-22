package dev.andante.toggleglowing.mixin.client;

import dev.andante.toggleglowing.ToggleGlowingClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Inject(method = "hasOutline", at = @At("HEAD"), cancellable = true)
	private void overrideHasOutline(Entity entity, CallbackInfoReturnable<Boolean> cir) {
		if (!ToggleGlowingClient.INSTANCE.getGlowing()) {
			cir.setReturnValue(false);
		}
	}
}
