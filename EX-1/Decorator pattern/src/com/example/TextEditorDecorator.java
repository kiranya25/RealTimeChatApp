package com.example;

public abstract class TextEditorDecorator implements TextEditor {
    protected TextEditor decoratedTextEditor;

    public TextEditorDecorator(TextEditor decoratedTextEditor) {
        this.decoratedTextEditor = decoratedTextEditor;
    }

    @Override
    public void write(String text) {
        decoratedTextEditor.write(text);
    }
}
