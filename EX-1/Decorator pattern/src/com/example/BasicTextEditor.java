package com.example;

public class BasicTextEditor implements TextEditor {
    @Override
    public void write(String text) {
        System.out.println("Writing text: " + text);
    }
}