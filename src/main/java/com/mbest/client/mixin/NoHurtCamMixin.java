package com.mbest.client.mixin;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class NoHurtCamMixin {
    // Hasar alınca ekranın sallanmasını (HurtCam) tamamen siler
    @Inject(method = "bobViewWhenHurt", at = @At("HEAD"), cancellable = true)
    private void stopShake(CallbackInfo ci) { ci.cancel(); }
}

