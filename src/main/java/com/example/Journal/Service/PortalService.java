package com.example.Journal.Service;

import com.example.Journal.Controller.DTO.ArticleDto;
import com.example.Journal.Controller.DTO.CommentDto;
import com.example.Journal.Exception.InputFieldException;
import com.example.Journal.Exception.NotAllowedForThisUserExeption;
import com.example.Journal.data.Article;
import com.example.Journal.data.Comment;

import java.util.List;

public interface PortalService {

    Article addNewArticle(ArticleDto article, String username);

    Article getArticleById(Long articleId);

    List<Article> getAllArticles();

    void deleteArticleById(Long Id, String username) throws NotAllowedForThisUserExeption;

    Comment addNewArticleComment(Long articleId, CommentDto text, String username);

    List<Comment> getArticleComments(Long articleId);

    Article addOneLikeToArticle(Long ArticleId);

    Article addOneDislikeToArticle(Long articleId);

    Article disableArticle(Long articleId);

    Article enableArticle(Long articleId);

}
