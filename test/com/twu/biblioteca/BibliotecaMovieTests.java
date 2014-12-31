package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessieleung on 30/12/14.
 */
public class BibliotecaMovieTests {

    BibliotecaApp app;
    MovieCollection moviesLibrary;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public void setUp(){
        app = new BibliotecaApp();
        moviesLibrary = app.getMovieCollection();
        moviesLibrary.add("Harry Potter and the Philosopher's Stone", "Chris Columbus", "2001", "8");
        moviesLibrary.add("World War Z", "Marc Forster", "2013", "9");
        moviesLibrary.add("Godzilla", "Gareth Edwards", "2014", "Unrated");
        moviesLibrary.add("Zombieland", "Ruben Fleischer", "2009", "10");
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
    public void shouldRetrieveCorrectMovieWhenGettingIt(){
        Movie chosenMovie = moviesLibrary.get(1);
        assertEquals("World War Z",chosenMovie.getTitle());
        assertEquals("Marc Forster",chosenMovie.getDirector());
        assertEquals("2013",chosenMovie.getYear());
        assertEquals("Available",chosenMovie.getStatus());
        assertEquals("9",chosenMovie.getRating());
    }

    @Test
    public void shouldListMoviesOnSelectOfListMovies(){
        app.selectOption("4");
        assertEquals(
                "   0 Harry Potter and the Philosopher's Stone           Chris Columbus" +
                        "                                     2001 8      \n" +
                        "   1 World War Z                                        Marc Forster" +
                        "                                       2013 9      \n" +
                        "   2 Godzilla                                           Gareth Edwards" +
                        "                                     2014 Unrated\n" +
                        "   3 Zombieland                                         Ruben Fleischer" +
                        "                                    2009 10     \n", outContent.toString());
    }

    @Test
    public void shouldHaveCorrectMovieDetailsOnCheckout(){
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Movie checkoutMovie = moviesLibrary.checkout("None");
        assertEquals(new Movie("World War Z","Marc Forster","2013","9"),checkoutMovie);
        assertEquals("Unavailable",checkoutMovie.getStatus());
        assertEquals(3,moviesLibrary.sizeAvailable());
        assertEquals("Input a movie (id):  Thank you! Enjoy the movie\n",outContent.toString());
    }

    @Test
    public void shouldHaveCorrectMovieDetailsOnMulitpleCheckouts(){
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        moviesLibrary.checkout("None");
        assertEquals(3,moviesLibrary.sizeAvailable());
        assertEquals("Available",moviesLibrary.get(0).getStatus());
        assertEquals("Unavailable",moviesLibrary.get(1).getStatus());
        assertEquals("Available",moviesLibrary.get(2).getStatus());
        data = "2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        moviesLibrary.checkout("None");
        assertEquals(2,moviesLibrary.sizeAvailable());
        assertEquals("Available",moviesLibrary.get(0).getStatus());
        assertEquals("Unavailable",moviesLibrary.get(1).getStatus());
        assertEquals("Unavailable",moviesLibrary.get(2).getStatus());
    }

    @Test
    public void shouldDisplayMessageOnNonExistingMovieCheckout(){
        String data = "123";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        moviesLibrary.checkout("None");
        assertEquals("Input a movie (id):  That movie is not available.\n",outContent.toString());
    }

    @Test
    public void shouldDisplayMessageOnUnavailableMovieCheckout(){
        // Simulate checked out book
        moviesLibrary.get(1).setUnavailable();
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        moviesLibrary.checkout("None");
        assertEquals("Input a movie (id):  That movie is not available.\n",outContent.toString());
        assertEquals(3,moviesLibrary.sizeAvailable());
    }


}
