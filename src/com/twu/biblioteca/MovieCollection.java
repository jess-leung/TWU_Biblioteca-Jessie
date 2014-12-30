package com.twu.biblioteca;

import java.util.ArrayList;
import java.io.IOException;

/**
 * Created by jessieleung on 30/12/14.
 */
public class MovieCollection extends MediaCollection {

    private static final String INPUT_MOVIE_ID = "Input a book (id): ";

    public MovieCollection(){
        super();
    }

    /**
     * Method to add a movie to library
     */
    public void add(String title, String director, String year, String rating){
        Movie newMovie = new Movie(title,director,year,rating);
        library.add(newMovie);
    }

    /**
     * Method to get a move from library
     */
    public Movie get(int idx){
        try{
            Movie thisMovie = (Movie) library.get(idx);
            return thisMovie;
        }
        catch(IndexOutOfBoundsException ex){
            return null;
        }
    }

    /**
     * Get all movies from the movie library
     */
    public void list(){
        for(MediaItem item:library) {
            Movie m = (Movie) item;
            if (m.getStatus().equals("Available")) {
                System.out.format("%4d %-50s %-50s %-4s %-7s%n", library.indexOf(m), m.getTitle(), m.getDirector(),
                        m.getYear(), m.getRating());
            }
        }
    }

    public Movie checkout(){
        return null;
    }

    public Movie returnItem(){
        return null;
    }

    public void displayNotAvailableMessage(){
        System.out.println("Not Available");
    }


    /**
     * Display not valid movie to return message
     */
    public void displayNotValidItemToReturnMessage(){
        System.out.println("Invalid movie to return");
    }

    /**
     * Display movie-specific thank you for checkout message
     */
    public void displayThankYouEnjoyMessage(){
        System.out.println("Thank you enjoy the movie");
    }

    /**
     * Display movie-specific thank you for returning message
     */
    public void displayThankYouReturnMessage(){
        System.out.println("Thank you for returning movie");
    }

    /**
     * Get user selection for menu
     */
    public String getUserOption() throws IOException{
        return helper.getUserInput(INPUT_MOVIE_ID);
    }

}
