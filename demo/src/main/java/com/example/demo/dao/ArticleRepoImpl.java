package com.example.demo.dao;

import com.example.demo.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepoImpl implements ArticleRepo {
    private static final String INSERT_ARTICLE_QUERY =
        "INSERT INTO ARTICLE(id, author_id, board_id, title, content, created_date, modified_date) values(?, ?, ?, ?, ?, now, now)";
    private static final String UPDATE_ARTICLE_BY_ID_QUERY =
        "UPDATE ARTICLE SET title=? WHERE ID=?";
    private static final String GET_ARTICLE_BY_ID_QUERY =
        "SELECT * FROM USER WHERE ID=?";
    private static final String DELETE_USER_BY_ID =
        "DELETE FROM USER WHERE ID=?";
    private static final String GET_ARTICLE_QUERY =
        "SELECT * FROM USER";



    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Article saveArticle(Article article) {
        jdbcTemplate.update(INSERT_ARTICLE_QUERY,
            article.getId(), article.getMember_id(),
            article.getBoard_id(), article.getTitle(),
            article.getWriteDate(), article.getEditDate());
        return article;
    }

    @Override
    public Article updateArticle(Article article) {
        jdbcTemplate.update(UPDATE_ARTICLE_BY_ID_QUERY,
            article.getTitle(), article.getId());
        return article;
    }

    @Override
    public Article getById(int id) {
        jdbcTemplate.queryForObject(GET_ARTICLE_BY_ID_QUERY, (rs, rowNum)-> {
            return new Article(rs.getInt("id"), rs.getInt("author_id"), rs.getInt("board_id"),
                rs.getString("title"), rs.getString("content"),
                rs.getInt("created_date"), rs.getInt("modified_date"));
        });
        return null;
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID, id);
        return "Article got deleted bt id" + id;
    }

    @Override
    public List<Article> allArticle() {
        return jdbcTemplate.query(GET_ARTICLE_QUERY, (rs, rowNum)-> {
            return new Article(rs.getInt("id"), rs.getInt("author_id"), rs.getInt("board_id"),
                rs.getString("title"), rs.getString("content"),
                rs.getInt("created_date"), rs.getInt("modified_date"));
        });
    }
}
