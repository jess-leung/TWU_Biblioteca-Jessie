package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessieleung on 30/12/14.
 */
public class BibliotecaMovieTests {

    BibliotecaApp app;
    BookCollect moviesLibrary;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    public void setUp(){
        app = new BibliotecaApp();
        moviesLibrary = app.getMovieCollection();
        moviesLibrary.addMovie("Harry Potter and the Philosopher's Stone", "Chris Columbus", "2001","8");
        moviesLibrary.addMovie("World War Z", "Marc Forster", "2013","9");
        moviesLibrary.addMovie("The Hours","Stephen Daldry","2002","10");
        moviesLibrary.addMovie("Godzilla","Gareth Edwards","2014","6");
        moviesLibrary.addMovie("Zombieland","Ruben Fleischer","2009","10");
        moviesLibrary.addMovie("Looper","Rian Johnson","2012","Unrated");
        moviesLibrary.addMovie("How to Lose a Guy in 10 Days","Donald Petrie","2003","5");
        moviesLibrary.addMovie("Spirited AWay","Hayao Miyazaki","2001","9");
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
        Movie chosenMovie = movieLibrary.get(1);
        assertEquals("World War Z",chosenMovie.getTitle());
        assertEquals("Marc Forster",chosenMovie.getDirector());
        assertEquals("2013",chosenMovie.getYear());
        assertEquals("Available",chosenMovie.getStatus());
        assertEquals("8",chosenMovie.getRating());
    }

    @Test
    public void shouldListMoviesOnSelectOfListMovies(){

    }

    @Test
    public void shouldHaveCorrectMovieDetailsOnCheckout(){

    }

    @Test
    public void shouldHaveCorrectMovieDetailsOnMulitpleCheckouts(){

    }

    @Test
    public void shouldDisplayMessageOnNonExistingMovieCheckout(){

    }

    @Test
    public void shouldDisplayMessageOnUnavailableMovieCheckout(){

    }


}
