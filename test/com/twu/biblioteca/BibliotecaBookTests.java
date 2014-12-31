package com.twu.biblioteca;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;
import java.io.*;

public class BibliotecaBookTests {

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
    public void shouldHaveCorrectDetailsForBooks(){
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
    public void shouldRetrieveCorrectBookWhenGettingIt(){
        Book chosenBook = library.getBook(1);
        assertEquals("World War Z",chosenBook.getTitle());
        assertEquals("Max Brooks",chosenBook.getAuthor());
        assertEquals("2006",chosenBook.getYear());
        assertEquals("Available",chosenBook.getStatus());
    }



    @Test
    public void shouldListAvailableBooksOnSelectOfListBooks(){
        app.selectOption("1");
        assertEquals(
                "   0 Harry Potter and the Philosopher's Stone           JK Rowling" +
                "                                         1997\n" +
                "   1 World War Z                                        Max Brooks" +
                        "                                         2006\n" +
                "   2 Artificial Intelligence                            Peter Norvig and Stuart J. Russell" +
                        "                 1994\n",outContent.toString());
    }

    @Test
    public void shouldHaveCorrectLibraryDetailsAfterCheckout(){
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Book checkoutBook = library.checkout("123-4567");
        assertEquals(new Book("World War Z","Max Brooks","2006"),checkoutBook);
        assertEquals("Unavailable",checkoutBook.getStatus());
        assertEquals(2,library.sizeAvailable());
        assertEquals("Input a book (id):  Thank you! Enjoy the book\n",outContent.toString());
    }

    @Test
    public void shouldHaveCorrectLibraryDetailsAfterMultipleCheckouts(){
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        library.checkout("123-4567");
        assertEquals(2,library.sizeAvailable());
        assertEquals("Available",library.getBook(0).getStatus());
        assertEquals("Unavailable",library.getBook(1).getStatus());
        assertEquals("Available",library.getBook(2).getStatus());
        data = "2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        library.checkout("123-4567");
        assertEquals(1,library.sizeAvailable());
        assertEquals("Available",library.getBook(0).getStatus());
        assertEquals("Unavailable",library.getBook(1).getStatus());
        assertEquals("Unavailable",library.getBook(2).getStatus());
    }

    @Test
    public void shouldDisplayMessageIfRequestedBookForCheckoutDoesNotExist(){
        String data = "123";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        library.checkout("123-4567");
        assertEquals("Input a book (id):  That book is not available.\n",outContent.toString());
    }

    @Test
    public void shouldDisplayMessageIfBookNotAvailableForCheckout(){
        // Simulate checked out book
        library.getBook(1).setUnavailable();
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        library.checkout("123-4567");
        assertEquals("Input a book (id):  That book is not available.\n",outContent.toString());
        assertEquals(2,library.sizeAvailable());
    }

    @Test
    public void shouldHaveCorrectLibraryDetailsAfterReturnBook(){
        // Simulate checked out book
        library.getBook(1).setUnavailable();
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Book returnedBook = library.returnItem();
        assertEquals(new Book("World War Z", "Max Brooks", "2006"), returnedBook);
        assertEquals("Available",returnedBook.getStatus());
        assertEquals(3,library.sizeAvailable());
        assertEquals("Input a book (id):  Thank you for returning the book.\n",outContent.toString());
    }

    @Test
    public void shouldHaveCorrectLibraryDetailsAfterReturnMultipleBooks(){
        // Simulate checked out books
        Book checkBook1 = (Book) library.checkoutItem(1);
        Book checkBook2 = (Book) library.checkoutItem(2);

        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Book returnedBook1 = library.returnItem();
        assertEquals("Available", returnedBook1.getStatus());
        assertEquals("Unavailable",checkBook2.getStatus());
        assertEquals(2,library.sizeAvailable());
        data = "2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Book returnedBook2 = library.returnItem();
        assertEquals("Available", returnedBook1.getStatus());
        assertEquals("Available",returnedBook1.getStatus());
        assertEquals(3,library.sizeAvailable());
    }

    @Test
    public void shouldDisplayMessageOnNonExistingBookReturn(){
        String data = "123";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        library.returnItem();
        assertEquals("Input a book (id):  That is not a valid book to return.\n", outContent.toString());
        assertEquals(3,library.sizeAvailable());
    }

    @Test
    public void shouldDisplayMessageOnInvalidBookReturn(){
        String data = "Not even a number";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        library.returnItem();

        assertEquals("Input a book (id):  That is not a valid book to return.\n", outContent.toString());
        assertEquals(3,library.sizeAvailable());
    }

    @Test
    public void shouldDisplayMessageOnAlreadyAvailableBookReturn(){
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        library.returnItem();

        assertEquals("Input a book (id):  That is not a valid book to return.\n", outContent.toString());
        assertEquals(3,library.sizeAvailable());
    }
}
