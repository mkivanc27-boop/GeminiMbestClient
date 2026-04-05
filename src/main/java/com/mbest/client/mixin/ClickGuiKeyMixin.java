package com.mbest.client.mixin;

import com.mbest.client.gui.ClickGuiScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Input.class)
public class ClickGuiKeyMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void onKey(boolean slowDown, float slowDownFactor, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        // Right Shift tuşuna basıldığını kontrol et
        if (GLFW.glfwGetKey(client.getWindow().getHandle(), GLFW.GLFW_KEY_RIGHT_SHIFT) == GLFW.GLFW_PRESS) {
            if (!(client.currentScreen instanceof ClickGuiScreen)) {
                client.setScreen(new ClickGuiScreen());
            }
        }
    }
}

