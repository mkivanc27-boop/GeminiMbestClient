package com.mbest.client.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class NoHurtCamMixin {
    
    // 1.20.2'de isim çakışması olmaması için remap'i kapatıyoruz veya tam hedef veriyoruz
    @Inject(method = "bobViewWhenHurt", at = @At("HEAD"), cancellable = true, remap = true)
    private void stopShake(CallbackInfo ci) {
        // Ekran sallanmasını iptal et
        ci.cancel();
    }
}
