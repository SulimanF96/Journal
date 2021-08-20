package com.example.Journal.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class ArticleModel {


    private String title;
    private String body;

    public ArticleModel(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
