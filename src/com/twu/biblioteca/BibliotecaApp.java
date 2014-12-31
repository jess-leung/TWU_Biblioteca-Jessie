package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    private BookCollection bookCollection;
    private MovieCollection movieCollection;
    private UsersList users;
    private IOHelper helper;
    private User currentUser;
    private static final String SELECT_VALID_OPTION = "Select a valid option!";
    private static final String SELECT_AN_OPTION = "Select an option: ";
    private static final String WELCOME = "Welcome to Biblioteca";
    private static final String QUIT_MESSAGE = "Quitting Biblioteca";

    public BibliotecaApp(){
        bookCollection = new BookCollection();
        movieCollection = new MovieCollection();
        users = new UsersList();
        helper = new IOHelper();
        currentUser = null;
    }

    /**
     * Method to set up static library (adding and deleting books not supported)
     * Adding and deleting users also not supported.
     */
    public void setUp(){
        bookCollection.add("Harry Potter and the Philosopher's Stone", "JK Rowling", "1997");
        bookCollection.add("World War Z", "Max Brooks", "2006");
        bookCollection.add("Artificial Intelligence", "Peter Norvig and Stuart J. Russell", "1994");
        movieCollection.add("Harry Potter and the Philosopher's Stone", "Chris Columbus", "2001", "8");
        movieCollection.add("World War Z", "Marc Forster", "2013", "9");
        movieCollection.add("Godzilla", "Gareth Edwards", "2014", "Unrated");
        movieCollection.add("Zombieland", "Ruben Fleischer", "2009", "10");
        users.add(new Customer("Harry Potter","hp@hogwarts.com","94123456","123-4567","Hogwarts"));
        users.add(new Customer("Voldemort","thedarklord@evilempire.com","93413233","666-0000","EvilnessIsAwesome"));
        users.add(new Customer("Gandalf","thegrey@lotr.com","93231233","0123-4123","YouShallNotPass"));
    }

    /**
     * Method to set welcome message
     */
    public void welcomeUser(){
        System.out.println(WELCOME);
    }

    /**
     * Display menu options
     */
    public void displayMenuOptions(){
        System.out.println("------BIBLIOTECA MENU-------");
        System.out.println("-----------Books------------");
        System.out.println("1. List Books");
        System.out.println("2. Checkout Book");
        System.out.println("3. Return Book");
        System.out.println("-----------Movies-----------");
        System.out.println("4. List Movies");
        System.out.println("5. Checkout Movie");
        System.out.println("----------------------------");
        System.out.println("D. Display Customer Details");
        System.out.println("L. User Login");
        System.out.println("Q. Quit");
        System.out.println("----------------------------");
    }

    /**
     * Get user input for menu option
     */
    public void chooseOption(){
        String userOption="0";
        while(!userOption.equals("Q")) {
            displayMenuOptions();
            try {
                userOption = helper.getUserInput(SELECT_AN_OPTION);
                selectOption(userOption);
            } catch (Exception ex){
                System.out.println(SELECT_VALID_OPTION);
            }
        }
    }

    /**
     * Choose a menu option. Assume no user login required for checkout or returning movies (not in requirements).
     */
    public void selectOption(String opt) {
        if (opt.equals("1")) {
            bookCollection.list();
        } else if(opt.equals("2") || opt.equals("3") || opt.equals("D")){
            if(currentUser!=null){
                if(opt.equals("2")){
                    bookCollection.checkout(currentUser.getLibraryNumber());
                }
                if(opt.equals("3")){
                    bookCollection.returnItem();
                }
                if(opt.equals("D")){
                    displayCustomerDetails();
                }
            }
            else{
                System.out.println("You are not logged in.");
            }
        } else if(opt.equals("4")){
            movieCollection.list();
        } else if(opt.equals("5")){
            movieCollection.checkout(currentUser.getLibraryNumber());
        } else if(opt.equals("L")){
            userLogin();
        } else if(opt.equals("Q")){
            System.out.print(QUIT_MESSAGE);
            return;
        } else {
            System.out.println(SELECT_VALID_OPTION);
        }
    }

    public Boolean userLogin(){
        try {
            String thisNumber = helper.getUserInput("Library Number: ");
            String thisPassword = helper.getUserInput("Password: ");
            User u = requestLogin(thisNumber, thisPassword);
            if(u != null){
                currentUser = u;
                return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.println("Unsuccessful login.");
            return false;
        }
    }

    public User requestLogin(String libraryNumber, String password){
        User thisUser = new User(libraryNumber, password);
        if (users.contains(thisUser)){
            System.out.println("You are now logged in.");
            return users.get(users.indexOf(thisUser));
        }
        System.out.println("Unsuccessful login.");
        return null;
    }

    public void displayCustomerDetails(){
        if(currentUser instanceof Customer){
            Customer thisCustomer = (Customer) currentUser;
            System.out.println("Customer Details: "+thisCustomer.getName()+", "+thisCustomer.getEmail()+", "+thisCustomer.getContactNumber());
        }
        else{
            System.out.println("You are not a customer.");
        }
    }

    public void setCurrentUser(User u){
        currentUser = u;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    /**
     * Get book collection
     */
    public BookCollection getBookCollection(){
        return bookCollection;
    }

    /**
     * Get movie collection
     */
    public MovieCollection getMovieCollection(){ return movieCollection; }

    /**
     * Get users list
     */
    public UsersList getUsers(){ return users; }

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp();
        library.setUp();
        library.welcomeUser();
        library.chooseOption();
    }
}
