package com.example.musicchat.mixin;

import com.example.musicchat.MusicList;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ChatMixin {

    private static final String TRIGGER = "!nhac";

    // 1.21.1 dùng sendChatMessage(String message)
    @Inject(
        method = "sendChatMessage(Ljava/lang/String;)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void onSendChat(String message, CallbackInfo ci) {
        if (!message.equalsIgnoreCase(TRIGGER)) return;

        ci.cancel(); // Chặn không cho gửi "!nhac" lên chat

        String song = MusicList.getRandom();

        // Gửi bài nhạc lên chat
        ClientPlayNetworkHandler self = (ClientPlayNetworkHandler)(Object)this;
        self.sendChatMessage(song);
    }
}
