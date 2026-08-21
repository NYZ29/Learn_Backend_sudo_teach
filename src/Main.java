class WorkWithArgs {
    static void argsDemo(String[] args) {
        // Длина массива
        System.out.println("Аргументов: " + args.length);

        // Доступ по индексу
        if (args.length > 0) {
            System.out.println("Первый: " + args[0]);
        }
        if (args.length > 1) {
            System.out.println("Второй: " + args[1]);
        }

        // Последний аргумент
        if (args.length > 0) {
            System.out.println("Последний: " + args[args.length - 1]);
        }

        // Перебор всех аргументов
        for (String arg : args) {
            System.out.println("Аргумент: " + arg);
        }
    }

    static void argsMethods(String[] args) {
        // Проверка на пустоту
        if (args.length == 0) {
            System.out.println("Аргументы не переданы!");
            return;
        }

        // Цикл for с индексом
        for (int i = 0; i < args.length; i++) {
            System.out.println(i + ": " + args[i]);
        }

        // for-each
        for (String arg : args) {
            System.out.println(arg.toUpperCase());
        }
    }

    static void parseIntLocal(String[] args) {
        if (args.length < 1) {
            System.out.println("Передайте число!");
            return;
        }

        try {
            int number = Integer.parseInt(args[0]);
            System.out.println("Вы передали число: " + number);
            System.out.println("Удвоенное: " + (number * 2));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: '" + args[0] + "' не является целым числом.");
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
        WorkWithArgs.argsDemo(args);

        System.out.println();
        WorkWithArgs.argsMethods(args);

        System.out.println();
        WorkWithArgs.parseIntLocal(args);

        System.out.println();
        WorkWithArgs.parseDouble(args);
    }
}