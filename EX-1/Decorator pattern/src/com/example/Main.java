package com.example;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new BasicTextEditor();
        TextEditor spellCheckedEditor = new SpellCheckDecorator(editor);
        TextEditor fullyFeaturedEditor = new GrammarCheckDecorator(new AutoCompleteDecorator(spellCheckedEditor));

        fullyFeaturedEditor.write("Hello, world!");
    }
}