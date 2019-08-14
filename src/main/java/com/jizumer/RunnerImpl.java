package com.jizumer;

import java.io.IOException;

import com.jizumer.rotatematrix.RotateMatrixRunner;
import com.jizumer.stringpermutation.StringPermutationRunner;

public class RunnerImpl {
    public static void main(String[] args) throws IOException {

        //This is the only method that should change to execute different exercises
        new StringPermutationRunner().run(args);

    }

}