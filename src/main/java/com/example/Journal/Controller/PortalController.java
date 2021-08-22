package com.example.Journal.Controller;

import com.example.Journal.Controller.DTO.ArticleDto;
import com.example.Journal.Controller.DTO.CommentDto;
import com.example.Journal.Service.PortalService;
import com.example.Journal.data.Article;
import com.example.Journal.data.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Article> addNewArticle(@Valid @RequestBody ArticleDto article, Principal principal){
      return new ResponseEntity<Article>(portalService.addNewArticle(article, principal.getName()),HttpStatus.OK);
    }


    // Everyone
    @GetMapping("/article")
    @PreAuthorize("permitAll()")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Article>> getAllArticles(){
        return new ResponseEntity<List<Article>>(portalService.getAllArticles(), HttpStatus.OK);
    }


    // eeveryone
    @GetMapping("/article/{articleId}")
    @PreAuthorize("permitAll()")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Article> getArticleById(@PathVariable long articleId){
        return new ResponseEntity<Article>(portalService.getArticleById(articleId), HttpStatus.OK);
    }


    // USer delete his own article
    @DeleteMapping("/article/{articleId}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<String> deleteArticleById(@PathVariable Long articleId, Principal principal){
        portalService.deleteArticleById(articleId, principal.getName());
        return new ResponseEntity<String>("An Article with" + " " + articleId + " " + "was deleted", HttpStatus.OK);
    }


    // USewr
    @PutMapping("/article/{articleId}/like")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<Article> addOneLikeToArticle(@PathVariable Long articleId){
        return new ResponseEntity<Article>(portalService.addOneLikeToArticle(articleId), HttpStatus.OK);
    }


    // USewr
    @PutMapping("/article/{articleId}/dislike")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<Article> addOneDisLikeToArticle(@PathVariable Long articleId){
        return new ResponseEntity<Article>(portalService.addOneDislikeToArticle(articleId), HttpStatus.OK);
    }

    // ADMIN
    @PutMapping("/article/{articleId}/disable")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Article> disableArticle(@PathVariable Long articleId){
        return new ResponseEntity<Article>(portalService.disableArticle(articleId), HttpStatus.OK);
    }

    // Admin
    @PutMapping("/article/{articleId}/enable")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Article> enableArticle(@PathVariable Long articleId){
        return new ResponseEntity<Article>(portalService.enableArticle(articleId), HttpStatus.OK);
    }

    @PostMapping("/article/{articleId}/comment")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<Comment> addNewArticleComment(@PathVariable Long articleId, @Valid @RequestBody CommentDto comment, Principal principal){
        return new ResponseEntity<Comment>(portalService.addNewArticleComment(articleId, comment, principal.getName()), HttpStatus.OK);
    }

    @GetMapping("/article/{articleId}/comment")
    @PreAuthorize("permitAll()")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Comment>> getArticleCommentById(@PathVariable Long articleId){
        return new ResponseEntity<List<Comment>>(portalService.getArticleComments(articleId), HttpStatus.OK);
    }


}
