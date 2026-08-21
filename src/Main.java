public class Main {
    public static void main(String[] args) {
        System.out.println();

        // Длина массива
        System.out.println("Аргументов: " + args.length);

        // Доступ по индексу
        if (args.length > 0) {
            System.out.println("Первый: " + args[0]);
        }
        if (args.length > 1) {
            System.out.println("Второй: " + args[0]);
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
}