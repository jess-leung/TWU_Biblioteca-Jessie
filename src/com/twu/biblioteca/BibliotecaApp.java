package com.twu.biblioteca;

public class BibliotecaApp {


    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp();
    }

    /**
     * Method to add a book to the library
     */
    public void addBook(String title, String author, String year){
        Book newBook = new Book();
        newBook.author = "Max Brooks";
        newBook.year = "2006";
        newBook.title = "World War Z";
    }

    /**
     * Get a book's details from the library
     */
    public Book getBook(int idx){
        Book thisNewBook = new Book();
        return thisNewBook;
    }
}
