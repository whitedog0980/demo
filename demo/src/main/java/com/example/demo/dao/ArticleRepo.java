package com.example.demo.dao;

import com.example.demo.entity.Article;

import java.util.List;

public interface ArticleRepo {
    Article saveArticle(Article article);
    Article updateArticle(Article article);
    Article getById(int id);
    String deleteById(int id);
    List<Article> allArticle();
}
