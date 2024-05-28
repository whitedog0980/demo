package com.example.demo.asset;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Article {

    private int id;
    private int member_id;
    private int board_id;
    private String title;
    private String contents;
    private int writeDate;
    private int editDate;


    public Article(Integer id, Integer member_id, Integer board_id,
                   String title, String contents, Integer writeDate,
                   Integer editDate) {
        this.id = id;
        this.member_id = member_id;
        this.board_id = board_id;
        this.title = title;
        this.contents = contents;
        this.writeDate = writeDate;
        this.editDate = editDate;
    }


    public int getId() {return this.member_id;}
    public int getMember_id() {return this.member_id;}
    public int getBoard_id() {return  this.board_id;}
    public String getTitle() {return this.title;}
    public String getContents() {return this.contents;}
    public int getWriteDate() {return this.writeDate;}
    public int getEditDate() {return editDate;}



    public void setMember_id(int member_id) {this.member_id = member_id;}
    public void setBoard_id(int board_id) {this.board_id = board_id;}
    public void setTitle(String title) {this.title = title;}
    public void setContents(String contents) {this.contents = contents;}
    public void setWriteDate(int writeDate) {this.writeDate = writeDate;}
    public void setEditDate(int editDate) {this.editDate = editDate;}
}

