class WorkWithArgs {

    static int parseInt(String[] args) {
        ExceptionHandler.requireArguments(args, 1);
        return Integer.parseInt(args[0]);
    }

    static double parseDouble(String[] args) {
        ExceptionHandler.requireArguments(args, 1);
        return Double.parseDouble(args[0]);
    }

    static void greeting(String[] args) {
        ExceptionHandler.requireArguments(args, 1);

        if (!ExceptionHandler.isText(args[0])) {
            throw new IllegalArgumentException("аргумент должен содержать только латинские и кириллические буквы");
        }

        System.out.println("Привет, " + args[0] + "!");
    }

    static void add(String[] args) {
        ExceptionHandler.requireArguments(args, 2);

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(a + " + " + b + " = " + (a + b));
    }
}


class ExceptionHandler {

    static void requireArguments(String[] args, int expected) {
        if (args.length != expected) {
            throw new IllegalArgumentException(
                    "ожидалось аргументов - "
                            + expected
                            + ", получено - "
                            + args.length
            );
        }
    }

    static boolean isText(String value) {
        return value != null
                && !value.isBlank()
                && value.matches("[A-Za-zА-Яа-яЁё\\s]+");
    }

    static void print(String message) {
        System.err.println("Ошибка: " + message);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();

        handleInt(args);
        handleDouble(args);
        handleGreeting(args);
        handleAdd(args);
    }

    private static void handleInt(String[] args) {
        try {
            int number = WorkWithArgs.parseInt(args);

            System.out.println("Вы передали число: " + number);
            System.out.println("Удвоенное: " + number * 2);
        } catch (NumberFormatException e) {
            ExceptionHandler.print("int: аргумент не является целым числом");
        } catch (IllegalArgumentException e) {
            ExceptionHandler.print("int: " + e.getMessage());
        }
        System.out.println();
    }

    private static void handleDouble(String[] args) {
        try {
            double number = WorkWithArgs.parseDouble(args);

            System.out.println("Число: " + number);
            System.out.println("Квадрат: " + number * number);
        } catch (NumberFormatException e) {
            ExceptionHandler.print("double: аргумент не является числом");
        } catch (IllegalArgumentException e) {
            ExceptionHandler.print("double: " + e.getMessage());
        }
        System.out.println();
    }

    private static void handleGreeting(String[] args) {
        try {
            WorkWithArgs.greeting(args);
        } catch (IllegalArgumentException e) {
            ExceptionHandler.print("greeting: " + e.getMessage());
        }
        System.out.println();
    }

    private static void handleAdd(String[] args) {
        try {
            WorkWithArgs.add(args);
        } catch (NumberFormatException e) {
            ExceptionHandler.print("add: оба аргумента должны быть целыми числами");
        } catch (IllegalArgumentException e) {
            ExceptionHandler.print("add: " + e.getMessage());
        }
    }
}