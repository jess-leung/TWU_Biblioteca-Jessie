package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jessieleung on 30/12/14.
 */
public abstract class MediaCollection {
    protected ArrayList<MediaItem> library;
    protected IOHelper helper;

    public MediaCollection(){
        library = new ArrayList<MediaItem>();
        helper = new IOHelper();
    }

    /**
     * Method to list media items in library
     */
    public abstract void list();

    /**
     * Method to checkout media item from library
     */
    public abstract MediaItem checkout();

    /**
     * Method to return media item from library
     */
    public abstract MediaItem returnItem();

    /**
     * Get the size of available library
     */
    public int sizeAvailable(){
        int size = 0;
        for(MediaItem item:library){
            if(item.getStatus().equals("Available")){
                size+=1;
            }
        }
        return size;
    }

}
