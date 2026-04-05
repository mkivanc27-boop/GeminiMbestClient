package com.mbest.client.mixin;

import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Window.class)
public class WindowMixin {
    
    // Pencere boyutu hesaplanırken Double gelen değerleri Integer'a zorluyoruz
    @ModifyArgs(method = "<init>", at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwCreateWindow(IILjava/lang/CharSequence;JJ)J"))
    private void fixDoubleError(Args args) {
        for (int i = 0; i < 2; i++) {
            if (args.get(i) instanceof Double) {
                double val = args.get(i);
                args.set(i, (int) val);
            }
        }
    }
}

