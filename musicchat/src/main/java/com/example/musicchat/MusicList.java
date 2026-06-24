package com.example.musicchat;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Arrays;

public class MusicList {

    private static final Random RANDOM = new Random();

    public static class Song {
        public final String title;
        public final String lyrics;
        public final String sound;
        public final String genre; // "viet", "pop", "rock"

        public Song(String title, String lyrics, String sound, String genre) {
            this.title = title;
            this.lyrics = lyrics;
            this.sound = sound;
            this.genre = genre;
        }
    }

    private static final List<Song> SONGS = Arrays.asList(
        // NHẠC VIỆT
        new Song("🌸 Có Chắc Yêu Là Đây - Sơn Tùng MTP",
            "♩ Có chắc yêu là đây, là đây không em\nHay chỉ là trò chơi không tên~ ♩",
            "minecraft:music.game", "viet"),
        new Song("🌺 Waiting For You - MONO",
            "♪ I'm waiting for you, every single night\nStaring at the ceiling thinking of you~ ♪",
            "minecraft:music.game.underwater", "viet"),
        new Song("🎤 Nơi Này Có Anh - Sơn Tùng MTP",
            "♩ Nơi này có anh, có anh chờ em\nDù cho ngày mai em có đi xa~ ♩",
            "minecraft:music.game", "viet"),
        new Song("🎵 Chúng Ta Của Hiện Tại - Sơn Tùng MTP",
            "♪ Chúng ta của hiện tại mãi vẫn còn đây\nDù ngày mai có ra sao~ ♪",
            "minecraft:music.menu", "viet"),
        new Song("🌸 Đừng Làm Trái Tim Anh Đau - Sơn Tùng MTP",
            "♩ Dù sao thì anh cũng yêu em thật rồi\nEm ơi đừng làm trái tim anh đau~ ♩",
            "minecraft:music.game", "viet"),
        new Song("🎸 Muộn Rồi Mà Sao Còn - Sơn Tùng MTP",
            "♪ Muộn rồi mà sao còn, sao còn\nAnh biết rồi nhưng cứ giả vờ thôi~ ♪",
            "minecraft:music.creative", "viet"),
        new Song("🎵 Hãy Trao Cho Anh - Sơn Tùng MTP",
            "♩ Hãy trao cho anh, hãy trao cho anh\nTình yêu trong tim em~ ♩",
            "minecraft:music.game", "viet"),

        // NHẠC POP
        new Song("🎹 Blinding Lights - The Weeknd",
            "♪ I've been tryna call, I'm in your walls\nI've been running through the night~ ♪",
            "minecraft:music.creative", "pop"),
        new Song("🎵 Shape of You - Ed Sheeran",
            "♩ The club isn't the best place to find a lover\nSo the bar is where I go~ ♩",
            "minecraft:music.menu", "pop"),
        new Song("🎤 As It Was - Harry Styles",
            "♪ In this world, it's just us\nYou know it's not the same as it was~ ♪",
            "minecraft:music.game", "pop"),
        new Song("🎺 Levitating - Dua Lipa",
            "♩ I got you, moonlight, you're my starlight\nI need you all night, come on, dance with me~ ♩",
            "minecraft:music.game", "pop"),
        new Song("🎵 Stay - Justin Bieber",
            "♪ I do not wanna fall in love\nIf I ever did that, I think I'd have a heart attack~ ♪",
            "minecraft:music.menu", "pop"),
        new Song("🎤 Someone Like You - Adele",
            "♩ Never mind, I'll find someone like you\nI wish nothing but the best for you~ ♩",
            "minecraft:music.game.underwater", "pop"),
        new Song("🎵 Watermelon Sugar - Harry Styles",
            "♪ Tastes like strawberries on a summer evening\nAnd it sounds just like a song~ ♪",
            "minecraft:music.game", "pop"),
        new Song("🎹 Perfect - Ed Sheeran",
            "♩ I found a love for me\nDarling just dive right in, follow my lead~ ♩",
            "minecraft:music.creative", "pop"),
        new Song("🎵 Sunflower - Post Malone",
            "♪ Every time I'm leavin' on you\nYou don't make it easy, no~ ♪",
            "minecraft:music.game", "pop"),
        new Song("🎤 Heat Waves - Glass Animals",
            "♩ Sometimes, all I think about is you\nLate nights in the middle of June~ ♩",
            "minecraft:music.game.credits", "pop"),

        // NHẠC ROCK
        new Song("🎸 Bohemian Rhapsody - Queen",
            "♩ Is this the real life? Is this just fantasy?\nCaught in a landslide, no escape from reality~ ♩",
            "minecraft:music.game", "rock"),
        new Song("🎸 Counting Stars - OneRepublic",
            "♪ Lately I been, I been losing sleep\nDreaming about the things that we could be~ ♪",
            "minecraft:music.game.nether_wastes", "rock"),
        new Song("🎻 Demons - Imagine Dragons",
            "♩ When the days are cold and the cards all fold\nAnd the saints we see are all made of gold~ ♩",
            "minecraft:music.creative", "rock"),
        new Song("🥁 Believer - Imagine Dragons",
            "♪ First things first, I'ma say all the words inside my head\nI'm fired up and tired of the way that things have been~ ♪",
            "minecraft:music.game", "rock"),
        new Song("🎸 Stressed Out - Twenty One Pilots",
            "♩ I wish I found some better sounds no one's ever heard\nI wish I had a better voice that sang some better words~ ♩",
            "minecraft:music.game", "rock"),
        new Song("🎵 Let Her Go - Passenger",
            "♪ Only know you love her when you let her go\nAnd you let her go~ ♪",
            "minecraft:music.creative", "rock"),
        new Song("🎸 Stay With Me - Sam Smith",
            "♩ Guess it's true, I'm not good at a one-night stand\nBut I still need love cause I'm just a man~ ♩",
            "minecraft:music.game.underwater", "rock")
    );

    public static Song getRandom() {
        return SONGS.get(RANDOM.nextInt(SONGS.size()));
    }

    public static Song getByGenre(String genre) {
        if (genre.equals("all")) return getRandom();
        List<Song> filtered = SONGS.stream()
            .filter(s -> s.genre.equalsIgnoreCase(genre))
            .collect(Collectors.toList());
        if (filtered.isEmpty()) return null;
        return filtered.get(RANDOM.nextInt(filtered.size()));
    }
}
