package com.twu.biblioteca;

import java.io.IOException;
import java.util.*;

/**
 * Created by jessieleung on 23/12/14.
 */
public class BookCollection extends MediaCollection {

    private static final String NOT_VALID_BOOK_TO_RETURN = "That is not a valid book to return.";
    private static final String BOOK_NOT_AVAILABLE = "That book is not available.";
    private static final String THANK_YOU_RETURN_BOOK = "Thank you for returning the book.";
    private static final String THANK_YOU_ENJOY_BOOK = "Thank you! Enjoy the book";
    private static final String INPUT_BOOK_ID = "Input a book (id): ";

    public BookCollection(){
        super();
    }

    /**
     * Method to add a book to the library
     */
    public void add(String title, String author, String year){
        Book newBook = new Book(title,author,year);
        library.add(newBook);
    }

    /**
     * Get all books from the library
     */
    public void list(){
        for(MediaItem item:library){
            Book b = (Book) item;
            if(b.getStatus().equals("Available")) {
                System.out.format("%4d %-50s %-50s %-4s%n", library.indexOf(b), b.getTitle(), b.getAuthor(), b.getYear());
            }
        }
    }

    /**
     * Get a book's details from the library
     */
    public Book getBook(int idx){
        try{
            Book thisBook = (Book) library.get(idx);
            return thisBook;
        }
        catch(IndexOutOfBoundsException ex){
            return null;
        }
    }

    /**
     * Check out a book
     * @return
     */
    public Book checkout(){
        try{
            Book checkedOutBook = (Book) super.checkout();
            return checkedOutBook;
        }
        catch(Exception e){
            System.out.println(BOOK_NOT_AVAILABLE);
            return null;
        }
    }

    /**
     * Get user input to return a book
     */
    public Book returnItem(){
        try {
            Book returnedBook = (Book) super.returnItem();
            return returnedBook;
        }
        catch(Exception e){
            System.out.println(NOT_VALID_BOOK_TO_RETURN);
            return null;
        }
    }

    /**
     * Display not available book message
     */
    public void displayNotAvailableMessage(){
        System.out.println(BOOK_NOT_AVAILABLE);
    }

    /**
     * Display not valid book to return message
     */
    public void displayNotValidItemToReturnMessage(){
        System.out.println(NOT_VALID_BOOK_TO_RETURN);
    }

    /**
     * Display book-specific thank you for checkout message
     */
    public void displayThankYouEnjoyMessage(){
        System.out.println(THANK_YOU_ENJOY_BOOK);
    }

    /**
     * Display book-specific thank you for returning message
     */
    public void displayThankYouReturnMessage(){
        System.out.println(THANK_YOU_RETURN_BOOK);
    }

    /**
     * Get user input
     */
    public String getUserOption() throws IOException{
        return helper.getUserInput(INPUT_BOOK_ID);
    }

}
