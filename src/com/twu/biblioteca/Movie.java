package com.twu.biblioteca;

/**
 * Created by jessieleung on 30/12/14.
 */
public class Movie {
    private String title;
    private String director;
    private String year;
    private String status;
    private String rating;

    public Movie(String movieTitle, String movieDirector, String movieYear, String movieRating){
        title = movieTitle;
        director = movieDirector;
        year = movieYear;
        rating = movieRating;
        status = "Available";
    }

    public void setUnavailable(){
        status = "Unavailable";
    }

    public void setAvailable(){
        status = "Available";
    }

    public String getTitle(){
        return title;
    }

    public String getDirector(){
        return director;
    }

    public String getYear(){
        return year;
    }

    public String getRating(){
        return rating;
    }

    public String getStatus(){
        return status;
    }
}
