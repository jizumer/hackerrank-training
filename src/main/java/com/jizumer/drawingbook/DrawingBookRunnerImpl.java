package com.jizumer.drawingbook;

import com.jizumer.Runner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/drawing-book
 */
public class DrawingBookRunnerImpl implements Runner {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        return Math.min(fromLeft(n, p), fromRight(n, p));
    }

    private static int fromRight(int n, int p) {
        int result = (n - p ) / 2;
        if( n % 2 == 0 && p % 2 == 1){
            result++;
        }
        return result;

    }

    private static int fromLeft(int n, int p) {
        return p / 2;
    }
}
