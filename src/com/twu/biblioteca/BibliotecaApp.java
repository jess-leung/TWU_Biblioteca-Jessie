package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    ArrayList<Book> library = new ArrayList<Book>();

    /**
     * Method to set welcome message
     */
    public String welcomeUser(){
        return "Welcome to Biblioteca";
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

    /**
     * Check out a book from the library
     * @param idx
     */
    public Book checkout(int idx){
        try{
            Book thisBook = library.get(idx);
            thisBook.setUnavailable();
            return thisBook;
        }
        catch(IndexOutOfBoundsException ex){
            return null;
        }
    }

    /**
     * Get the size of the library
     * @return size
     */
    public int size(){
        return library.size();
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

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp();
        System.out.println(library.welcomeUser());
    }


}
