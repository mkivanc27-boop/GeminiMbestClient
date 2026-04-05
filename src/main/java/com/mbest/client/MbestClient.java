package com.mbest.client;

import net.fabricmc.api.ClientModInitializer;

public class MbestClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // ANDROID 12 DOUBLE/INTEGER BUG FIX
        // Bu kod, sistemdeki hatalı ölçeklendirme değerini zorla Integer yapar
        try {
            String existingScale = System.getProperty("sun.java2d.uiScale");
            if (existingScale != null) {
                double scale = Double.parseDouble(existingScale);
                System.setProperty("sun.java2d.uiScale", String.valueOf((int) scale));
            }
        } catch (Exception ignored) {}

        System.out.println("Mbest Client Başlatıldı! Sürüm: 1.20.2");
    }
}
