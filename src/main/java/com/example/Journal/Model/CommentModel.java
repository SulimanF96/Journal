package com.example.Journal.Model;

public class CommentModel {

    private String text;

    public CommentModel(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
