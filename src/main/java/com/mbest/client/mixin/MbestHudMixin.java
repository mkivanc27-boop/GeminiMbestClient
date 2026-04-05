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
    // Ekrana havalı logoyu ve FPS bilgisini basar
    @Inject(method = "render", at = @At("TAIL"))
    private void drawHud(DrawContext context, float tickDelta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        context.drawText(client.textRenderer, "§bMbest Client §f1.20.2", 10, 10, 0xFFFFFF, true);
    }
}

