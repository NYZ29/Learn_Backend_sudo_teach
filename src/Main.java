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


public class Main {
    public static void main(String[] args) {
        System.out.println();
        Parsing.safeParse(args);
    }
}