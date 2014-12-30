package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessieleung on 30/12/14.
 */
public class BibliotecaAppTests {

    BibliotecaApp app;
    BookCollection library;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public void setUp(){
        app = new BibliotecaApp();
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
    public void shouldDisplayWelcomeMessageOnStartUp(){
        app.welcomeUser();
        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void shouldDisplayCorrectMenuOptions(){
        app.displayMenuOptions();
        assertEquals(
                "------BIBLIOTECA MENU-------\n"+
                "-----------Books------------\n"+
                "1. List Books\n2. Checkout Book\n3. Return Book\n"+
                "-----------Movies-----------\n"+
                "4. List Movies\n"+
                "----------------------------\n"+
                "Q. Quit\n"+
                "----------------------------\n",outContent.toString());
    }

    @Test
    public void shouldDisplayMessageOnInvalidMenuOption(){
        app.selectOption("123");
        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldDisplayMessageOnQuit(){
        app.selectOption("Q");
        assertEquals("Quitting Biblioteca",outContent.toString());
    }
}
