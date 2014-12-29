package com.twu.biblioteca;

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
        try {
            String userOption = helper.getUserInput(INPUT_BOOK_ID);
            Book checkedBook = checkoutBook(Integer.parseInt(userOption));
            return checkedBook;
        }
        catch(Exception e){
            System.out.println(BOOK_NOT_AVAILABLE);
            return null;
        }
    }

    /**
     * Get user input to return a book
     */
    public Book returnBook(){
        try {
            String userOption = helper.getUserInput(INPUT_BOOK_ID);
            Book returnedBook = returnBookProcess(Integer.parseInt(userOption));
            return returnedBook;
        }
        catch(Exception e){
            System.out.println(NOT_VALID_BOOK_TO_RETURN);
            return null;
        }
    }

    /**
     * Perform operation to check out a book from the library
     * @param idx
     */
    public Book checkoutBook(int idx) throws IndexOutOfBoundsException{
        Book thisBook = (Book) library.get(idx);
        if(thisBook.getStatus().equals("Available")) {
            thisBook.setUnavailable();
            System.out.println(THANK_YOU_ENJOY_BOOK);
            return thisBook;
        }
        else{
            System.out.println(BOOK_NOT_AVAILABLE);
            return null;
        }
    }

    /**
     * Performs the returning a book process
     * @param bookId
     */
    public Book returnBookProcess(int bookId) throws IndexOutOfBoundsException{
        Book thisBook = (Book) library.get(bookId);
        if(thisBook.getStatus().equals("Unavailable")) {
            thisBook.setAvailable();
            System.out.println(THANK_YOU_RETURN_BOOK);
            return thisBook;
        }
        else{
            System.out.println(NOT_VALID_BOOK_TO_RETURN);
            return null;
        }
    }

    /**
     * Get the size of available library
     */
    public int sizeAvailable(){
        int size = 0;
        for(MediaItem item:library){
            Book b = (Book) item;
            if(b.getStatus().equals("Available")){
                size+=1;
            }
        }
        return size;
    }
}
