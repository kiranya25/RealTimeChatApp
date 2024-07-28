package com.chatapp;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatRoom {
    private final String roomId;
    private final List<User> users = new CopyOnWriteArrayList<>();
    private final List<String> messages = new ArrayList<>();

    public ChatRoom(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public synchronized void addUser(User user) {
        users.add(user);
        notifyUsers();
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
        notifyUsers();
    }

    public synchronized void sendMessage(User user, String message) {
        messages.add(user.getUsername() + ": " + message);
        notifyUsers();
    }

    public synchronized List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public synchronized List<User> getUsers() {
        return new ArrayList<>(users);
    }

    private void notifyUsers() {
        for (User user : users) {
            user.getOutputStream().println("Active Users: " + getUsernames());
            user.getOutputStream().println("Messages: " + getMessages());
        }
    }

    private List<String> getUsernames() {
        List<String> usernames = new ArrayList<>();
        for (User user : users) {
            usernames.add(user.getUsername());
        }
        return usernames;
    }
}
