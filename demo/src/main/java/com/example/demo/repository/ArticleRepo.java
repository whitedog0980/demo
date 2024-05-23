package com.example.demo.repository;

import java.util.HashMap;
import com.example.demo.asset.Article;

public class ArticleRepo {
    private HashMap<Integer, Article> articleMap = new HashMap<Integer, Article>();
    private static int article_id = 0;
    public HashMap<Integer, Article> getArticleMap(){
        return articleMap;
    }
    public Article getArticle(int id) {
        return articleMap.get(id);
    }
    public void addArticle(Article article) {
        articleMap.put(article_id, article);
        article_id++;
    }
    public void deleteArticle(int id) {
        articleMap.remove(id);
    }


}
