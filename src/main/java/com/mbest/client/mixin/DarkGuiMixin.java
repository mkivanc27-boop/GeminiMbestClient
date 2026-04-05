package com.mbest.client.mixin;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class DarkGuiMixin {
    // Menü arka planlarını Mbest Koyu Tema (Siyah/Koyu Gri) yapar
    @Inject(method = "renderBackground", at = @At("HEAD"), cancellable = true)
    private void darkBackground(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        context.fill(0, 0, context.getScaledWindowWidth(), context.getScaledWindowHeight(), 0xFF101010);
        ci.cancel(); 
    }
}

