package com.example;

public class GrammarCheckDecorator extends TextEditorDecorator {
    public GrammarCheckDecorator(TextEditor decoratedTextEditor) {
        super(decoratedTextEditor);
    }

    @Override
    public void write(String text) {
        super.write(text);
        checkGrammar(text);
    }

    private void checkGrammar(String text) {
        System.out.println("Checking grammar for: " + text);
    }
}
