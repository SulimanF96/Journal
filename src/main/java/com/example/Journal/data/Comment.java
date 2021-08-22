package com.example.Journal.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 1, max = 99, message="text cannot be more than 99 characters")
    @Column(length = 100, nullable = false)
    private String text;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private String user;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;


    public Comment(String text, Date createdAt, String user) {
        this.text = text;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Comment(Long id, String text, Date createdAt, String user) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
        this.user = user;
    }

}
