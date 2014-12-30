package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        users.add("Harry Potter","hp@hogwarts.com","94123456","123-4567","Scarhead");
        users.add("Voldemort","thedarklord@evilempire.com","93413233","666-0000","EvilnessIsAwesome");
        users.add("Gandalf","thegrey@lotr.com","93231233","0123-4123","YouShallNotPass");
        users.add("Katniss","katniss@hungergames.com","94567823","369-1357","District12");
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
    public void shouldHaveCorrectUserDetailsInList(){

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
