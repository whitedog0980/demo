package com.example.demo.repository;


import com.example.demo.asset.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Repository
public class ArticleRepoJDBC implements AricleRepoInterface{
    private HashMap<Integer, Article> articleMap = new HashMap<Integer, Article>();
    private static int article_id = 0;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleRepoJDBC(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}


    @Transactional
    @Override
    public void append(Article article) {
        String sql = "INSERT INTO article (idarticle, member_idmember, board_idboard, title, content, writeDate, editDate)" +
            "VALUES (?, ?, ?, ?, ?, now(), now())";
        jdbcTemplate.update(sql,article_id, article.getMember_id(), article.getBoard_id(), article.getTitle(), article.getContents());
        article_id++;
    }
    @Override
    public Article getById(int id) {
        String sql = "SELECT * FROM article WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Article temp = new Article(
                rs.getInt("articleid"),
                rs.getInt("board_idboard"),
                rs.getInt("member_idmember"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getInt("writeDate"),
                rs.getInt("editDate")
            );
            return temp;
        });
    }


    public HashMap<Integer, Article> getAll() {
        String sql = "SELECT * FROM article ORDER BY idarticle";
        List<Article> articles = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Article temp = new Article(
                rs.getInt("articleid"),
                rs.getInt("board_id"),
                rs.getInt("member_id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getInt("writeDate"), // 예시: Timestamp 타입으로 가져오는 것으로 가정
                rs.getInt("editDate")    // 예시: Timestamp 타입으로 가져오는 것으로 가정
            );
            return temp;
        });

        HashMap<Integer, Article> articleMap = new HashMap<>();
        for (Article article : articles) {
            articleMap.put(article.getId(), article);
        }

        return articleMap;
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM article WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }
}
