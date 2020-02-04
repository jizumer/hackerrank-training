package com.jizumer.journeytomoon;

import com.jizumer.Runner;

import java.io.IOException;
import java.util.Scanner;

public class JourneyToMoonRunner implements Runner {
    private static final Scanner scanner = new Scanner(System.in);

    private static boolean[][] groupByCountry(int[][] astronaut, int numberOfAstronauts) {
        boolean[][] nationalities = new boolean[numberOfAstronauts][numberOfAstronauts];
        int couplesReceived = astronaut.length;
        for (int i = 0; i < couplesReceived; i++) {
            nationalities[astronaut[i][0]][astronaut[i][1]] = true;
            nationalities[astronaut[i][1]][astronaut[i][0]] = true;
        }
        printMatrix(nationalities);
        return nationalities;
    }

    private static int numberOfPossibleCouples(boolean[][] astronautsPerCountry, int numberOfAstronauts) {
        int couples = 0;
        for (int i = 0; i < numberOfAstronauts; i++) {
            for (int j = i + 1; j < numberOfAstronauts; j++) {
                if (!astronautsPerCountry[i][j]) {
                    couples++;
                } else {
                    for (int k = numberOfAstronauts - 1; k >= 0; k--) {
                        if (astronautsPerCountry[i][k] && k != j) {
                            astronautsPerCountry[k][j] = true;
                            astronautsPerCountry[j][k] = true;
                            couples--;
                        }
                    }
                }
            }
        }
        return couples;
    }

    public static void printMatrix(boolean[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {         //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) {   //this equals to the column in each row.
                System.out.print(((matrix[i][j]) ? "1" : "0") + "\t");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }

    // Complete the journeyToMoon function below.
    int journeyToMoon(int n, int[][] astronaut) {
        boolean[][] astronautsPerCountry = groupByCountry(astronaut, n);
        int couples = numberOfPossibleCouples(astronautsPerCountry, n);
        System.out.println(couples);
        printMatrix(astronautsPerCountry);
        return couples;
    }

    @Override
    public void run(String[] args) throws IOException {


        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        int result = journeyToMoon(n, astronaut);


        scanner.close();
    }


}
