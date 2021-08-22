package com.example.Journal.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 1, max = 99, message="title cannot be more than 99 characters")
    @Column(length = 100, nullable = false)
    private String title;


    @Size(min = 1, max = 499, message="body cannot be more than 499 characters")
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


    public Article(Long id, String title, String body, String author, Date createdAt, Integer likes, Integer dislikes, Boolean disabled) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.createdAt = createdAt;
        this.likes = likes;
        this.dislikes = dislikes;
        this.disabled = disabled;
    }

    public Article( String title, String body, String author, Date createdAt, Integer likes, Integer dislikes, Boolean disabled) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.createdAt = createdAt;
        this.likes = likes;
        this.dislikes = dislikes;
        this.disabled = disabled;
    }

}
