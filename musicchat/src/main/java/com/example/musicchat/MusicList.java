package com.example.musicchat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MusicList {

    private static final Random RANDOM = new Random();

    public static class Song {
        public final String title;
        public final String lyrics;
        public final String sound;

        public Song(String title, String lyrics, String sound) {
            this.title = title;
            this.lyrics = lyrics;
            this.sound = sound;
        }
    }

    private static final List<Song> SONGS = Arrays.asList(
        // === NHẠC QUỐC TẾ ===
        new Song(
            "🎵 Bohemian Rhapsody - Queen",
            "♩ Is this the real life? Is this just fantasy?\nCaught in a landslide, no escape from reality~ ♩",
            "minecraft:music.game"
        ),
        new Song(
            "🎸 Blinding Lights - The Weeknd",
            "♪ I've been tryna call, I'm in your walls\nI've been running through the night~ ♪",
            "minecraft:music.creative"
        ),
        new Song(
            "🎹 Someone Like You - Adele",
            "♩ Never mind, I'll find someone like you\nI wish nothing but the best for you~ ♩",
            "minecraft:music.menu"
        ),
        new Song(
            "🎤 Counting Stars - OneRepublic",
            "♪ Lately I been, I been losing sleep\nDreaming about the things that we could be~ ♪",
            "minecraft:music.game.nether_wastes"
        ),
        new Song(
            "🎸 Heat Waves - Glass Animals",
            "♩ Sometimes, all I think about is you\nLate nights in the middle of June~ ♩",
            "minecraft:music.game.credits"
        ),
        new Song(
            "🎵 Stay - Justin Bieber ft. Kid LAROI",
            "♪ I do not wanna fall in love, if I ever did that\nI think I'd have a heart attack~ ♪",
            "minecraft:music.game"
        ),
        new Song(
            "🎹 As It Was - Harry Styles",
            "♩ Holding me back, gravity's holding me back\nI want you to hold out the palm of your hand~ ♩",
            "minecraft:music.creative"
        ),
        new Song(
            "🎤 Shape of You - Ed Sheeran",
            "♪ The club isn't the best place to find a lover\nSo the bar is where I go~ ♪",
            "minecraft:music.game.underwater"
        ),
        new Song(
            "🎸 Levitating - Dua Lipa",
            "♩ I got you, moonlight, you're my starlight\nI need you all night, come on, dance with me~ ♩",
            "minecraft:music.game.end"
        ),
        new Song(
            "🎵 Watermelon Sugar - Harry Styles",
            "♪ Tastes like strawberries on a summer evening\nAnd it sounds just like a song~ ♪",
            "minecraft:music.menu"
        ),
        new Song(
            "🎹 Sunflower - Post Malone & Swae Lee",
            "♩ Needless to say, I keep her in check\nShe was all bad-bad, nevertheless~ ♩",
            "minecraft:music.game"
        ),
        new Song(
            "🎤 Demons - Imagine Dragons",
            "♪ When the days are cold and the cards all fold\nAnd the saints we see are all made of gold~ ♪",
            "minecraft:music.creative"
        ),
        new Song(
            "🎸 Photograph - Ed Sheeran",
            "♩ Loving can hurt, loving can hurt sometimes\nBut it's the only thing that I know~ ♩",
            "minecraft:music.game.nether_wastes"
        ),
        new Song(
            "🎵 Let Her Go - Passenger",
            "♪ Only know you love her when you let her go\nAnd you let her go~ ♪",
            "minecraft:music.game.underwater"
        ),
        new Song(
            "🎹 Happier - Marshmello ft. Bastille",
            "♩ I want you to be happier, I want you to be happier\nWhen the morning comes~ ♩",
            "minecraft:music.menu"
        ),
        new Song(
            "🎤 Stressed Out - Twenty One Pilots",
            "♪ I wish I found some better sounds no one's ever heard\nI wish I had a better voice that sang some better words~ ♪",
            "minecraft:music.game"
        ),
        new Song(
            "🎸 Believer - Imagine Dragons",
            "♩ First things first, I'ma say all the words inside my head\nI'm fired up and tired of the way that things have been~ ♩",
            "minecraft:music.creative"
        ),
        new
