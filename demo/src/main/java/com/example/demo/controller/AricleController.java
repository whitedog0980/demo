package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.dao.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AricleController {
    @Autowired
    ArticleRepo articleRepo;
    @PostMapping("/article")
    public Article addArticle(Article article) {
        return articleRepo.saveArticle(article);
    }
    @PutMapping("/article")
    public Article updateArticle(Article article) {
        return articleRepo.updateArticle(article);
    }

    @GetMapping("/user/{id}")
    public Article getArticle(int id) {
        return articleRepo.getById(id);
    }

    @GetMapping("/users")
    public List<Article> getArticles() {
        return articleRepo.allArticle();
    }
}
