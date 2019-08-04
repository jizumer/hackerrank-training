package com.jizumer.staircase;

import com.jizumer.Runner;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/staircase
 */
public class StaircaseRunner implements Runner {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }

    static void staircase(int n) {

        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, n).forEach(i -> {
            for (int j = 1; j < (n - i); j++) {
                stringBuilder.append(' ');
            }
            for (int k = 0; k <= i; k++) {
                stringBuilder.append('#');
            }
            if (i >= 0 && i < n) {
                stringBuilder.append('\n');
            }
        });
        System.out.print(stringBuilder.toString());
    }
}
