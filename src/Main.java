class WorkWithArgs {
    static int parseIntArg(String[] args) {
        ExceptionHandler.checkHasArgument(args, "parseIntArg");
        return Integer.parseInt(args[0]);
    }

    static double parseDoubleArg(String[] args) {
        ExceptionHandler.checkHasArgument(args, "parseDoubleArg");
        return Double.parseDouble(args[0]);
    }
}


class CheckNumberOfArguments {
    static void greeting(String[] args) {
        ExceptionHandler.checkHasArgument(args, "greeting");
        if (!ExceptionHandler.isPureText(args[0])) {
            throw new IllegalArgumentException("Имя должно содержать только буквы и пробелы: " + args[0]);
        }

        System.out.println("Привет, " + args[0] + "!");
    }
}


class ExceptionHandler {
    static void checkHasArgument(String[] args, String context) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Нет аргументов: " + context);
        }
    }

    static boolean isPureText(String s) {
        if (s == null || s.isEmpty()) return false;
        // ^[A-Za-zА-Яа-яЁё\s]+$ — только буквы и пробелы, без цифр
        return s.matches("^[A-Za-zА-Яа-яЁё\\s]+$");
    }

    static void handle(Exception e, String context) {
        if (e instanceof NumberFormatException) {
            handleNumberFormatException(context);
        } else if (e instanceof IllegalArgumentException) {
            handleIllegalArgumentException(e, context);
        } else {
            System.out.println("Неожиданная ошибка: (" + context + "): " + e.getMessage());
        }
    }

    private static void handleNumberFormatException(String context) {
        if ("parseIntArg".equals(context)) {
            System.out.println("Ошибка формата числа: (" + context + "): значение не является целым числом.");
        } else if ("parseDoubleArg".equals(context)) {
            System.out.println("Ошибка формата числа: (" + context + "): значение не является числом.");
        } else {
            System.out.println("Ошибка формата числа (" + context + "): неверный числовой формат.");
        }
    }

    private static void handleIllegalArgumentException(Exception e, String context) {
        System.out.println("Ошибка аргумента (" + context + "): " + e.getMessage());
        if ("greeting".equals(context)) {
            System.out.println("Использование: java Greeting <имя>");
            System.out.println("Пример: java Greeting Анна");
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
        System.out.println();

        try {
            CheckNumberOfArguments.greeting(args);
        } catch (IllegalArgumentException e) {
            ExceptionHandler.handle(e, "greeting");
        }
    }
}