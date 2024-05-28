package com.example.demo;

import com.example.demo.asset.Article;
import com.example.demo.repository.ArticleRepo;
import com.example.demo.repository.ArticleRepoJDBC;

import java.util.HashMap;

public class Service {
    private ArticleRepo articleRepo = new ArticleRepo();
    private ArticleRepoJDBC articleRepoJDBC;

    public boolean isContainElements(Article article) {
        if (article.getTitle() == null || article.getContents() == null) {
            return false;
        }
        return true;
    }

//    public boolean isExist(int id){
//        return articleRepo.getArticleMap().containsKey(id);
//    }
//    public void deleteArticle(int id){
//        articleRepo.deleteArticle(id);
//    }
//    public HashMap<Integer, Article> getArticleMap() {
//        return articleRepo.getArticleMap();
//    }
//    public Article getArticle(int id) {
//        return articleRepo.getArticle(id);
//    }
//    public void addArticle(Article article) {
//        articleRepo.addArticle(article);
//    }

    public boolean isExist(int id){
        return articleRepoJDBC.getAll().containsKey(id);
    }
    public void deleteArticle(int id){
        articleRepoJDBC.delete(id);
    }
    public HashMap<Integer, Article> getArticleMap() {
        return articleRepoJDBC.getAll();
    }
    public Article getArticle(int id) {
        return articleRepoJDBC.getById(id);
    }
    public void addArticle(Article article) {
        articleRepoJDBC.append(article);
    }
}
