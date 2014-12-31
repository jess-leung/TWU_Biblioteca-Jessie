package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jessieleung on 31/12/14.
 */
public class BibliotecaUserTests {

    BibliotecaApp app;
    BookCollection library;
    UsersList users;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public void setUp(){
        app = new BibliotecaApp();
        users = app.getUsers();
        users.add(new Customer("Harry Potter","hp@hogwarts.com","94123456","123-4567","Hogwarts"));
        users.add(new Customer("Voldemort","thedarklord@evilempire.com","93413233","666-0000","EvilnessIsAwesome"));
        users.add(new Customer("Gandalf","thegrey@lotr.com","93231233","0123-4123","YouShallNotPass"));
        users.add(new Librarian("94567823","369-1357"));
        library = app.getBookCollection();
        library.add("Harry Potter and the Philosopher's Stone", "JK Rowling", "1997");
        library.add("World War Z", "Max Brooks", "2006");
        library.add("Artificial Intelligence", "Peter Norvig and Stuart J. Russell", "1994");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        setUp();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


    @Test
    public void shouldHaveCorrectUserWhenRetrievingUser(){
        Customer chosenUser = (Customer) users.get(1);
        assertEquals("Voldemort",chosenUser.getName());
        assertEquals("thedarklord@evilempire.com",chosenUser.getEmail());
        assertEquals("93413233",chosenUser.getContactNumber());
        assertEquals("666-0000",chosenUser.getLibraryNumber());
        assertEquals("EvilnessIsAwesome",chosenUser.getPassword());
    }

    @Test
    public void shouldDisplayMessageOnSuccessfulLogin(){
        User u = app.requestLogin("666-0000","EvilnessIsAwesome");
        assertEquals(u,users.get(1));
        assertEquals("You are now logged in.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayMessageOnUnsuccessfulLoginWrongPassword(){
        app.requestLogin("666-0000","EvilnessIsNotAwesome");
        assertEquals("Unsuccessful login.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayMessageOnUnsuccessfulLoginUserDoesNotExist(){
        app.requestLogin("666-1234","NotEvenAUser");
        assertEquals("Unsuccessful login.\n", outContent.toString());
    }

    @Test
    public void shouldHaveCustomerAssociatedWithBookTheyHaveCheckedOut(){
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Book thisBook = (Book) library.checkout("123-4567");
        assertEquals("123-4567",thisBook.getCurrentBorrower());
    }

    @Test
    public void shouldNotHaveCustomerAssociatedWithBookTheyHaveReturned(){
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        library.checkout("123-4567");
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Book thisBook = (Book) library.returnItem();
        assertEquals("None",thisBook.getCurrentBorrower());
    }

    @Test
    public void shouldDisplayCustomerDetailsWhenLoggedIn(){
        app.setCurrentUser(users.get(0));
        app.displayCustomerDetails();
        assertEquals("Customer Details: Harry Potter, hp@hogwarts.com, 94123456\n", outContent.toString());
    }

    @Test
    public void shouldNotDisplayCustomerDetailsWhenNotLoggedIn(){
        app.setCurrentUser(null);
        app.selectOption("D");
        assertEquals("You are not logged in.\n", outContent.toString());
    }

}
