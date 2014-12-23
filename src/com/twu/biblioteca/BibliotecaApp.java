package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    private BookCollection bookCollection;
    private IOHelper helper;

    public BibliotecaApp(){
        bookCollection = new BookCollection();
        helper = new IOHelper();
    }

    /**
     * Method to set up static library (adding and deleting books not supported)
     */
    public void setUp(){
        bookCollection.addBook("Harry Potter and the Philosopher's Stone", "JK Rowling", "1997");
        bookCollection.addBook("World War Z", "Max Brooks", "2006");
        bookCollection.addBook("Artificial Intelligence", "Peter Norvig and Stuart J. Russell", "1994");
    }

    /**
     * Method to set welcome message
     */
    public void welcomeUser(){
        System.out.println("Welcome to Biblioteca");
    }

    /**
     * Display menu options
     */
    public void displayMenuOptions(){
        System.out.println("1. List Books");
        System.out.println("2. Checkout Book");
        System.out.println("3. Return Book");
        System.out.println("Q. Quit");
    }

    /**
     * Get user input for menu option
     */
    public void chooseOption(){
        String userOption="0";
        while(!userOption.equals("Q")) {
            displayMenuOptions();
            try {
                userOption = helper.getUserInput("Select an option: ");
                selectOption(userOption);
            } catch (Exception ex){
                System.out.println("Select a valid option!");
            }
        }
    }

    /**
     * Choose a menu option
     */
    public void selectOption(String opt) {
        if (opt.equals("1")) {
            bookCollection.listBooks();
        } else if(opt.equals("2")){
            bookCollection.checkout();
        } else if(opt.equals("3")){
            bookCollection.returnBook();
        } else if(opt.equals("Q")){
            System.out.print("Quitting Biblioteca");
            return;
        } else {
            System.out.println("Select a valid option!");
        }
    }

    /**
     * Get book collection
     */
    public BookCollection getBookCollection(){
        return bookCollection;
    }

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp();
        library.setUp();
        library.welcomeUser();
        library.chooseOption();
    }


}
