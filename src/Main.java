import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


class Practice {
    /// @param matrix
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

    /// @param matrix
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

    /// @param matrix
    /// @param target
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

    /// @param n
    static void createIdentityMatrix(int n) {
        if (n <= 0) {
            System.out.println("Не существует матрицы с такой размерностью");
            return;
        }
        int[][] identity = new int[n][n];

        for (int i = 0; i < n; i++) {
            identity[i][i] = 1;
        }

        System.out.println(Arrays.deepToString(identity));
    }

    /// @param matrix
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

    /// @param figure
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

    private static void checkRectangular(
            int[][] matrix,
            String matrixName
    ) {
        if (matrix == null) {
            throw new IllegalArgumentException(
                    matrixName + " не должна быть null"
            );
        }

        if (matrix.length == 0) {
            throw new IllegalArgumentException(
                    matrixName + " не должна быть пустой"
            );
        }

        if (matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException(
                    matrixName + " должна иметь хотя бы один столбец"
            );
        }

        int columns = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null || matrix[i].length != columns) {
                throw new IllegalArgumentException(
                        matrixName + " должна быть прямоугольной"
                );
            }
        }
    }

    static int[][] matrixMultiplication(
            int @NotNull [][] matrix1,
            int @NotNull [][] matrix2
    ) {
        checkRectangular(matrix1, "matrix1");
        checkRectangular(matrix2, "matrix2");

        int rowsA = matrix1.length;
        int colsA = matrix1[0].length;
        int rowsB = matrix2.length;
        int colsB = matrix2[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException(
                    "Несовместимые размеры матриц: " +
                            rowsA + "×" + colsA + " и " +
                            rowsB + "×" + colsB
            );
        }

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int k = 0; k < colsA; k++) {
                for (int j = 0; j < colsB; j++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    static void showResultMatrix(
            int @NotNull [][] matrix1,
            int @NotNull [][] matrix2
    ) {
        try {
            int[][] result = matrixMultiplication(matrix1, matrix2);

            System.out.println(
                    "M1 (" + matrix1.length + "×" + matrix1[0].length + "): " + Arrays.deepToString(matrix1)
            );

            System.out.println(
                    "M2 (" + matrix2.length + "×" + matrix2[0].length + "): " + Arrays.deepToString(matrix2)
            );

            System.out.println(
                    "M1×M2 (" + result.length + "×" + result[0].length + "): " + Arrays.deepToString(result)
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
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
        System.out.println();

        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] B = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        int[][] C = {
                {13, 14}
        };

        Practice.showResultMatrix(A, B);
        System.out.println();
        Practice.showResultMatrix(B, A);
        System.out.println();
        Practice.showResultMatrix(A, C);
        System.out.println();
        Practice.showResultMatrix(C, A);
        System.out.println();
    }
}