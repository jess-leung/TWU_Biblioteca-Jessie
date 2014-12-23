package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    private ArrayList<Book> library = new ArrayList<Book>();
    public IOHelper helper = new IOHelper();

    /**
     * Method to set welcome message
     */
    public void welcomeUser(){
        System.out.print("Welcome to Biblioteca");
    }

    /**
     * Method to create menu and get user input
     */
    public void menu(){
        displayMenuOptions();
        chooseOption();
    }
    /**
     * Display menu options
     */
    public void displayMenuOptions(){
        System.out.print("1. List Books");
    }

    /**
     * Get user input for menu option
     */
    public void chooseOption(){
        int userOption = helper.getUserInput("Select an option: ");
        selectOption(userOption);
    }

    /**
     * Choose a menu option
     */
    public void selectOption(int opt){
        switch(opt){
            default: System.out.print("Select a valid option!");
        }
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
     * Perform operation to check out a book from the library
     * @param idx
     */
    public Book checkoutBook(int idx){
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
        library.welcomeUser();
        library.displayMenuOptions();
    }


}
