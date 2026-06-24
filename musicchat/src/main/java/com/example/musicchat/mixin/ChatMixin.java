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

import java.util.HashMap;
import java.util.Map;

@Mixin(ClientPlayNetworkHandler.class)
public class ChatMixin {

    // ===== Lệnh =====
    private static final String CMD_NHAC       = "!nhac";
    private static final String CMD_LYRICS     = "!baihat";
    private static final String CMD_STOP       = "!dung";
    private static final String CMD_TOP        = "!top";
    private static final String CMD_HELP       = "!help";

    // ===== Trạng thái =====
    private static Song currentSong = null;
    private static long lastUsed = 0L;
    private static final long COOLDOWN_MS = 10_000L; // 10 giây

    // ===== Đếm lượt phát =====
    private static final Map<String, Integer> playCount = new HashMap<>();

    @Inject(
        method = "sendChatMessage(Ljava/lang/String;)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void onSendChat(String message, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayNetworkHandler self = (ClientPlayNetworkHandler)(Object)this;
        String msg = message.trim().toLowerCase();

        // ── !help ──────────────────────────────────────
        if (msg.equals(CMD_HELP)) {
            ci.cancel();
            self.sendChatMessage("§e=== 🎵 MusicChat Commands ===");
            self.sendChatMessage("§a!nhac §f— Phát nhạc ngẫu nhiên");
            self.sendChatMessage("§a!nhac viet §f— Phát nhạc Việt");
            self.sendChatMessage("§a!nhac pop §f— Phát nhạc Pop");
            self.sendChatMessage("§a!nhac rock §f— Phát nhạc Rock");
            self.sendChatMessage("§a!baihat §f— Xem lời bài đang phát");
            self.sendChatMessage("§a!dung §f— Dừng nhạc");
            self.sendChatMessage("§a!top §f— Top 5 bài được phát nhiều nhất");
            return;
        }

        // ── !nhac [thể loại] ───────────────────────────
        if (msg.equals(CMD_NHAC) || msg.startsWith(CMD_NHAC + " ")) {
            ci.cancel();

            // Cooldown
            long now = System.currentTimeMillis();
            if (now - lastUsed < COOLDOWN_MS) {
                long con = (COOLDOWN_MS - (now - lastUsed)) / 1000;
                self.sendChatMessage("§c⏳ Chờ " + con + "s nữa mới dùng được!");
                return;
            }
            lastUsed = now;

            // Lọc thể loại
            String genre = msg.equals(CMD_NHAC) ? "all" : msg.substring(CMD_NHAC.length()).trim();
            currentSong = MusicList.getByGenre(genre);

            if (currentSong == null) {
                self.sendChatMessage("§c❌ Không tìm thấy thể loại: " + genre + " | Thử: viet, pop, rock");
                return;
            }

            // Đếm lượt phát
            playCount.merge(currentSong.title, 1, Integer::sum);

            // Phát âm thanh
            if (client.player != null && client.world != null) {
                try {
                    Identifier soundId = Identifier.of(currentSong.sound);
                    SoundEvent sound = SoundEvent.of(soundId);
                    client.player.playSound(sound, 1.0f, 1.0f);
                } catch (Exception ignored) {}
            }

            self.sendChatMessage("§6🎵 Đang phát: §f" + currentSong.title + " §7| !baihat để xem lời~");
            return;
        }

        // ── !baihat ────────────────────────────────────
        if (msg.equals(CMD_LYRICS)) {
            ci.cancel();
            if (currentSong == null) {
                self.sendChatMessage("§c❌ Chưa phát bài nào! Nhắn §a!nhac §ctrước~");
            } else {
                self.sendChatMessage("§e📜 " + currentSong.title);
                self.sendChatMessage("§f" + currentSong.lyrics);
            }
            return;
        }

        // ── !dung ──────────────────────────────────────
        if (msg.equals(CMD_STOP)) {
            ci.cancel();
            if (client.player != null) {
                client.getSoundManager().stopAll();
                self.sendChatMessage("§c⏹ Đã dừng nhạc!");
                currentSong = null;
            }
            return;
        }

        // ── !top ───────────────────────────────────────
        if (msg.equals(CMD_TOP)) {
            ci.cancel();
            if (playCount.isEmpty()) {
                self.sendChatMessage("§c❌ Chưa có bài nào được phát!");
                return;
            }
            self.sendChatMessage("§e🏆 Top bài được phát nhiều nhất:");
            playCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(e -> self.sendChatMessage("§a" + e.getKey() + " §f— " + e.getValue() + " lần"));
        }
    }
}
