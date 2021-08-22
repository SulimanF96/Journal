package com.example.Journal.Controller.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    @Size(min = 1, max = 99, message="text cannot be more than 99 characters")
    private String text;

    public CommentDto(String text) {
        this.text = text;
    }
}

