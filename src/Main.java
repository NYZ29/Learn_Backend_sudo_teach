import java.util.Arrays;


class SeaBattle {
    /// Поле — это квадрат 10×10. Используем символы:
    ///
    /// '~' — вода (пустая клетка)
    /// 'S' — корабль
    /// 'X' — попадание
    /// 'O' — промах
    static void paintingBattlefield(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[0].length; col++) {
                field[row][col] = '~';
            }
        }
    }

    static void placeShip(char[][] field, int row, int col, int size, boolean horizontal) {
        for (int i = 0; i < size; i++) {
            if (horizontal) {
                field[row][col + i] = 'S';
            } else {
                field[row + i][col] = 'S';
            }
        }
    }

    static void showField(char[][] field) {
        System.out.print("  ");
        for (int col = 0; col < field[0].length; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < field.length; row++) {
            System.out.print((char) ('A' + row) + " ");
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col] + " ");
            }
            System.out.println();
        }
    }

    static String shoot(char[][] field, int row, int col) {
        if (field[row][col] == 'S') {
            field[row][col] = 'X';
            return "Попадание!";
        } else if (field[row][col] == '~') {
            field[row][col] = 'O';
            return "Промах!";
        } else {
            return "Вы уже стреляли в эту клетку!";
        }
    }

    static boolean areAllShipsDestroyed(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'S') {
                    return false;
                }
            }
        }
        return true;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();

        char[][] field = new char[10][10];
        SeaBattle.paintingBattlefield(field);

        SeaBattle.placeShip(field, 0, 0, 3, true);
        SeaBattle.placeShip(field, 2, 5, 2, false);
        SeaBattle.placeShip(field, 5, 1, 4, true);

        SeaBattle.showField(field);
        System.out.println();

        System.out.println(SeaBattle.shoot(field, 0, 0));
        SeaBattle.showField(field);
        System.out.println();

        System.out.println(SeaBattle.shoot(field, 1, 1));
        SeaBattle.showField(field);
        System.out.println();

        System.out.println(SeaBattle.shoot(field, 0, 0));
        SeaBattle.showField(field);
        System.out.println();

        System.out.println("Все корабли потоплены: " + SeaBattle.areAllShipsDestroyed(field));
        System.out.println();

        SeaBattle.placeShip(field, 5, 1, 4, true);
        for (int j = 1; j <= 4; j++) {
            field[5][j] = 'X';
        }
        for (int j = 1; j <= 2; j++) {
            field[0][j] = 'X';
        }
        for (int i = 2; i <= 3; i++) {
            field[i][5] = 'X';
        }
        SeaBattle.showField(field);
        System.out.println("Все корабли потоплены: " + SeaBattle.areAllShipsDestroyed(field));
    }
}
