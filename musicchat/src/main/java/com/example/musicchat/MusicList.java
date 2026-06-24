package com.example.musicchat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MusicList {

    private static final Random RANDOM = new Random();

    private static final List<String> SONGS = Arrays.asList(
        "🎵 Imagine - John Lennon » ♩ Imagine all the people, living life in peace~ ♩",
        "🎸 Bohemian Rhapsody - Queen » ♩ Is this the real life? Is this just fantasy? ♩",
        "🎹 Shape of You - Ed Sheeran » ♪ I'm in love with the shape of you~ ♪",
        "🎤 Blinding Lights - The Weeknd » ♩ I've been tryna call, I'm in your walls~ ♩",
        "🎷 Sunflower - Post Malone » ♪ Needless to say, I keep her in check~ ♪",
        "🎺 Levitating - Dua Lipa » ♩ I got you, moonlight, you're my starlight~ ♩",
        "🎻 Demons - Imagine Dragons » ♪ When you feel my heat, look into my eyes~ ♪",
        "🎵 Watermelon Sugar - Harry Styles » ♩ Watermelon sugar high~ ♩",
        "🎙 Someone Like You - Adele » ♪ Never mind, I'll find someone like you~ ♪",
        "🎸 Counting Stars - OneRepublic » ♩ Lately I been, I been losing sleep~ ♩",
        "🎹 Let Her Go - Passenger » ♪ Only know you love her when you let her go~ ♪",
        "🥁 Happier - Marshmello » ♩ I want you to be happier~ ♩",
        "🎵 Stay - Justin Bieber » ♪ I do not wanna fall in love, if I ever did that~ ♪",
        "🎤 As It Was - Harry Styles » ♩ In this world, it's just us~ ♩",
        "🎸 Heat Waves - Glass Animals » ♪ Sometimes, all I think about is you~ ♪",
        // Nhạc Việt
        "🌸 Có Chắc Yêu Là Đây - Sơn Tùng MTP » ♩ Có chắc yêu là đây, là đây không em~ ♩",
        "🌺 Chúng Ta Của Hiện Tại - Sơn Tùng MTP » ♪ Chúng ta của hiện tại mãi vẫn còn đây~ ♪",
        "🎵 Waiting For You - MONO » ♩ I'm waiting for you, every single night~ ♩",
        "🌸 Đừng Làm Trái Tim Anh Đau - Sơn Tùng MTP » ♪ Dù sao thì anh cũng yêu em thật rồi~ ♪",
        "🎤 Nơi Này Có Anh - Sơn Tùng MTP » ♩ Nơi này có anh, có anh chờ em~ ♩"
    );

    public static String getRandom() {
        return SONGS.get(RANDOM.nextInt(SONGS.size()));
    }
}
