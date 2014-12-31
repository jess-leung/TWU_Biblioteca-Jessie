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

    @Override
    public boolean equals(Object o){
        if(o instanceof User){
            User u = (User) o;
            if(u.getLibraryNumber().equals(libraryNumber) && u.getPassword().equals(password)){
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
}
