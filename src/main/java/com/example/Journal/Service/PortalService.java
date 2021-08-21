package com.example.Journal.Service;

import com.example.Journal.Model.ArticleModel;
import com.example.Journal.Model.CommentModel;
import com.example.Journal.data.Article;
import com.example.Journal.data.Comment;

import java.util.List;

public interface PortalService {

    Article addNewArticle(ArticleModel article, String username);

    Article getArticleById(Long articleId);

    List<Article> getAllArticles();

    void deleteArticleById(Long Id, String username);

    Comment addNewArticleComment(Long articleId, CommentModel text, String username);

    List<Comment> getArticleComments(Long articleId);

    Article addOneLikeToArticle(Long ArticleId);

    Article addOneDislikeToArticle(Long articleId);

    Article disableArticle(Long articleId);

    Article enableArticle(Long articleId);

}
