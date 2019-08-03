package com.jizumer;

import com.jizumer.huffmandecoder.HuffmanDecoderRunner;
import com.jizumer.staircase.StaircaseRunner;

import java.io.IOException;

public class RunnerImpl {
    public static void main(String[] args) throws IOException {

        //This is the only method that should change to execute different exercises
        new StaircaseRunner().run(args);

    }

}