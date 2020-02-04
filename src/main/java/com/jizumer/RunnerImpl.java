package com.jizumer;

import com.jizumer.journeytomoon.JourneyToMoonRunner;

import java.io.IOException;

public class RunnerImpl {
    public static void main(String[] args) throws IOException {

        //This is the only method that should change to execute different exercises
        new JourneyToMoonRunner().run(args);

    }

}