package com.example;

public class MediaAdapterPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    public MediaAdapterPlayer() {
        this.mediaAdapter = new MediaAdapter(new VideoPlayer());
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("audio")) {
            System.out.println("Playing audio: " + fileName);
        } else if (audioType.equalsIgnoreCase("video")) {
            mediaAdapter.play(audioType, fileName);
        }
    }
}
