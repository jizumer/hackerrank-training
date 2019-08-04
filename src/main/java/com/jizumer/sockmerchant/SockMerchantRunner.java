package com.jizumer.sockmerchant;

import com.jizumer.Runner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/sock-merchant
 */
public class SockMerchantRunner implements Runner {


    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        return Arrays.stream(ar).boxed().collect(Collectors.groupingBy(Integer::intValue)).entrySet().stream().map(integerListEntry -> {
            return Math.floor(integerListEntry.getValue().size() / 2);
        }).collect(Collectors.summingInt(Double::intValue));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public void run(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }


}
