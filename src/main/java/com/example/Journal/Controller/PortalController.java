package com.example.Journal.Controller;

import com.example.Journal.Controller.DTO.ArticleDto;
import com.example.Journal.Controller.DTO.CommentDto;
import com.example.Journal.Model.ArticleModel;
import com.example.Journal.Model.CommentModel;
import com.example.Journal.Service.PortalService;
import com.example.Journal.data.Article;
import com.example.Journal.data.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PortalController {

    @Autowired
    PortalService portalService;


    // USER
    @PostMapping("/article")
    @PreAuthorize("hasAnyAuthority('USER')")
    public Article addNewArticle(@RequestBody ArticleDto article, Principal principal){
      return portalService.addNewArticle(new ArticleModel(article.getTitle(), article.getBody()), principal.getName());
    }


    // Everyone
    @GetMapping("/article")
    @PreAuthorize("permitAll()")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Article> getAllArticles(){
        return portalService.getAllArticles();
    }


    // eeveryone
    @GetMapping("/article/{articleId}")
    @PreAuthorize("permitAll()")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Article getArticleById(@PathVariable long articleId){
        return portalService.getArticleById(articleId);
    }


    // USer delete his own article
    @DeleteMapping("/article/{articleId}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public String deleteArticleById(@PathVariable Long articleId, Principal principal){
        portalService.deleteArticleById(articleId, principal.getName());
        return articleId + "was deleted";
    }


    // USewr
    @PutMapping("/article/{articleId}/like")
    @PreAuthorize("hasAnyAuthority('USER')")
    public Article addOneLikeToArticle(@PathVariable Long articleId){
        return portalService.addOneLikeToArticle(articleId);
    }


    // USewr
    @PutMapping("/article/{articleId}/dislike")
    @PreAuthorize("hasAnyAuthority('USER')")
    public Article addOneDisLikeToArticle(@PathVariable Long articleId){
        return portalService.addOneDislikeToArticle(articleId);
    }

    // ADMIN
    @PutMapping("/article/{articleId}/disable")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Article disableArticle(@PathVariable Long articleId){
        return portalService.disableArticle(articleId);
    }

    // Admin
    @PutMapping("/article/{articleId}/enable")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Article enableArticle(@PathVariable Long articleId){
        return portalService.enableArticle(articleId);
    }

    @PostMapping("/article/{articleId}/comment")
    @PreAuthorize("hasAnyAuthority('USER')")
    public Comment addNewArticleComment(@PathVariable Long articleId, @RequestBody CommentDto comment, Principal principal){
        return portalService.addNewArticleComment(articleId, new CommentModel(comment.getText()), principal.getName());
    }

    @GetMapping("/article/{articleId}/comment")
    @PreAuthorize("permitAll()")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Comment> getArticleCommentById(@PathVariable Long articleId){
        return portalService.getArticleComments(articleId);
    }


}
