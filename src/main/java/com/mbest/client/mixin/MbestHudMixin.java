package com.mbest.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MbestHudMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void onRender(DrawContext context, float tickDelta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (!client.options.hudHidden) {
            context.drawText(client.textRenderer, "§bMbest Client §7| §f1.20.2", 5, 5, 0xFFFFFF, true);
        }
    }
}
