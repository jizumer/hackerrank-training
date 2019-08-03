package com.jizumer.plusminus;

import com.jizumer.Runner;

import java.util.Arrays;
import java.util.Scanner;

public class PlusMinusRunner implements Runner {
    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {

        Double size = new Double(arr.length);
        Double positive = new Double(Arrays.stream(arr).filter(value -> {
            return (value > 0);
        }).count());
        Double negative = new Double(Arrays.stream(arr).filter(value -> {
            return (value < 0);
        }).count());
        Double zero = new Double(Arrays.stream(arr).filter(value -> {
            return (value == 0);
        }).count());


        System.out.println(positive / size);
        System.out.println(negative / size);
        System.out.println(zero / size);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public void run(String[] args) {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(String.format("N = %s", n));

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
            System.out.println(String.format("arr[%s] = %s", i, arrItem));
        }

        plusMinus(arr);

        scanner.close();
    }
}



