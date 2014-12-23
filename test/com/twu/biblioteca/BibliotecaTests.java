package com.twu.biblioteca;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;
import java.io.*;

public class BibliotecaTests {

    BibliotecaApp library;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public void setUp(){
        library = new BibliotecaApp();
        library.addBook("Harry Potter and the Philosopher's Stone","JK Rowling","1997");
        library.addBook("World War Z","Max Brooks","2006");
        library.addBook("Artificial Intelligence","Peter Norvig and Stuart J. Russell","1994");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testWelcomeMessage(){
        setUp();
        library.welcomeUser();
        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void testBooksInLibrary(){
        setUp();
        ArrayList<Book> correctList = new ArrayList<Book>();
        correctList.add(new Book("Harry Potter and the Philosopher's Stone","JK Rowling","1997"));
        correctList.add(new Book("World War Z","Max Brooks","2006"));
        correctList.add(new Book("Artificial Intelligence","Peter Norvig and Stuart J. Russell","1994"));
        int idx = 0;
        for(Book b:correctList){
            assertEquals(b.getTitle(), library.getBook(idx).getTitle());
            assertEquals(b.getAuthor(), library.getBook(idx).getAuthor());
            assertEquals(b.getYear(), library.getBook(idx).getYear());
            idx+=1;
        }
    }

    @Test
    public void testBookDetails(){
        setUp();
        Book chosenBook = library.getBook(1);
        assertEquals("World War Z",chosenBook.getTitle());
        assertEquals("Max Brooks",chosenBook.getAuthor());
        assertEquals("2006",chosenBook.getYear());
        assertEquals("Available",chosenBook.getStatus());
    }

    @Test
    public void testMenuOptions(){
        setUp();
        library.displayMenuOptions();
        assertEquals("1. List Books\n2. Checkout Book\n3. Return Book\nQ. Quit\n",outContent.toString());
    }

    @Test
    public void testValidMenuOptionListBooks(){
        setUp();
        library.selectOption("1");
        assertEquals(
                "   0 Harry Potter and the Philosopher's Stone           JK Rowling" +
                "                                         1997\n" +
                "   1 World War Z                                        Max Brooks" +
                        "                                         2006\n" +
                "   2 Artificial Intelligence                            Peter Norvig and Stuart J. Russell" +
                        "                 1994\n",outContent.toString());
    }

    @Test
    public void testInvalidMenuOption(){
        setUp();
        library.selectOption("123");
        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void testQuit(){
        setUp();
        library.selectOption("Q");
        assertEquals("Quitting Biblioteca",outContent.toString());
    }

    @Test
    public void testCheckoutBook(){
        setUp();
        Book checkoutBook = library.checkoutBook(1);
        assertEquals(new Book("World War Z","Max Brooks","2006"),checkoutBook);
        assertEquals("Unavailable",checkoutBook.getStatus());
        assertEquals(2,library.sizeAvailable());
        assertEquals("Thank you! Enjoy the book\n",outContent.toString());
    }

    @Test
    public void testUnsuccessfulCheckout(){
        setUp();
        library.checkoutBook(123);
        assertEquals("That book is not available.\n",outContent.toString());
    }

    @Test
    public void testReturnBook(){

    }

    @Test
    public void testUnsuccessfulReturn(){

    }
}
