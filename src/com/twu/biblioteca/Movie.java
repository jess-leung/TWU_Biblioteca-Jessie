package com.twu.biblioteca;

/**
 * Created by jessieleung on 30/12/14.
 */
public class Movie extends MediaItem {

    private String director;
    private String rating;

    public Movie(String movieTitle, String movieDirector, String movieYear, String movieRating){
        super(movieTitle,movieYear);
        director = movieDirector;
        rating = movieRating;
    }

    public String getDirector(){
        return director;
    }

    public String getRating(){
        return rating;
    }

}
