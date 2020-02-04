package com.jizumer.samsubstrings;

import com.jizumer.Runner;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sam-and-substrings/
 * <p>
 * An initially failed input was 972698438521. Expected result = 445677619
 */
public class SamSubstringsRunner implements Runner {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BigInteger mod = new BigInteger("1000000007");

    @Override
    public void run(String[] args) throws IOException {
        String n = scanner.nextLine();
        int result = substrings(n);
        scanner.close();

        System.out.println("Result is = " + result);
    }

    // Complete the substrings function below.
    static int substrings(String n) {
        int len = n.length();
        if (len == 1) {
            System.out.println(Integer.parseInt(n));
            return Integer.parseInt(n);
        } else {
            //System.out.println();
            return new BigInteger(n.substring(0, 1)).multiply(new BigInteger("10").pow(len - 1)).mod(mod).intValue() + substrings(n.substring(1));
        }


    }
}
