package com.example;
public class SpellCheckDecorator extends TextEditorDecorator {
    public SpellCheckDecorator(TextEditor decoratedTextEditor) {
        super(decoratedTextEditor);
    }

    @Override
    public void write(String text) {
        super.write(text);
        checkSpelling(text);
    }

    private void checkSpelling(String text) {
        System.out.println("Checking spelling for: " + text);
    }
}
