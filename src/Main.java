import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;


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

    static void DFS(
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

    static @NotNull List<int[]> findShortestPathBfs(
            int @NotNull [][] maze,
            int startRow,
            int startCol,
            int endRow,
            int endCol
    ) {
        int rows = maze.length;
        int cols = maze[0].length;

        if (maze[startRow][startCol] == 1 || maze[endRow][endCol] == 1) return List.of();

        boolean[][] visited = new boolean[rows][cols];

        // parentRow[r][c], parentCol[r][c] — координаты клетки,
        // из которой мы впервые пришли в (r, c)
        int[][] parentRow = new int[rows][cols];
        int[][] parentCol = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            // у нас 0 - клетки, по которым можно пройти дальше (не стена)
            // а в Java 0 - значение элементов массивов по умолчанию, поэтому мы их заменяем на -1
            Arrays.fill(parentRow[row], -1);
            Arrays.fill(parentCol[row], -1);
        }

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if (row == endRow && col == endCol) {
                break;
            }

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                boolean outsideMaze =
                        nextRow < 0 || nextRow >= rows ||
                                nextCol < 0 || nextCol >= cols;

                if (outsideMaze || maze[nextRow][nextCol] == 1 || visited[nextRow][nextCol]) {
                    continue;
                }

                visited[nextRow][nextCol] = true;
                parentRow[nextRow][nextCol] = row;
                parentCol[nextRow][nextCol] = col;

                queue.offer(new int[]{nextRow, nextCol});
            }
        }

        if (!visited[endRow][endCol]) {
            return List.of();
        }

        List<int[]> path = new ArrayList<>();

        for (int row = endRow, col = endCol; row != -1; ) {
            path.add(new int[]{row, col});

            int previousRow = parentRow[row][col];
            int previousCol = parentCol[row][col];

            row = previousRow;
            col = previousCol;
        }

        Collections.reverse(path);
        return path;
    }

    static void showShortestPathBfs(int[][] maze, @NotNull List<int[]> path) {
        if (path.isEmpty()) {
            System.out.println("Путь не найден!");
        } else {
            int[][] visit = new int[maze.length][maze[0].length];

            System.out.println("Кратчайший путь найден");
            System.out.println("Количество шагов: " + (path.size() - 1));

            for (int[] point : path) {
                visit[point[0]][point[1]] = 1;
                System.out.printf("(%d, %d)%n", point[0], point[1]);
            }
            System.out.println();

            System.out.println("Путь в матрице:");
            for (int[] visitRow : visit) {
                System.out.println(Arrays.toString(visitRow));
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
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
        MatrixPractice.DFS(maze1, startRow1, startCol1, endRow1, endCol1);
        System.out.println();

        List<int[]> path1 = MatrixPractice.findShortestPathBfs(
                maze1,
                startRow1,
                startCol1,
                endRow1,
                endCol1
        );
        MatrixPractice.showShortestPathBfs(maze1, path1);
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

        int startRow = 1, startCol = 5;
        int endRow = 1, endCol = 1;
        MatrixPractice.labyrinth(maze);
        MatrixPractice.DFS(maze, startRow, startCol, endRow, endCol);
        System.out.println();

        List<int[]> path = MatrixPractice.findShortestPathBfs(
                maze,
                startRow,
                startCol,
                endRow,
                endCol
        );
        MatrixPractice.showShortestPathBfs(maze, path);
    }
}