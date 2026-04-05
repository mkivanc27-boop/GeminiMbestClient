package com.mbest.client.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class ModButton {
    public String name;
    public int x, y, width, height;
    public boolean enabled;

    public ModButton(String name, int x, int y, int width, int height) {
        this.name = name; this.x = x; this.y = y; this.width = width; this.height = height;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        int color = enabled ? 0xFF00FF00 : 0xFFFF0000; // Yeşil (Açık) / Kırmızı (Kapalı)
        context.fill(x, y, x + width, y + height, 0xAA000000); // Arka plan
        context.drawText(MinecraftClient.getInstance().textRenderer, name, x + 5, y + 5, color, true);
    }

    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }
}

