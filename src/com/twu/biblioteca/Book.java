package com.twu.biblioteca;

/**
 * Created by jessieleung on 23/12/14.
 */
public class Book extends MediaItem {

    private String author;

    public Book(String bookTitle, String bookAuthor, String bookYear){
        super(bookTitle,bookYear);
        author = bookAuthor;
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

    public String getAuthor(){
        return author;
    }

}
