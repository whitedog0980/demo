package com.example.demo.repository;


import com.example.demo.asset.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ArticleRepoJDBC implements AricleRepoInterface{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleRepoJDBC(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}


    @Transactional
    @Override
    public void append(Article article) {
        String sql = "INSERT INTO article (member_id, board_id, title, contents, created_date, modified_date)" +
            "VALUES (?, ?, ?, ?, now(), now())";
        jdbcTemplate.update(sql, article.getMember_id(), article.getBoard_id(), article.getTitle(), article.getContents());
    }

    public Article ArticleRowMapper(int id) {
        String sql = "SELECT * FROM article WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Article temp = new Article();
            rs.getInt("board_id");
            rs.getInt("member_id");
            rs.getString("title");
            rs.getString("content");
            return temp;
        });
    }
}
