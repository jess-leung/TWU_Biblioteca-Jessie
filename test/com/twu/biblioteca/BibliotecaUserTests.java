package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        users.add(new Customer("Harry Potter","hp@hogwarts.com","94123456","123-4567","Scarhead"));
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
        Boolean result = app.requestLogin("666-0000","EvilnessIsAwesome");
        assertTrue(result);
        assertEquals("You are now logged in.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayMessageOnUnsuccessfulLoginWrongPassword(){
        Boolean result = app.requestLogin("666-0000","EvilnessIsNotAwesome");
        assertFalse(result);
        assertEquals("Unsuccessful login.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayMessageOnUnsuccessfulLoginUserDoesNotExist(){
        Boolean result = app.requestLogin("666-1234","NotEvenAUser");
        assertFalse(result);
        assertEquals("Unsuccessful login.\n", outContent.toString());
    }

    @Test
    public void shouldHaveCustomerAssociatedWithBookTheyHaveCheckedOut(){
        app.setCurrentUser("Harry Potter");
        Book thisBook = (Book) library.checkoutItem(1);
        assertEquals("Harry Potter",thisBook.getCurrentBorrower());
    }

    @Test
    public void shouldDisplayCustomerOnBookListOnlyForLibrarians(){

    }

    @Test
    public void shouldDisplayCustomerDetailsWhenLoggedIn(){

    }

}
