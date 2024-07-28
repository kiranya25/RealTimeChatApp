package com.example;

public class Main {
    public static void main(String[] args) {
        MediaAdapterPlayer player = new MediaAdapterPlayer();

        player.play("audio", "song.mp3");
        player.play("video", "movie.mp4");
    }
}