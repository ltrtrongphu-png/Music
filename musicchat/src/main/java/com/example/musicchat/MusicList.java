package com.example.musicchat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MusicList {

    private static final Random RANDOM = new Random();

    public static class Song {
        public final String title;
        public final String lyrics;
        public final String sound;
        public final String genre;

        public Song(String title, String lyrics, String sound, String genre) {
            this.title = title;
            this.lyrics = lyrics;
            this.sound = sound;
            this.genre = genre;
        }
    }

    private static final List<Song> SONGS = Arrays.asList(

        // NHAC VIET
        new Song("[Viet] Co Chac Yeu La Day - Son Tung MTP",
            "Co chac yeu la day, la day khong em / Hay chi la tro choi khong ten~",
            "minecraft:music.game", "viet"),
        new Song("[Viet] Waiting For You - MONO",
            "I'm waiting for you, every single night / Staring at the ceiling thinking of you~",
            "minecraft:music.game.underwater", "viet"),
        new Song("[Viet] Noi Nay Co Anh - Son Tung MTP",
            "Noi nay co anh, co anh cho em / Du cho ngay mai em co di xa~",
            "minecraft:music.game", "viet"),
        new Song("[Viet] Chung Ta Cua Hien Tai - Son Tung MTP",
            "Chung ta cua hien tai mai van con day / Du ngay mai co ra sao~",
            "minecraft:music.menu", "viet"),
        new Song("[Viet] Muon Roi Ma Sao Con - Son Tung MTP",
            "Muon roi ma sao con, sao con / Anh biet roi nhung cu gia vo thoi~",
            "minecraft:music.creative", "viet"),
        new Song("[Viet] Hay Trao Cho Anh - Son Tung MTP",
            "Hay trao cho anh, hay trao cho anh / Tinh yeu trong tim em~",
            "minecraft:music.game", "viet"),
        new Song("[Viet] Dung Lam Trai Tim Anh Dau - Son Tung MTP",
            "Du sao thi anh cung yeu em that roi / Em oi dung lam trai tim anh dau~",
            "minecraft:music.game", "viet"),

        // NHAC POP
        new Song("[Pop] Blinding Lights - The Weeknd",
            "I've been tryna call, I'm in your walls / I've been running through the night~",
            "minecraft:music.creative", "pop"),
        new Song("[Pop] Shape of You - Ed Sheeran",
            "The club isn't the best place to find a lover / So the bar is where I go~",
            "minecraft:music.menu", "pop"),
        new Song("[Pop] As It Was - Harry Styles",
            "In this world, it's just us / You know it's not the same as it was~",
            "minecraft:music.game", "pop"),
        new Song("[Pop] Levitating - Dua Lipa",
            "I got you moonlight you're my starlight / I need you all night come on dance with me~",
            "minecraft:music.game", "pop"),
        new Song("[Pop] Stay - Justin Bieber",
            "I do not wanna fall in love / If I ever did that I think I'd have a heart attack~",
            "minecraft:music.menu", "pop"),
        new Song("[Pop] Someone Like You - Adele",
            "Never mind I'll find someone like you / I wish nothing but the best for you~",
            "minecraft:music.game.underwater", "pop"),
        new Song("[Pop] Watermelon Sugar - Harry Styles",
            "Tastes like strawberries on a summer evening / And it sounds just like a song~",
            "minecraft:music.game", "pop"),
        new Song("[Pop] Perfect - Ed Sheeran",
            "I found a love for me / Darling just dive right in follow my lead~",
            "minecraft:music.creative", "pop"),
        new Song("[Pop] Sunflower - Post Malone",
            "Every time I'm leavin' on you / You don't make it easy no~",
            "minecraft:music.game", "pop"),
        new Song("[Pop] Heat Waves - Glass Animals",
            "Sometimes all I think about is you / Late nights in the middle of June~",
            "minecraft:music.game.credits", "pop"),
        new Song("[Pop] Happier - Marshmello",
            "I want you to be happier I want you to be happier / When the morning comes~",
            "minecraft:music.game", "pop"),
        new Song("[Pop] Let Her Go - Passenger",
            "Only know you love her when you let her go / And you let her go~",
            "minecraft:music.creative", "pop"),
        new Song("[Pop] Photograph - Ed Sheeran",
            "Loving can hurt loving can hurt sometimes / But it's the only thing that I know~",
            "minecraft:music.game", "pop"),

        // NHAC ROCK
        new Song("[Rock] Bohemian Rhapsody - Queen",
            "Is this the real life? Is this just fantasy? / Caught in a landslide no escape from reality~",
            "minecraft:music.game", "rock"),
        new Song("[Rock] Counting Stars - OneRepublic",
            "Lately I been I been losing sleep / Dreaming about the things that we could be~",
            "minecraft:music.game.nether_wastes", "rock"),
        new Song("[Rock] Demons - Imagine Dragons",
            "When the days are cold and the cards all fold / And the saints we see are all made of gold~",
            "minecraft:music.creative", "rock"),
        new Song("[Rock] Believer - Imagine Dragons",
            "First things first I'ma say all the words inside my head / I'm fired up and tired of the way that things have been~",
            "minecraft:music.game", "rock"),
        new Song("[Rock] Stressed Out - Twenty One Pilots",
            "I wish I found some better sounds no one's ever heard / I wish I had a better voice that sang some better words~",
            "minecraft:music.game", "rock"),
        new Song("[Rock] Thunder - Imagine Dragons",
            "Just a young gun with a quick fuse / I was uptight wanna use my free time~",
            "minecraft:music.creative", "rock"),
        new Song("[Rock] Natural - Imagine Dragons",
            "Will you hold the line when every one of them has given up and given in / In this house of mine~",
            "minecraft:music.game", "rock")
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
