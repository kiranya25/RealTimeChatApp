package com.chatapp;

public interface CommunicationAdapter {
    void sendMessage(String message);
    String receiveMessage();
}
