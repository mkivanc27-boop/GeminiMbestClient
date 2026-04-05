package com.mbest.client.mixin;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class PerformanceMixin {
    // Bulutları render etmeyi durdurarak FPS'i uçurur
    @Inject(method = "renderClouds", at = @At("HEAD"), cancellable = true)
    private void disableClouds(CallbackInfo ci) { ci.cancel(); }
}

