package com.chatapp;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ChatServer chatServer;
    private PrintWriter out;
    private BufferedReader in;
    private User user;
    private ChatRoom chatRoom;

    public ClientHandler(Socket socket, ChatServer chatServer) {
        this.clientSocket = socket;
        this.chatServer = chatServer;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Enter your username: ");
            String username = in.readLine();
            user = new User(username);
            user.setOutputStream(out); // Set the PrintWriter for the user
            out.println("Welcome, " + username);

            while (true) {
                out.println("1. Join/Create Chat Room\n2. List Chat Rooms\n3. Exit\nChoose an option: ");
                String choice = in.readLine();

                if (choice.equals("1")) {
                    joinOrCreateChatRoom();
                } else if (choice.equals("2")) {
                    listChatRooms();
                } else if (choice.equals("3")) {
                    break;
                } else {
                    out.println("Invalid choice. Please try again.");
                }
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void joinOrCreateChatRoom() throws IOException {
        out.println("Enter chat room ID to join or create: ");
        String roomId = in.readLine();
        chatServer.createChatRoom(roomId);
        chatRoom = chatServer.getChatRoom(roomId);
        chatRoom.addUser(user);
        out.println(user.getUsername() + " has joined the chat room.");

        while (true) {
            out.println("1. Send Message\n2. List Active Users\n3. Leave Chat Room\nChoose an option: ");
            String choice = in.readLine();

            if (choice.equals("1")) {
                sendMessage();
            } else if (choice.equals("2")) {
                listActiveUsers();
            } else if (choice.equals("3")) {
                chatRoom.removeUser(user);
                break;
            } else {
                out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void sendMessage() throws IOException {
        out.println("Enter message: ");
        String message = in.readLine();
        chatRoom.sendMessage(user, message);
    }

    private void listChatRooms() {
        out.println("Active Chat Rooms:");
        for (ChatRoom chatRoom : chatServer.getChatRooms()) {
            out.println("Room ID: " + chatRoom.getRoomId());
        }
    }

    private void listActiveUsers() {
        out.println("Active Users:");
        for (User user : chatRoom.getUsers()) {
            out.println(user.getUsername());
        }
    }
}
