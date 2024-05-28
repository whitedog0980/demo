package com.example.demo.repository;

import com.example.demo.asset.Article;

import java.util.List;

public interface AricleRepoInterface {

    public interface ArticleRepository {
        public void append(Article body);
        public Article findById(Integer id);
        public void edit(Integer id, Article body);
        public void delete(Integer id);
        public List<Article> getAll();
        public List<Article> getBoardAll(Integer boardId);
        public Article getRecent();
        public boolean isEmpty();
        public boolean containId(Integer id);
        public boolean containBoardId(Integer boardId);
    }
}
