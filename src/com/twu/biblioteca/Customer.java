package com.twu.biblioteca;

/**
 * Created by jessieleung on 31/12/14.
 */
public class Customer extends User {

    private String name;
    private String contactNumber;
    private String email;

    public Customer(String name, String email, String contactNumber, String libraryNumber, String password){
        super(libraryNumber,password);
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public String getEmail(){
        return email;
    }

}
