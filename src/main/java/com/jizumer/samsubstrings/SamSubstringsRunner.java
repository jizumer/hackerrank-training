package com.jizumer.samsubstrings;

import com.jizumer.Runner;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sam-and-substrings/
 *
 * An initially failed input was 972698438521. Expected result = 445677619
 *
 */
public class SamSubstringsRunner implements Runner {
    private static final int modulo = 1000000007;
    private static final Scanner scanner = new Scanner(System.in);


    @Override
    public void run(String[] args) throws IOException {
        String n = scanner.nextLine();
        int result = substrings(n);
        scanner.close();

        System.out.println("Result is = " + result);
    }

    // Complete the substrings function below.
    static int substrings(String n) {

        BigInteger result = new BigInteger("0");
        BigInteger mod = new BigInteger("1000000007");

        for (int i = 1; i <= n.length(); i++) {
            for (int j = 0; j <= n.length() - i; j++) {
                BigInteger delta = new BigInteger(n.substring(j, j + i));
                result = result.add(delta).mod(mod);
            }
        }
        return result.intValue();

    }
}
