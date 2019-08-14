package com.jizumer.rotatematrix;

import java.io.IOException;
import java.util.Scanner;

import com.jizumer.Runner;

public class RotateMatrixRunner implements Runner {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String[] args) throws IOException {
        int len = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(String.format("len = %s", len));

        int[][] matrix = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = scanner.nextInt();
                System.out.println(String.format("arr[%s][%s] = %s", i, j, matrix[i][j]));
            }
        }
        System.out.println("Initial matrix");
        printMatrix(matrix);

        int[][] rotatedMatrix = rotateMatrix(matrix, len);
        System.out.println("Rotated matrix");
        printMatrix(rotatedMatrix);

        scanner.close();
    }

    private int[][] rotateMatrix(int[][] matrix, int len) {

        int[][] rotatedMatrix = new int[len][len];
        int col = len;
        for (int i = 0; i < matrix.length; i++) {
            col--;
            for (int j = 0; j < matrix[i].length; j++) {
                rotatedMatrix[j][col] = matrix[i][j];
            }
        }

        return rotatedMatrix;

    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(String.format(" %s ", matrix[i][j]));
            }
            System.out.println(" |");
        }
    }

}
