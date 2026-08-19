import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


class DataVisualisation {
    static void histogram(int @NotNull [] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Позиция %d:", i);
            for (int j = 0; j < data[i]; j++) {
                System.out.print("█");
            }
            System.out.println(" (" + data[i] + ")");
        }
    }

    static void multiplicationTable(int n) {
        int[][] table = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        System.out.print("    ");
        for (int j = 1; j <= n; j++) {
            System.out.printf("%4d", j);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%2d |", i + 1);
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", table[i][j]);
            }
            System.out.println();
        }
    }

    static void pairwiseDistanceMatrix() {
        String[] cities = {"Москва", "СПБ", "Новосибирск", "Екатеринбург"};
        int[][] distances = {
                {0, 650, 3350, 1770},
                {650, 0, 3500, 2100},
                {3350, 3500, 0, 1800},
                {1770, 2100, 1800, 0}
        };

        System.out.println("Матрица расстояний (км):");
        System.out.print("          ");
        for (String city : cities) {
            System.out.printf("%14s", city);
        }
        System.out.println();

        for (int i = 0; i < cities.length; i++) {
            System.out.printf("%12s", cities[i]);
            for (int j = 0; j < cities.length; j++) {
                System.out.printf("%13d", distances[i][j]);
            }
            System.out.println();
        }
    }

    static void gradeHeatMap() {
        String[] students = {"Анна", "Борис", "Виктор", "Галина"};
        String[] subjects = {"Математика", "Физика", "Информатика"};
        int[][] grades = {
                {5, 4, 5},
                {4, 5, 4},
                {3, 4, 5},
                {5, 5, 5}
        };

        System.out.print("          ");
        for (String sub : subjects) {
            System.out.printf("%12s", sub);
        }
        System.out.println();

        for (int i = 0; i < students.length; i++) {
            System.out.printf("%10s", students[i]);
            for (int j = 0; j < subjects.length; j++) {
                String bar = "";
                for (int k = 0; k < grades[i][j]; k++) {
                    bar += "●";
                }
                System.out.printf("%12s", bar);
            }
            System.out.println();
        }
    }
}


class MatrixPractice {
    static void labyrinth(int @NotNull [][] maze) {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[row][col] == 1) {
                    System.out.print("██");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void lightBFS(int @NotNull [][] maze) {
        int startRow = 1, startCol = 1;
        int endRow = 3, endCol = 3;

        int[][] visited = new int[maze.length][maze[0].length];

        boolean found = findPath(maze, visited, startRow, startCol, endRow, endCol);

        if (found) {
            System.out.println("Путь найден!");
            for (int[] row : visited) {
                System.out.println(Arrays.toString(row));
            }
        } else {
            System.out.println("Путь не найден!");
        }
    }

    static boolean findPath(
            int @NotNull [][] maze,
            int @NotNull [][] visited,
            int row,
            int col,
            int endRow,
            int endCol
    ) {
        if (row == endRow && col == endCol) {
            return true;
        }

        // Если в процессе поиска мы вышли за границы, то возвращаем false
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) return false;
        // Если точка, в которой мы сейчас находимся, является стеной или мы её уже посещали, то возвращаем false
        if (maze[row][col] == 1 || visited[row][col] == 1) return false;

        // Если дошли до этого момента, значит, все предыдущие условия не выполнились, значит, временно "ставим" стену, чтобы не было бесконечной проверки 2 соседних клеток
        visited[row][col] = 1;

        // Рекурсивный перебор соседних точек. Все проверки условий выше - проверка на базовый случай
        if (findPath(maze, visited, row + 1, col, endRow, endCol)) return true;
        if (findPath(maze, visited, row, col + 1, endRow, endCol)) return true;
        if (findPath(maze, visited, row - 1, col, endRow, endCol)) return true;
        if (findPath(maze, visited, row, col - 1, endRow, endCol)) return true;

        // Возвращаем истинное значение точки
        visited[row][col] = 0;
        return false;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();

        int[] data = {5, 12, 8, 15, 3, 10, 7};
        DataVisualisation.histogram(data);
        System.out.println();

        int n = 10;
        DataVisualisation.multiplicationTable(n);
        System.out.println();

        DataVisualisation.pairwiseDistanceMatrix();
        System.out.println();

        DataVisualisation.gradeHeatMap();
        System.out.println();

        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
        MatrixPractice.labyrinth(maze);
        System.out.println();

        int[][] maze1 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        MatrixPractice.labyrinth(maze1);
        MatrixPractice.lightBFS(maze1);
    }
}