package com.twu.biblioteca;

import java.util.*;
import java.io.*;

public class BibliotecaApp {

    private ArrayList<Book> library = new ArrayList<Book>();
    public IOHelper helper = new IOHelper();

    /**
     * Method to add a book to the library
     */
    public void addBook(String title, String author, String year){
        Book newBook = new Book(title,author,year);
        library.add(newBook);
    }

    /**
     * Method to set up static library (adding and deleting books not supported)
     */
    public void setUp(){
        addBook("Harry Potter and the Philosopher's Stone", "JK Rowling", "1997");
        addBook("World War Z", "Max Brooks", "2006");
        addBook("Artificial Intelligence", "Peter Norvig and Stuart J. Russell", "1994");
    }

    /**
     * Method to set welcome message
     */
    public void welcomeUser(){
        System.out.println("Welcome to Biblioteca");
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
        System.out.println("1. List Books");
        System.out.print("Q. Quit");
    }

    /**
     * Get user input for menu option
     */
    public void chooseOption(){
        String userOption="";
        while(!userOption.equals("Q")) {
            try {
                userOption = helper.getUserInput("Select an option: ");
                selectOption(userOption);
            } catch (IOException ex) {
                System.out.print("Select a valid option!");
            }
        }
    }

    /**
     * Choose a menu option
     */
    public void selectOption(String opt) {
        if (opt.equals("1")) {
            listBooks();
        } else if(opt.equals("Q")){
            System.out.print("Quitting Biblioteca");
            return;
        } else {
            System.out.print("Select a valid option!");
        }
    }

    /**
     * Get all books from the library
     */
    public void listBooks(){
        int count=0;
        for(Book b:library){
            if(b.getStatus().equals("Available")) {
                System.out.format("%4d %-50s %-50s %-4s%n", count, b.getTitle(), b.getAuthor(), b.getYear());
                count+=1;
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
        library.setUp();
        library.welcomeUser();
        library.displayMenuOptions();
        library.chooseOption();
    }


}
