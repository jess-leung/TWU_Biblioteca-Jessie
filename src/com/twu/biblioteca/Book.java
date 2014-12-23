package com.twu.biblioteca;

/**
 * Created by jessieleung on 23/12/14.
 */
public class Book {

    private String title;
    private String author;
    private String year;
    private String status;

    public Book(String bookTitle, String bookAuthor, String bookYear){
        title = bookTitle;
        author = bookAuthor;
        year = bookYear;
        status = "Available";
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getYear(){
        return year;
    }

    public String getStatus(){
        return status;
    }

}
