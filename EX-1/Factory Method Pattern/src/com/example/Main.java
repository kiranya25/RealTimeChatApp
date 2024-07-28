package com.example;

public class Main {
    public static void main(String[] args) {
        DocumentFactory factory = new ConcreteDocumentFactory();
        
        factory.getDocument("Word");
        factory.getDocument("Excel");
        factory.getDocument("PDF");
    }
}