package com.example;

public abstract class DocumentFactory {
    public abstract Document createDocument(String type);

    public Document getDocument(String type) {
        Document doc = createDocument(type);
        doc.open();
        return doc;
    }
}
