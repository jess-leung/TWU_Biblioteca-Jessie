package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTests {

    Library library;

    public void setUp(){
        library = new Library();
        library.addBook("Harry Potter and the Philosopher's Stone","JK Rowling","1997");
        library.addBook("World War Z","Max Brooks","2006");
        library.addBook("Artificial Intelligence","Peter Norvig and Stuart J. Russell","1994");
    }

    @Test
    public void testListBooks(){

    }

    @Test
    public void testBookDetails(){
        setUp();
        Book chosenBook = Library.getBook(1);
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
