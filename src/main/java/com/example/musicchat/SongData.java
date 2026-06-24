package com.example.musicchat;

import java.util.List;
import java.util.Random;

public class SongData {

    public record Song(String title, String artist, List<String> lyrics) {}

    private static final List<Song> SONGS = List.of(
        new Song("Đừng Làm Trái Tim Anh Đau", "Sơn Tùng M-TP", List.of(
            "♪ Đừng làm trái tim anh đau...",
            "♪ Dù em biết hay không biết...",
            "♪ Anh vẫn mãi yêu em thôi..."
        )),
        new Song("Chạy Ngay Đi", "Sơn Tùng M-TP", List.of(
            "♪ Chạy ngay đi, anh không dám nhìn...",
            "♪ Sợ đôi mắt nói lên tất cả...",
            "♪ Em ơi chạy ngay đi..."
        )),
        new Song("Never Gonna Give You Up", "Rick Astley", List.of(
            "♪ Never gonna give you up~",
            "♪ Never gonna let you down~",
            "♪ Never gonna run around and desert you~"
        )),
        new Song("Shape of You", "Ed Sheeran", List.of(
            "♪ I'm in love with the shape of you~",
            "♪ We push and pull like a magnet do~",
            "♪ Although my heart is falling too~"
        )),
        new Song("Blinding Lights", "The
