package com.example.Journal.Service;

import com.example.Journal.Model.ArticleModel;
import com.example.Journal.Model.CommentModel;
import com.example.Journal.data.Article;
import com.example.Journal.data.ArticleRepository;
import com.example.Journal.data.Comment;
import com.example.Journal.data.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
    public Article addNewArticle(ArticleModel article, String username) {
        Article newArticle = new Article(article.getTitle(), article.getBody(), username, new Date(), 0, 0, false);
        articleRepository.save(newArticle);
        return articleRepository.save(newArticle);
    }

    @Override
    public Article getArticleById(Long articleId) {
        Article article = articleRepository.getById(articleId);
        return new Article(article.getId(), article.getTitle(), article.getBody(), article.getAuthor(), article.getCreatedAt(), article.getLikes(), article.getDislikes(), article.getDisabled());
    }

    @Override
    public List<Article> getAllArticles() {
        List<Article> articles= articleRepository.findAll().stream().map((article) ->
                new Article(
                        article.getId(),
                        article.getTitle(),
                        article.getBody(),
                        article.getAuthor(),
                        article.getCreatedAt(),
                        article.getLikes(),
                        article.getDislikes(),
                        article.getDisabled())).filter(article -> !article.getDisabled()).collect(Collectors.toList());
        return articles;
    }

    @Override
    public List<Comment> getArticleComments(Long articleId) {
        List<Comment> comments= commentRepository.findByArticleId(articleId).stream().map((comment) ->
                new Comment(
                        comment.getId(),
                        comment.getText(),
                        comment.getCreatedAt(),
                        comment.getUser())).collect(Collectors.toList());
        return comments;
    }

    @Override
    public void deleteArticleById(Long articleId, String username) {
        Optional<Article> article = articleRepository.findById(articleId);
        if(article.get().getAuthor() == username){
            articleRepository.delete(article.get());
        }
    }

    @Override
    public Comment addNewArticleComment(Long articleId, CommentModel newComment, String username) {
        Comment comment = new Comment(newComment.getText(), new Date(), username );
        Optional<Article> article = articleRepository.findById(articleId);
        comment.setArticle(article.get());
        return commentRepository.save(comment);
    }


    @Override
    public Article addOneLikeToArticle(Long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        article.get().setLikes(article.get().getLikes() + 1);
        return articleRepository.save(article.get());
    }

    @Override
    public Article addOneDislikeToArticle(Long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        article.get().setDislikes(article.get().getDislikes() + 1);
        return articleRepository.save(article.get());
    }

    @Override
    public Article disableArticle(Long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        if(!article.get().getDisabled()){
            article.get().setDisabled(true);
        }
        return articleRepository.save(article.get());
    }

    @Override
    public Article enableArticle(Long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        if(article.get().getDisabled()){
            article.get().setDisabled(false);
        }
        return articleRepository.save(article.get());
    }
}
