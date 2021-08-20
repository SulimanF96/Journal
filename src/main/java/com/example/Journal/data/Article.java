package com.example.Journal.data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long articleId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String body;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Integer likes;

    @Column(nullable = false)
    private Integer dislikes;

    @Column(nullable = false)
    private Boolean disabled;

    @OneToMany
    private List<Comment> comments;

    public Article(Long id, String title, String body, String author, Date createdAt, Integer likes, Integer dislikes, Boolean disabled, List<Comment> comments) {
        this.articleId = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.createdAt = createdAt;
        this.likes = likes;
        this.dislikes = dislikes;
        this.disabled = disabled;
        this.comments = comments;
    }

    public Article( String title, String body, String author, Date createdAt, Integer likes, Integer dislikes, Boolean disabled, List<Comment> comments) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.createdAt = createdAt;
        this.likes = likes;
        this.dislikes = dislikes;
        this.disabled = disabled;
        this.comments = comments;
    }

    public Article( ){

    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
