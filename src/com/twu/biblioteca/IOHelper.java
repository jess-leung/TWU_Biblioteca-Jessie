package com.twu.biblioteca;

import java.io.*;

/**
 * Created by jessieleung on 23/12/14.
 */
public class IOHelper {

    public String getUserInput(String prompt) throws IOException{
        String input = null;
        System.out.print(prompt + " ");
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        input = is.readLine();
        if(input.length()==0) return null;

        return input;
    }
}
