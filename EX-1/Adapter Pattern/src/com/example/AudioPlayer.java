package com.example;

public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        System.out.println("Playing audio: " + fileName);
    }
}
