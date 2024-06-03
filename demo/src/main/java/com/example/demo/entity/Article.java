package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {
    private int id;
    private int member_id;
    private int board_id;
    private String title;
    private String contents;
    private int writeDate;
    private int editDate;
}
