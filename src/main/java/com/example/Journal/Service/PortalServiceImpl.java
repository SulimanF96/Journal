package com.example.Journal.Service;

import com.example.Journal.Model.ArticleModel;
import com.example.Journal.Model.CommentModel;
import com.example.Journal.data.Article;
import com.example.Journal.data.ArticleRepository;
import com.example.Journal.data.Comment;
import com.example.Journal.data.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PortalServiceImpl implements PortalService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CommentRepository commentRepository;

    public PortalServiceImpl() {
        super();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Article addNewArticle(ArticleModel article) {
        Article newArticle = new Article(article.getTitle(), article.getBody(), "Suliman", new Date(), 0, 0, false, new ArrayList<>());
        articleRepository.save(newArticle);
        return articleRepository.save(newArticle);
    }

    @Override
    public Article getArticleById(Long articleId) {
        Article article = articleRepository.getById(articleId);
        return new Article(article.getArticleId(), article.getTitle(), article.getBody(), article.getAuthor(), article.getCreatedAt(), article.getLikes(), article.getDislikes(), article.getDisabled(), article.getComments());
    }

    @Override
    public List<Article> getAllArticles() {
        List<Article> articles= articleRepository.findAll().stream().map((article) ->
                new Article(
                        article.getArticleId(),
                        article.getTitle(),
                        article.getBody(),
                        article.getAuthor(),
                        article.getCreatedAt(),
                        article.getLikes(),
                        article.getDislikes(),
                        article.getDisabled(),
                        article.getComments())).filter(article -> !article.getDisabled()).collect(Collectors.toList());
        return articles;
    }

    @Override
    public void deleteArticleById(Long articleId) {
        Article article = articleRepository.findByArticleId(articleId);
        articleRepository.delete(article);
    }

    @Override
    public Article addNewArticleComment(Long articleId, CommentModel newComment) {
        Comment comment = commentRepository.save(new Comment(newComment.getText(), new Date(), "Suliman" ));
        Article article = articleRepository.findByArticleId(articleId);
        List<Comment>  comments = new ArrayList<>(article.getComments());
        comments.add(comment);
        article.setComments(comments);
        return articleRepository.save(article);
    }

    @Override
    public List<Comment> getArticleComments(Long articleId) {
        return null;
    }

    @Override
    public Article addOneLikeToArticle(Long ArticleId) {
        Article article = articleRepository.findByArticleId(ArticleId);
        article.setLikes(article.getLikes() + 1);
        return articleRepository.save(article);
    }

    @Override
    public Article addOneDislikeToArticle(Long articleId) {
        Article article = articleRepository.findByArticleId(articleId);
        if(article.getLikes() > 0){
            article.setLikes(article.getLikes() - 1);
        }
        return articleRepository.save(article);
    }

    @Override
    public Article disableArticle(Long articleId) {
        Article article = articleRepository.findByArticleId(articleId);
        if(!article.getDisabled()){
            article.setDisabled(true);
        }
        return articleRepository.save(article);
    }

    @Override
    public Article enableArticle(Long articleId) {
        Article article = articleRepository.findByArticleId(articleId);
        if(article.getDisabled()){
            article.setDisabled(false);
        }
        return articleRepository.save(article);
    }
}
