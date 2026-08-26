class Patterns {
    // Паттерн 1: Флаги и значения
    // Многие командные утилиты используют флаги (опции) вида --flag значение или -f значение:
    static void flagParser(String[] args) {
        String host = "localhost";
        int port = 8080;
        boolean verbose = false;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--host":
                case "-h":
                    if (i + 1 < args.length) host = args[++i];
                    break;
                case "--port":
                case "-p":
                    if (i + 1 < args.length) port = Integer.parseInt(args[++i]);
                    break;
                case "--verbose":
                case "-v":
                    verbose = true;
                    break;
            }
        }

        System.out.println("Хост: " + host);
        System.out.println("Порт: " + port);
        System.out.println("Подробный режим: " + verbose);
    }
    // Запуск: java FlagParser --host 192.168.1.1 --port 3000 --verbose

    // Паттерн 2: Имя файла и опции
    static void fileReader(String[] args) {
        if (args.length < 1) {
            System.out.println("Использование: java FileReader <файл> [--lines|--words|--chars]");
            return;
        }

        String filename = args[0];
        String mode = args.length > 1 ? args[1] : "--lines";

        System.out.println("Файл: " + filename);
        System.out.println("Режим: " + mode);

        // Здесь была бы реальная логика чтения файла
    }

    // Паттерн 3: Позиционные аргументы
    static void deploy(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: java Deploy <окружение> <версия> [флаги]");
            System.out.println("Окружения: dev, staging, prod");
            return;
        }

        String env = args[0];
        String version = args[1];
        boolean dryRun = false;

        for (int i = 2; i < args.length; i++) {
            if (args[i].equals("--dry-run")) {
                dryRun = true;
            }
        }

        System.out.println("Развёртывание: " + version + " на " + env);
        if (dryRun) {
            System.out.println("(Пробный запуск – ничего не меняем)");
        }
    }
    // Запуск: java Deploy prod 2.1.0 --dry-run

    // Паттерн 4: Значения по умолчанию
    static void webServer(String[] args) {
        String host = "0.0.0.0";
        int port = 80;
        String root = "./public";

        for (int i = 0; i < args.length; i += 2) {
            if (i + 1 >= args.length) break;
            switch (args[i]) {
                case "--host":
                    host = args[i + 1];
                    break;
                case "--port":
                    port = Integer.parseInt(args[i + 1]);
                    break;
                case "--root":
                    root = args[i + 1];
                    break;
            }
        }

        System.out.println("Сервер запускается на " + host + ":" + port);
        System.out.println("Корневая директория: " + root);
    }
    // Запуск: java WebServer --port 3000
    // Вывод: Сервер запускается на 0.0.0.0:3000
}


class SafeFileReader {
    static void safeFileReader(String[] args) {
        if (args.length < 1) {
            System.out.println("Использование: java SafeFileReader <имя_файла>");
            return;
        }

        String filename = args[0];

        // Проверка на path traversal
        if (filename.contains("..") || filename.contains("/") || filename.contains("\\")) {
            System.out.println("Ошибка: недопустимое имя файла!");
            return;
        }

        // Проверка длины
        if (filename.length() > 255) {
            System.out.println("Ошибка: имя файла слишком длинное!");
            return;
        }

        // Проверка на пустую строку
        if (filename.trim().isEmpty()) {
            System.out.println("Ошибка: имя файла не может быть пустым!");
            return;
        }

        System.out.println("Чтение файла: " + filename);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        SafeFileReader.safeFileReader(args);
    }
}