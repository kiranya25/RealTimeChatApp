package com.chatapp;

import java.io.PrintWriter;

public class User {
    private final String username;
    private PrintWriter outputStream;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public PrintWriter getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(PrintWriter outputStream) {
        this.outputStream = outputStream;
    }
}
