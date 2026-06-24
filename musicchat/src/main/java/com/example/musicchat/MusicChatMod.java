package com.example.musicchat;

import net.fabricmc.api.ClientModInitializer;

public class MusicChatMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Không cần đăng ký gì thêm, Mixin lo hết
        System.out.println("[MusicChat] Mod loaded! Nhắn §a!nhac §rtrong chat~");
    }
}
