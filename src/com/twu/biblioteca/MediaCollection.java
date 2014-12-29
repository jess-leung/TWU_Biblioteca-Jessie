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


}
