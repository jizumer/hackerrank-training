package com.jizumer.diagonaldifference;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference
 */
public class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int size = arr.size();
        int d1 = 0, d2 = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    d1 += arr.get(i).get(j);
                    System.out.println(String.format("Adding %s to d1", arr.get(i).get(j)));
                }

                if ((i + j + 1) == size) {
                    d2 += arr.get(i).get(j);
                    System.out.println(String.format("Adding %s to d2", arr.get(i).get(j)));
                }
            }

        }
        return Math.abs(d1 - d2);
    }

}

