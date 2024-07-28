package com.example;

public class AutoCompleteDecorator extends TextEditorDecorator {
    public AutoCompleteDecorator(TextEditor decoratedTextEditor) {
        super(decoratedTextEditor);
    }

    @Override
    public void write(String text) {
        super.write(text);
        autoComplete(text);
    }

    private void autoComplete(String text) {
        System.out.println("Auto-completing text for: " + text);
    }
}