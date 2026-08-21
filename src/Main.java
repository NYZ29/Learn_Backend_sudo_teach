class WorkWithArgs {
    static void parseIntLocal(String[] args) {
        if (args.length < 1) {
            System.out.println("Передайте число! (Local)");
            return;
        }

        try {
            int number = Integer.parseInt(args[0]);
            System.out.println("Вы передали число (Local): " + number);
            System.out.println("Удвоенное (Local): " + (number * 2));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка (Local): '" + args[0] + "' не является целым числом.");
        }
    }

    static int parseIntArg(String[] args) throws NumberFormatException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Нет аргументов (Arg)");
        }
        return Integer.parseInt(args[0]);
    }

    static int parseIntArgMine(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Нет аргументов (ArgMine)");
        }

        try {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Первый аргумент должен быть целым числом (ArgMine)", e);
        }
    }

    static void parseDoubleLocal(String[] args) {
        if (args.length < 1) {
            System.out.println("Передайте число! (LocalDouble)");
            return;
        }

        try {
            double number = Double.parseDouble(args[0]);
            System.out.println("Число (LocalDouble): " + number);
            System.out.println("Квадрат (LocalDouble): " + (number * number));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: число " + args[0] + " не является дробным. (LocalDouble)");
        }
    }

    static double parseDoubleArg(String[] args) throws NumberFormatException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Нет аргументов (DoubleArg)");
        }
        return Double.parseDouble(args[0]);
    }

    static double parseDoubleArgMine(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Нет аргументов (DoubleArgMine)");
        }

        try {
            return Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Первый аргумент должен быть дробным числом (DoubleArgMine)", e);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        WorkWithArgs.parseIntLocal(args);

        System.out.println();
        try {
            int number = WorkWithArgs.parseIntArg(args);
            System.out.println("Вы передали число (Arg): " + number);
            System.out.println("Удвоенное (Arg): " + (number * 2));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: первый аргумент должен быть целым числом. (Arg)");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: передайте хотя бы один аргумент. (Arg)");
        }
        System.out.println("Программа продолжается...");

        System.out.println();
        try {
            int number = WorkWithArgs.parseIntArgMine(args);
            System.out.println("Вы передали число (ArgMine): " + number);
            System.out.println("Удвоенное (ArgMine): " + (number * 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода (ArgMine): " + e.getMessage());
        }


        System.out.println();
        WorkWithArgs.parseDoubleLocal(args);

        System.out.println();
        try {
            double number = WorkWithArgs.parseDoubleArg(args);
            System.out.println("Число (DoubleArg): " + number);
            System.out.println("Квадрат (DoubleArg): " + (number * number));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: первый аргумент должен быть дробным числом. (DoubleArg)");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: передайте хотя бы один аргумент. (DoubleArg)");
        }
        System.out.println("Программа продолжается...");

        System.out.println();
        try {
            double number = WorkWithArgs.parseDoubleArgMine(args);
            System.out.println("Число (DoubleArgMine): " + number);
            System.out.println("Квадрат (DoubleArgMine): " + (number * number));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода (DoubleArgMine): " + e.getMessage());
        }
    }
}