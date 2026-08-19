import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


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

    static void lightBFS(
            int @NotNull [][] maze,
            int startRow,
            int startCol,
            int endRow,
            int endCol
    ) {
        int[][] visited = new int[maze.length][maze[0].length];

        boolean found = findPath(maze, visited, startRow, startCol, endRow, endCol);

        if (found) {
            System.out.println("Путь найден!");
            visited[endRow][endCol] = 1;
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
        int startRow1 = 1, startCol1 = 1;
        int endRow1 = 3, endCol1 = 3;
        MatrixPractice.labyrinth(maze1);
        MatrixPractice.lightBFS(maze1, startRow1, startCol1, endRow1, endCol1);
        System.out.println();

        int startRow = 1, startCol = 5;
        int endRow = 1, endCol = 1;
        MatrixPractice.labyrinth(maze);
        MatrixPractice.lightBFS(maze, startRow, startCol, endRow, endCol);
    }
}