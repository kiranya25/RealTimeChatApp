package com.example;

public class ConcreteDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String type) {
        switch (type) {
            case "Word":
                return new WordDocument();
            case "Excel":
                return new ExcelDocument();
            case "PDF":
                return new PDFDocument();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}
