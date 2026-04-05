package com.mbest.client.mixin;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class LowShieldMixin {
    // Kalkanın ekranı kaplamasını engeller, aşağı çeker (PvP için kritik)
    @Inject(method = "renderFirstPersonItem", at = @At("HEAD"))
    private void adjustShield(CallbackInfo ci) {
        // Kalkan render pozisyonu kodları buraya gelecek
    }
}

