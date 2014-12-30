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

    @Override
    public boolean equals(Object o){
        if(o instanceof Movie){
            Movie m = (Movie) o;
            if(m.getTitle().equals(title) && m.getDirector().equals(director) &&
                    m.getYear().equals(year) && m.getRating().equals(rating)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public String getDirector(){
        return director;
    }

    public String getRating(){
        return rating;
    }

}
