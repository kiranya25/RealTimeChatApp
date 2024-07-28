package com.chatapp;

import java.io.*;
import java.net.*;

public class SocketCommunicationAdapter implements CommunicationAdapter {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public SocketCommunicationAdapter(Socket socket) throws IOException {
        this.socket = socket;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void sendMessage(String message) {
        out.println(message);
    }

    @Override
    public String receiveMessage() {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
