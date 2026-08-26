class Parsing {

    // Подход 1: try-catch
    static void safeParse(String[] args) {
        for (String arg : args) {
            try {
                int number = Integer.parseInt(arg);
                System.out.println(arg + " → " + number);
            } catch (NumberFormatException e) {
                System.out.println(arg + " → ошибка: не целое число!");
            }
        }
    }

    // Подход 2: Проверка регулярным выражением
    static void regexParse(String[] args) {
        for (String arg : args) {
            if (arg.matches("-?\\d+")) {
                int number = Integer.parseInt(arg);
                System.out.println(arg + " → " + number);
            } else {
                System.out.println(arg + " → не целое число!");
            }
        }
    }
}


class ParseUtil {
    static int parseInt(String s, int defaultValue) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    static double parseDouble(String s, double defaultValue) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}


class Practice {
    static void currencyConverter(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: java CurrencyConverter <сумма> <курс>");
            System.out.println("Пример: java CurrencyConverter 100 92.5");
            return;
        }

        try {
            double amount = Double.parseDouble(args[0]);
            double rate = Double.parseDouble(args[1]);
            double result = amount * rate;

            System.out.printf("%.2f $ = %.2f ₽%n", amount, result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат числа!");
        }
    }

    static void wordCounter(String[] args) {
        if (args.length == 0) {
            System.out.println("Передайте слова через пробел!");
            return;
        }

        int totalChars = 0;
        for (String word : args) {
            totalChars += word.length();
        }

        System.out.println("Слов: " + args.length);
        System.out.println("Символов: " + totalChars);
        System.out.println("Средняя длина слова: " + (double) totalChars / args.length);
    }

    static void areaCalculator(String[] args) {
        if (args.length < 1) {
            System.out.println("Фигуры: circle, rectangle, triangle");
            System.out.println("Использование: java AreaCalculator circle 5");
            System.out.println("               java AreaCalculator rectangle 4 6");
            System.out.println("               java AreaCalculator triangle 3 8");
            return;
        }

        String figure = args[0].toLowerCase();

        switch (figure) {
            case "circle":
                if (args.length < 2) { System.out.println("Нужен радиус!"); return; }
                double r = Double.parseDouble(args[1]);
                System.out.printf("Площадь круга: %.2f%n", Math.PI * r * r);
                break;
            case "rectangle":
                if (args.length < 3) { System.out.println("Нужны длина и ширина!"); return; }
                double l = Double.parseDouble(args[1]);
                double w = Double.parseDouble(args[2]);
                System.out.printf("Площадь прямоугольника: %.2f%n", l * w);
                break;
            case "triangle":
                if (args.length < 3) { System.out.println("Нужны основание и высота!"); return; }
                double base = Double.parseDouble(args[1]);
                double height = Double.parseDouble(args[2]);
                System.out.printf("Площадь треугольника: %.2f%n", base * height / 2.0);
            default:
                System.out.println("Неизвестная фигура: " + figure);
        }
    }

    static void ageCheck(String[] args) {
        if (args.length < 1) {
            System.out.println("Использование: java AgeCheck <возраст>");
            return;
        }

        try {
            int age = Integer.parseInt(args[0]);

            if (age < 0) {
                System.out.println("Возраст не может быть отрицательным!");
            } else if (age < 14) {
                System.out.println("Дети до 14 лет: " + age + " лет");
            } else if (age < 18) {
                System.out.println("Несовершеннолетние: " + age + " лет");
            } else if (age < 65) {
                System.out.println("Взрослые: " + age + " лет");
            } else {
                System.out.println("Пенсионеры: " + age + " лет");
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите целое число!");
        }
    }

    static void caesarCipher(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: java CaesarCipher <текст> <сдвиг>");
            return;
        }

        String text = args[0];
        int shift = Integer.parseInt(args[1]);
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append((char) ('A' + (c - 'A' + shift) % 26));
            } else if (c >= 'a' && c <= 'z') {
                result.append((char) ('a' + (c - 'a' + shift) % 26));
            } else {
                result.append(c);
            }
        }

        System.out.println("Шифр: " + result.toString());
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        Parsing.safeParse(args);

        System.out.println();
        Parsing.regexParse(args);

        System.out.println();

        int port = ParseUtil.parseInt(args.length > 0 ? args[0] : "", 8080);
        double rate = ParseUtil.parseDouble(args.length > 0 ? args[0] : "", 1.0);

        System.out.println("Порт: " + port);
        System.out.println("Ставка: " + rate);

        System.out.println();
        Practice.currencyConverter(args);

        System.out.println();
        Practice.wordCounter(args);

        System.out.println();
        Practice.areaCalculator(args);

        System.out.println();
        Practice.ageCheck(args);

        System.out.println();
        Practice.caesarCipher(args);
    }
}