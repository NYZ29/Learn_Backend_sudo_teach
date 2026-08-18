import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


class Practice {
    static void rotateMatrix90DegreesClockwise(int @NotNull [][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                rotated[col][n - 1 - row] = matrix[row][col];
            }
        }
        System.out.println("Исходная: " + Arrays.deepToString(matrix));
        System.out.println("Повёрнутая: " + Arrays.deepToString(rotated));
    }

    static void findSumOnDiags(int @NotNull [][] matrix) {
        int mainDiagSum = 0;
        int antiDiagSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            mainDiagSum += matrix[i][i];
            antiDiagSum += matrix[i][matrix.length - 1 - i];
        }

        System.out.println("Главная диагональ: " + mainDiagSum);
        System.out.println("Побочная диагональ: " + antiDiagSum);
    }

    static void findCountOfOccurrences(int @NotNull [][] matrix, int target) {
        int count = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val == target) {
                    count++;
                }
            }
        }

        System.out.println("Число " + target + " встречается " + count + " раз");
    }

    static void createIdentityMatrix(int n) {
        int[][] identity = new int[n][n];

        for (int i = 0; i < n; i++) {
            identity[i][i] = 1;
        }

        System.out.println(Arrays.deepToString(identity));
    }

    static void findWithMaxSum(int @NotNull [][] matrix) {
        int maxSum = 0;
        int maxRowIndex = 0;

        for (int row = 0; row < matrix.length; row++) {
            int sum = 0;
            for (int val : matrix[row]) {
                sum += val;
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxRowIndex = row;
            }
        }

        System.out.println("Строка с индексом " + maxRowIndex + " имеет наибольшую сумму: " + maxSum);
    }

    static void dimension3D(int @NotNull [][][] figure) {
        int length = figure.length;
        int width = figure[0].length;
        int height = figure[0][0].length;

        if (length > 0 && width > 0 && height > 0) {
            figure[0][0][0] = 1;
            if (length > 1 && width > 2 && height > 3) {
                figure[1][2][3] = 42;
                if (length > 2 && width > 3 && height > 4) {
                    figure[2][3][4] = 100;
                }
            }
        }

        System.out.println("Длина, ширина и высота соответственно: " + length + ", " + width + ", " + height);
        System.out.println(Arrays.deepToString(figure));
    }

    static void matrixMultiplication(int @NotNull [][] matrix1, int @NotNull [][] matrix2) {
        
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Practice.rotateMatrix90DegreesClockwise(matrix);
        System.out.println();

        Practice.findSumOnDiags(matrix);
        System.out.println();

        int[][] matrix1 = {
                {1, 2, 3, 2},
                {4, 2, 6, 2},
                {7, 8, 2, 10}
        };
        int target = 2;
        Practice.findCountOfOccurrences(matrix1, target);
        System.out.println();

        int n = 5;
        Practice.createIdentityMatrix(n);
        System.out.println();

        int[][] table = {
                {10, 20, 30},
                {50, 5, 10},
                {25, 25, 25}
        };
        Practice.findWithMaxSum(table);
        System.out.println();

        int[][][] parallelepiped = new int[3][4][5];
        Practice.dimension3D(parallelepiped);
    }
}