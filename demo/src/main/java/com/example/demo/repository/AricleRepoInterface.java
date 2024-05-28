package com.example.demo.repository;

import com.example.demo.asset.Article;

import java.util.HashMap;
import java.util.List;

public interface AricleRepoInterface {
    public void append(Article article);
    public Article getById(int id);
    public void delete(Integer id);
    public HashMap<Integer, Article> getAll();
}
