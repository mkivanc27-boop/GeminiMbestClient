package com.mbest.client.mixin;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SimpleOption.class)
public class FullbrightMixin {
    // Gama değerini zorla yükselterek sonsuz gece görüşü sağlar
    @Inject(method = "getValue", at = @At("HEAD"), cancellable = true)
    private void forceFullbright(CallbackInfoReturnable<Object> cir) {
        cir.setReturnValue(10.0);
    }
}

