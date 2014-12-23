package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    ArrayList<Book> library = new ArrayList<Book>();

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
    public ArrayList<Book> getListing(){
        return library;
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

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp();
    }


}
