package com.jizumer;

import com.jizumer.diagonaldifference.DiagonalDifferenceRunner;
import com.jizumer.diagonaldifference.Result;
import com.jizumer.plusminus.PlusMinusRunner;
import com.jizumer.sockmerchant.SockMerchantRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RunnerImpl {
    public static void main(String[] args) throws IOException {

        //This is the only method that should change to execute different exercises
        new SockMerchantRunner().run(args);

    }

}
