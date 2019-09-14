package com.jizumer.candies;

import com.jizumer.Runner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/candies
 */
public class CandiesRunner implements Runner {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int totalCandies = 0;
        Integer[] candiesForEachKid = new Integer[n];
        List<Integer> orderedList = Arrays.stream(arr).sorted().distinct().boxed().collect(Collectors.toList());
        for (Integer nextValue : orderedList) {
            for (int i = 0; i < n; i++) {
                if (nextValue.intValue() == arr[i]) {
                    calculateCandies(i, candiesForEachKid, arr);
                    totalCandies += candiesForEachKid[i];
                }
            }
        }


        return totalCandies;
    }

    static private void calculateCandies(int i, Integer[] candiesForEachKid, int[] arr) {

        candiesForEachKid[i] = 1;
        if (i >= 1 && arr[i - 1] < arr[i] && candiesForEachKid[i - 1] != null) {
            candiesForEachKid[i] = Integer.max(candiesForEachKid[i], candiesForEachKid[i - 1] + 1);
        }

        if (i < arr.length - 1 && arr[i + 1] < arr[i] && candiesForEachKid[i + 1] != null) {
            candiesForEachKid[i] = Integer.max(candiesForEachKid[i], candiesForEachKid[i + 1] + 1);
        }
    }

    @Override
    public void run(String[] args) throws IOException {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        System.out.println("Minimum candies tu buy: " + result);

        scanner.close();

    }
}
