package com.mbest.client.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class NoHurtCamMixin {
    
    /**
     * @author MbestClient
     * @reason Ekran sallanmasını durdurmak için kesin yöntem
     */
    @Inject(method = "method_3186", at = @At("HEAD"), cancellable = true, remap = false)
    private void stopShake(CallbackInfo ci) {
        ci.cancel();
    }
}
