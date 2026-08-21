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

    static void parseDouble(String[] args) {
        if (args.length < 1) {
            System.out.println("Передайте число!");
            return;
        }

        double number = Double.parseDouble(args[0]);
        System.out.println("Число: " + number);
        System.out.println("Квадрат: " + (number * number));
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


        /*System.out.println();
        WorkWithArgs.parseDouble(args);*/
    }
}