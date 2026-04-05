package com.mbest.client.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import java.util.ArrayList;

public class ClickGuiScreen extends Screen {
    private ArrayList<ModButton> buttons = new ArrayList<>();

    public ClickGuiScreen() {
        super(Text.literal("Mbest ClickGUI"));
        buttons.add(new ModButton("Fullbright", 20, 20, 80, 20));
        buttons.add(new ModButton("NoHurtCam", 20, 50, 80, 20));
        buttons.add(new ModButton("FPS Boost", 20, 80, 80, 20));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, "§bMbest Client §fMenu", this.width / 2, 10, 0xFFFFFF);
        for (ModButton btn : buttons) { btn.render(context, mouseX, mouseY); }
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (ModButton btn : buttons) {
            if (btn.isHovered(mouseX, mouseY)) {
                btn.enabled = !btn.enabled; // Modu aç/kapat
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
    
    @Override
    public boolean shouldPause() { return false; } // Menü açılınca oyun durmasın
}

