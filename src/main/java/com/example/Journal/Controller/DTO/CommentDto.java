package com.example.Journal.Controller.DTO;

public class CommentDto {

    private String text;

    public CommentDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

