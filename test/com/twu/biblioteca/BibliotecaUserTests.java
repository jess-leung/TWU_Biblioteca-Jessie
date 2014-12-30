package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessieleung on 31/12/14.
 */
public class BibliotecaUserTests {

    BibliotecaApp app;
    UsersList users;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public void setUp(){
        app = new BibliotecaApp();
        users = app.getUsers();
        users.add("Harry Potter","hp@hogwarts.com","94123456","Customer","123-4567","Scarhead");
        users.add("Voldemort","thedarklord@evilempire.com","Customer","93413233","666-0000","EvilnessIsAwesome");
        users.add("Gandalf","thegrey@lotr.com","93231233","Customer","0123-4123","YouShallNotPass");
        users.add("Katniss","katniss@hungergames.com","Librarian","94567823","369-1357","District12");
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
        User chosenUser = users.get(1);
        assertEquals("Voldemort",chosenUser.getName());
        assertEquals("thedarklord@evilempire.com",chosenUser.getEmail());
        assertEquals("Customer",chosenUser.getType());
        assertEquals("93413233",chosenUser.getContactNumber());
        assertEquals("666-0000",chosenUser.getLibraryNumber());
        assertEquals("EvilnessIsAwesome",chosenUser.getPassword());
    }

    @Test
    public void shouldDisplayMessageOnSuccessfulLogin(){

    }

    @Test
    public void shouldDisplayMessageOnUnsuccessfulLoginWrongPassword(){

    }

    @Test
    public void shouldDisplayMessageOnUnsuccessfulLoginUserDoesNotExist(){

    }

    @Test
    public void shouldDisplayCustomerOnBookListOnlyForLibraries(){

    }

    @Test
    public void shouldDisplayCustomerDetailsWhenLoggedIn(){

    }

}
