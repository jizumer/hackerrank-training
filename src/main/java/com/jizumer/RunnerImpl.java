package com.jizumer;

import com.jizumer.samsubstrings.SamSubstringsRunner;

import java.io.IOException;

public class RunnerImpl {
    public static void main(String[] args) throws IOException {

        //This is the only method that should change to execute different exercises
        new SamSubstringsRunner().run(args);

    }

}