package com.example.Journal.Controller.DTO;


public class ArticleDto {


    private String Title;

    private String body;

    public ArticleDto(String title, String body) {
        Title = title;
        this.body = body;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

