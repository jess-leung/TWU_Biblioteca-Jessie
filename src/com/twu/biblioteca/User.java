package com.twu.biblioteca;

/**
 * Created by jessieleung on 31/12/14.
 */
public class User {

    private String libraryNumber;
    private String password;

    public User(String library, String password){
        this.libraryNumber = library;
        this.password = password;
    }


    public String getLibraryNumber(){
        return libraryNumber;
    }

    public String getPassword(){
        return password;
    }

}
