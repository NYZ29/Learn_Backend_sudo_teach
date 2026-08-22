class WorkWithArgs {
    static int parseIntArg(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Нет аргументов");
        }
        return Integer.parseInt(args[0]);
    }

    static double parseDoubleArg(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Нет аргументов");
        }
        return Double.parseDouble(args[0]);
    }
}


class ExceptionHandler {
    static void handle(Exception e, String context) {
        if (e instanceof NumberFormatException) {
            System.out.println("Ошибка формата числа: (" + context + "): не является целым числом.");
        } else if (e instanceof IllegalArgumentException) {
            System.out.println("Ошибка аргумента (" + context + "): " + e.getMessage());
        } else {
            System.out.println("Неожиданная ошибка: (" + context + "): " + e.getMessage());
        }
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();

        // int
        try {
            int number = WorkWithArgs.parseIntArg(args);
            System.out.println("Вы передали число: " + number);
            System.out.println("Удвоенное: " + (number * 2));
        } catch (IllegalArgumentException e) {
            ExceptionHandler.handle(e, "parseIntArg");
        }

        // double
        try {
            double number = WorkWithArgs.parseDoubleArg(args);
            System.out.println("Число: " + number);
            System.out.println("Квадрат: " + (number * number));
        } catch (IllegalArgumentException e) {
            ExceptionHandler.handle(e, "parseDoubleArg");
        }
    }
}