class Calculator {
    static void calculator(String[] args) {
        if (args.length != 3) {
            System.out.println("Использование: java Calculator <число1> <операция> <число2>");
            System.out.println("Операции: + - * /");
            System.out.println("Пример: java Calculator 10 + 5");
        }

        double a;
        try {
            a = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: '" + args[0] + "' не является числом!");
            return;
        }

        String operation = args[1];

        double b;
        try {
            b = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: '" + args[2] + "' не является числом!");
            return;
        }

        double result;

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Ошибка: деление на ноль!");
                    return;
                }
                result = a / b;
                break;
            default:
                System.out.println("Неизвестная операция: " + operation);
                System.out.println("Доступные операции: + - * /");
                return;
        }

        System.out.println(a + " " + operation + " " + b + " = " + result);
    }
}


class Practice {
    static void hello(String[] args) {
        if (args.length == 0) {
            System.out.println("Привет, незнакомец!");
        } else if (args.length == 1) {
            System.out.println("Привет, " + args[0] + "!");
        } else {
            System.out.print("Привет, " + args[0]);
            for (int i = 0; i < args.length; i++) {
                System.out.print(", " + args[i]);
            }
            System.out.println("!");
        }
    }

    static void tempConverter(String[] args) {
        if (args.length < 1) {
            System.out.println("Использование: java TempConverter <температура> [C|F]");
            System.out.println("По умолчанию: Цельсий → Фаренгейт");
            return;
        }

        double temp = Double.parseDouble(args[0]);
        String unit = args.length > 1 ? args[1].toUpperCase() : "C";

        if (unit.equals("C")) {
            double f = temp * 9.0 / 5.0 + 32;
            System.out.printf("%.1f°C = %.1f°F%n", temp, f);
        } else if (unit.equals("F")) {
            double c = (temp - 32) * 5.0 / 9.0;
            System.out.printf("%.1f°F = %.1f°C%n", temp, c);
        } else {
            System.out.println("Неизвестная единица: " + unit);
        }
    }

    static void lightFind(String[] args) {
        if (args.length < 1) {
            System.out.println("Исполльзование: java Find <слово> [текст]");
            return;
        }

        String word = args[0];
        String text = args.length > 1 ? args[1] : "Java – отличный язык программирования";

        int index = text.indexOf(word);
        if (index != -1) {
            System.out.println("Слово '" + word + "' найдено на позиции " + index);
        } else {
            System.out.println("Слово '" + word + "' не найдено");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        Practice.lightFind(args);
    }
}