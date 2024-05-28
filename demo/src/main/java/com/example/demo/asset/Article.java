package com.example.demo.asset;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Article {
    @Id
    private int id;
    @Column
    private int member_id;
    private int board_id;
    private String title;
    private String contents;
    private int writeDate;
    private int editDate;





}

