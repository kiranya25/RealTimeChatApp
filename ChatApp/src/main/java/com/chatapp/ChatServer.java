package com.chatapp;

import java.util.*;

public class ChatServer {
    private static ChatServer instance;
    private final Map<String, ChatRoom> chatRooms = new HashMap<>();

    private ChatServer() { }

    public static synchronized ChatServer getInstance() {
        if (instance == null) {
            instance = new ChatServer();
        }
        return instance;
    }

    public synchronized void createChatRoom(String roomId) {
        if (!chatRooms.containsKey(roomId)) {
            chatRooms.put(roomId, new ChatRoom(roomId));
        }
    }

    public synchronized ChatRoom getChatRoom(String roomId) {
        return chatRooms.get(roomId);
    }

    public synchronized Collection<ChatRoom> getChatRooms() {
        return chatRooms.values();
    }
}
