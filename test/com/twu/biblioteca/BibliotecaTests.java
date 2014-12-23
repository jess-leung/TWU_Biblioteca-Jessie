package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

public class BibliotecaTests {

    BibliotecaApp library;

    public void setUp(){
        library = new BibliotecaApp();
        library.addBook("Harry Potter and the Philosopher's Stone","JK Rowling","1997");
        library.addBook("World War Z","Max Brooks","2006");
        library.addBook("Artificial Intelligence","Peter Norvig and Stuart J. Russell","1994");
    }

    @Test
    public void testWelcomeMessage(){
        setUp();
        String welcomeMessage = library.welcomeUser();
        assertEquals("Welcome to Biblioteca",welcomeMessage);
    }

    @Test
    public void testListBooks(){
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
    public void testInvalidMenuOption(){

    }

    @Test
    public void testCheckoutBook(){
        setUp();
        Book checkoutBook = library.checkout(1);
        assertEquals(new Book("World War Z","Max Brooks","2006"),checkoutBook);
        assertEquals("Unavailable",checkoutBook.getStatus());
        assertEquals(2,library.sizeAvailable());
    }

    @Test
    public void testUnsuccessfulCheckout(){

    }

    @Test
    public void testReturnBook(){

    }

    @Test
    public void testUnsuccessfulReturn(){

    }
}
