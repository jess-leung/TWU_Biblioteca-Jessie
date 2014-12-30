package com.twu.biblioteca;

import java.util.ArrayList;
import java.io.IOException;

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

    /**
     * Check out a book
     * @return
     */
    public MediaItem checkout() throws Exception{
        String userOption = getUserOption();
        MediaItem checkedItem = checkoutItem(Integer.parseInt(userOption));
        return checkedItem;
    }

    /**
     * Get user input to return a book
     */
    public MediaItem returnItem(){
        try {
            String userOption = getUserOption();
            MediaItem returnedItem = returnItemProcess(Integer.parseInt(userOption));
            return returnedItem;
        }
        catch(Exception e){
            displayNotValidItemToReturnMessage();
            return null;
        }
    }

    /**
     * Perform operation to check out a book from the library
     * @param idx
     */
    public MediaItem checkoutItem(int idx) throws IndexOutOfBoundsException{
        MediaItem thisItem = library.get(idx);
        if(thisItem.getStatus().equals("Available")) {
            thisItem.setUnavailable();
            displayThankYouEnjoyMessage();
            return thisItem;
        }
        else{
            displayNotAvailableMessage();
            return null;
        }
    }



    /**
     * Performs the returning an item process
     */
    public MediaItem returnItemProcess(int id) throws IndexOutOfBoundsException{
        MediaItem thisItem = library.get(id);
        if(thisItem.getStatus().equals("Unavailable")) {
            thisItem.setAvailable();
            displayThankYouReturnMessage();
            return thisItem;
        }
        else{
            displayNotValidItemToReturnMessage();
            return null;
        }
    }

    /**
     * Get user input for which menu option selected
     */
    public abstract String getUserOption() throws IOException;

    /**
     * Display thank you for checkout of item message
     */
    public abstract void displayThankYouEnjoyMessage();

    /**
     * Display not available item message
     */
    public abstract void displayNotAvailableMessage();

    /**
     * Display thank you message for return of item
     */
    public abstract void displayThankYouReturnMessage();

    /**
     * DIsplay not valid item to return message
     */
    public abstract void displayNotValidItemToReturnMessage();

}
