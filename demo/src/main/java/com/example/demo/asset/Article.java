package com.example.demo.asset;

public class Article {
    private int Article_U_id = 0;
    private int member_id;
    private int board_id;
    private String title;
    private String contents;
    private int writeDate;
    private int editDate;


    public int getArticle_U_id() {return this.Article_U_id;}
    public int getMember_id() {return this.member_id;}
    public int getBoard_id() {return  this.board_id;}
    public String getTitle() {return this.title;}
    public String getContents() {return this.contents;}
    public int getWriteDate() {return this.writeDate;}
    public int getEditDate() {return editDate;}


    public void setArticle_U_id(int article_U_id) {this.Article_U_id = article_U_id;}
    public void setMember_id(int member_id) {this.member_id = member_id;}
    public void setBoard_id(int board_id) {this.board_id = board_id;}
    public void setTitle(String title) {this.title = title;}
    public void setContents(String contents) {this.contents = contents;}
    public void setWriteDate(int writeDate) {this.writeDate = writeDate;}
    public void setEditDate(int editDate) {this.editDate = editDate;}
}

