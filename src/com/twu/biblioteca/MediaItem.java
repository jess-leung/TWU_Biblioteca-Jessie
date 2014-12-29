package com.twu.biblioteca;

/**
 * Created by jessieleung on 30/12/14.
 */
public abstract class MediaItem {

    protected String title;
    protected String year;
    protected String status;

    public MediaItem(String itemTitle, String itemYear){
        title = itemTitle;
        year = itemYear;
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

    public String getYear(){
        return year;
    }

    public String getStatus(){
        return status;
    }

}
