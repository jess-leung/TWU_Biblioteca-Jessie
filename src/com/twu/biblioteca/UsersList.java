package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jessieleung on 31/12/14.
 */
public class UsersList {

    ArrayList<User> users;

    public UsersList(){
        users = new ArrayList<User>();
    }

    /**
     * Add a user to users list
     */
    public void add(User u){
        users.add(u);
    }

    /**
     * Retrieve a user from the list of users given index
     */
    public User get(int idx){
        return users.get(idx);
    }
}
