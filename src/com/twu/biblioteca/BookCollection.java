package com.twu.biblioteca;

import java.util.*;

/**
 * Created by jessieleung on 23/12/14.
 */
public class BookCollection {
    private ArrayList<Book> library;
    private IOHelper helper;

    public BookCollection(){
        library = new ArrayList<Book>();
        helper = new IOHelper();
    }

    /**
     * Method to add a book to the library
     */
    public void addBook(String title, String author, String year){
        Book newBook = new Book(title,author,year);
        library.add(newBook);
    }

    /**
     * Get all books from the library
     */
    public void listBooks(){
        for(Book b:library){
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
            Book thisBook = library.get(idx);
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
            String userOption = helper.getUserInput("Select a book (id): ");
            Book checkedBook = checkoutBook(Integer.parseInt(userOption));
            return checkedBook;
        }
        catch(Exception e){
            System.out.println("That book is not available.");
            return null;
        }
    }

    /**
     * Get user input to return a book
     */
    public Book returnBook(){
        try {
            String userOption = helper.getUserInput("Input a book (id): ");
            Book returnedBook = returnBookProcess(Integer.parseInt(userOption));
            return returnedBook;
        }
        catch(Exception e){
            System.out.println("That is not a valid book to return.");
            return null;
        }
    }

    /**
     * Perform operation to check out a book from the library
     * @param idx
     */
    public Book checkoutBook(int idx) throws IndexOutOfBoundsException{
        Book thisBook = library.get(idx);
        thisBook.setUnavailable();
        System.out.println("Thank you! Enjoy the book");
        return thisBook;
    }

    /**
     * Performs the returning a book process
     * @param bookId
     */
    public Book returnBookProcess(int bookId) throws IndexOutOfBoundsException{
        Book thisBook = library.get(bookId);
        thisBook.setAvailable();
        System.out.println("Thank you for returning the book.");
        return thisBook;
    }

    /**
     * Get the size of available library
     */
    public int sizeAvailable(){
        int size = 0;
        for(Book b:library){
            if(b.getStatus().equals("Available")){
                size+=1;
            }
        }
        return size;
    }
}
