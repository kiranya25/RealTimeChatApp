package com.chatapp;

import java.util.Scanner;

public class ChatMenu {
    private final User currentUser;
    private ChatRoom currentRoom;
    private final Scanner scanner = new Scanner(System.in);

    public ChatMenu(Client client, User user) {
        this.currentUser = user;
    }

    public void start() {
        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    joinOrCreateChatRoom();
                    break;
                case 2:
                    listChatRooms();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("1. Join/Create Chat Room");
        System.out.println("2. List Chat Rooms");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private void joinOrCreateChatRoom() {
        System.out.print("Enter chat room ID to join or create: ");
        String roomId = scanner.nextLine();
        ChatServer chatServer = ChatServer.getInstance();
        chatServer.createChatRoom(roomId);
        currentRoom = chatServer.getChatRoom(roomId);
        currentRoom.addUser(currentUser);
        System.out.println(currentUser.getUsername() + " has joined the chat room.");

        while (true) {
            System.out.println("1. Send Message");
            System.out.println("2. List Active Users");
            System.out.println("3. Leave Chat Room");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    sendMessage();
                    break;
                case 2:
                    listActiveUsers();
                    break;
                case 3:
                    currentRoom.removeUser(currentUser);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void sendMessage() {
        System.out.print("Enter message: ");
        String message = scanner.nextLine();
        currentRoom.sendMessage(currentUser, message);
    }

    private void listChatRooms() {
        ChatServer chatServer = ChatServer.getInstance();
        System.out.println("Active Chat Rooms:");
        for (ChatRoom chatRoom : chatServer.getChatRooms()) {
            System.out.println("Room ID: " + chatRoom.getRoomId());
        }
    }

    private void listActiveUsers() {
        System.out.println("Active Users:");
        for (User user : currentRoom.getUsers()) {
            System.out.println(user.getUsername());
        }
    }
}
