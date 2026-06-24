package com.example.musicchat.mixin;

import com.example.musicchat.MusicList;
import com.example.musicchat.MusicList.Song;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ChatMixin {

    private static final String TRIGGER_MUSIC = "!nhac";
    private static final String TRIGGER_LYRICS = "!baihat";

    // Lưu bài hiện tại để !baihat hiện đúng lời
    private static Song currentSong = null;

    @Inject(
        method = "sendChatMessage(Ljava/lang/String;)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void onSendChat(String message, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();

        // --- !nhac: phát nhạc + thông báo tên bài ---
        if (message.equalsIgnoreCase(TRIGGER_MUSIC)) {
            ci.cancel();

            currentSong = MusicList.getRandom();

            // Phát âm thanh Minecraft
            if (client.player != null && client.world != null) {
                Identifier soundId = Identifier.of(currentSong.sound);
                SoundEvent sound = SoundEvent.of(soundId);
                client.player.playSound(
                    sound,
                    1.0f, // volume
                    1.0f  // pitch
                );
            }

            // Chat tên bài
            ClientPlayNetworkHandler self = (ClientPlayNetworkHandler)(Object)this;
            self.sendChatMessage("🎵 Đang phát: " + currentSong.title + " | Nhắn !baihat để xem lời~");
        }

        // --- !baihat: hiện lời bài đang phát ---
        else if (message.equalsIgnoreCase(TRIGGER_LYRICS)) {
            ci.cancel();

            ClientPlayNetworkHandler self = (ClientPlayNetworkHandler)(Object)this;

            if (currentSong == null) {
                self.sendChatMessage("❌ Chưa phát bài nào! Nhắn !nhac trước đã~");
            } else {
                self.sendChatMessage("📜 Lời bài: " + currentSong.title);
                self.sendChatMessage(currentSong.lyrics);
            }
        }
    }
}
