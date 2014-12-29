package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jessieleung on 30/12/14.
 */
public class MovieCollection extends MediaCollection {

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

    public void list(){

    }
}
