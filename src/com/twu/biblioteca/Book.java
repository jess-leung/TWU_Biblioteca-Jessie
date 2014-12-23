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

    @Override
    public boolean equals(Object o){
        if(o instanceof Book){
            Book b = (Book) o;
            if(b.getTitle().equals(title) && b.getAuthor().equals(author) && b.getYear().equals(year)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public void setUnavailable(){
        status = "Unavailable";
    }

    public void setAvailable(){
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
