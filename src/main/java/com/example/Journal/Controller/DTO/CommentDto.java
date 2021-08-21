package com.example.Journal.Controller.DTO;

import java.io.Serializable;

public class CommentDto {

    private String text;

    public CommentDto() {

    }

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

