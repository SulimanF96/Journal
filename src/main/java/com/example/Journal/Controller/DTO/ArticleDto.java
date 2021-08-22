package com.example.Journal.Controller.DTO;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ArticleDto {


    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 99, message="title cannot be more than 99 characters")
    private String Title;

    @NotBlank(message = "Body is mandatory")
    @Size(min = 1, max = 499, message="body cannot be more than 499 characters")
    private String body;

    public ArticleDto(String title, String body) {
        Title = title;
        this.body = body;
    }

}



