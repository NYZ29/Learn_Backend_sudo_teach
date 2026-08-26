class Vararg {
    static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    static void process(String... messages) {
        System.out.println("количество аргументов: " + messages.length);

        // Доступ по индексу
        for (int i = 0; i < messages.length; i++) {
            System.out.println("messages[" + i + "] = " + messages[i]);
        }

        // For-each
        for (String msg : messages) {
            System.out.println("Сообщение: " + msg);
        }

        // Проверка на пустоту
        if (messages.length == 0) {
            System.out.println("Нет сообщений");
        }

        // Первый и последний
        if (messages.length > 0) {
            System.out.println("Первое: " + messages[0]);
            System.out.println("Последнее: " + messages[messages.length - 1]);
        }
    }

    static void printNumbers(int... nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println((i + 1) + ". " + nums[i]);
        }
        System.out.println("---");
    }

    static void log(String level, String... messages) {
        System.out.println("[" + level + "]");
        for (String msg : messages) {
            System.out.println(" " + msg);
        }
    }

    static void sendEmail(String from, String subject, String... to) {
        System.out.println("От: " + from);
        System.out.println("Тема: " + subject);
        System.out.println("Кому: ");
        for (int i = 0; i < to.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(to[i]);
        }
        System.out.println();
        System.out.println("---");
    }

    static void printTable(String header, char separator, int width, String... rows) {
        System.out.println("=".repeat(width));
        System.out.println(header);
        System.out.println("=".repeat(width));

        for (String row : rows) {
            System.out.println(separator + " " + row + " " + separator);
        }

        System.out.println("=".repeat(width));
    }

    static void show(String... items) {
        for (String item : items) {
            System.out.println(" - " + item);
        }
    }

    static void printAll(Object... items) {
        for (Object item : items) {
            System.out.println(item.getClass().getSimpleName() + ": " + item);
        }
    }

    // Пример: метод для построения SQL-подобного запроса
    static String select(String table, String... columns) {
        StringBuilder query = new StringBuilder("SELECT ");
        for (int i = 0; i < columns.length; i++) {
            if (i > 0) query.append(", ");
            query.append(columns[i]);
        }
        query.append(" FROM ").append(table);
        return query.toString();
    }

    // Пример: цепочка вызовов (builder-паттерн с vararg)
    static String buildTag(String tag, String... attributes) {
        StringBuilder html = new StringBuilder("<" + tag);
        for (int i = 0; i < attributes.length; i += 2) {
            html.append(" ").append(attributes[i]).append("=\"").append(attributes[i + 1]).append("\"");
        }
        html.append(">");
        return html.toString();
    }

    // Пример: комбинирование vararg с шаблонами
    static <T> java.util.List<T> listOf(T... items) {
        java.util.List<T> list = new java.util.ArrayList<>();
        for (T item : items) {
            list.add(item);
        }
        return list;
    }

    // Пример: валидация email-адресов
    private static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".") && email.length() > 5;
    }

    static boolean allEmailsValid(String... emails) {
        for (String email : emails) {
            if (!isValidEmail(email)) {
                System.out.println("Невалидный email: " + email);
                return false;
            }
        }
        return true;
    }

    // Правило простое: если вы передаёте набор данных в метод и не планируете его изменять — используйте vararg. Если нужно динамически строить коллекцию — используйте ArrayList.
    // Vararg — для передачи готовых данных
    static int sumVararg(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    // ArrayList — для динамического построения
    static java.util.List<Integer> buildList(int count) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(i * 10);
        }
        return list;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();

        // Способ 1: Передаём числа через запятую (без создания массива!)
        int result1 = Vararg.sum(1, 2, 3);
        System.out.println(result1);

        // Способ 2: Передаём готовый массив
        int result2 = Vararg.sum(new int[]{10, 20, 30, 40});
        System.out.println(result2);

        // Способ 3: Передаём ничего (пустой vararg)
        int result3 = Vararg.sum();
        System.out.println(result3);

        System.out.println();
        Vararg.process(args);

        System.out.println();
        Vararg.printNumbers(10, 20, 30);
        Vararg.printNumbers(5);
        Vararg.printNumbers();

        System.out.println();
        Vararg.log("INFO", "Сервер запущен");
        Vararg.log("ERROR", "Ошибка подключения", "Таймаут", "Код 504");
        Vararg.log("DEBUG", "x=5", "y=10", "z=15");

        System.out.println();
        Vararg.sendEmail("admin@test.com", "Привет", "user1@test.com");
        Vararg.sendEmail("boss@company.com", "Отчёт", "a@b.com", "c@d.com", "e@f.com");

        System.out.println();
        Vararg.printTable("Header", '|', 7, "abc", "defg", "hiklmn");

        System.out.println();
        System.out.println("Способ 1: Аргументы через запятую");
        Vararg.show("яблоко", "банан", "вишня");

        System.out.println("\nСпособ 2: Готовый массив");
        String[] fruits = {"яблоко", "банан", "вишня"};
        Vararg.show(fruits);

        System.out.println("\nСпособ 3: Ничего (пустой vararg)");
        Vararg.show();

        System.out.println();
        Vararg.printAll(42, "Привет", 3.14, true, 'A');

        System.out.println();
        System.out.println(Vararg.select("users", "*"));
        System.out.println(Vararg.select("users", "name", "email", "age"));
        System.out.println(Vararg.select("orders", "id", "total", "date"));

        System.out.println();
        System.out.println(Vararg.buildTag("a", "href", "https://java.com", "class", "link"));
        System.out.println(Vararg.buildTag("input", "type", "text", "name", "email", "placeholder", "Введите email"));

        System.out.println();
        java.util.List<Integer> numbers = Vararg.listOf(1, 2, 3, 4, 5);
        java.util.List<String> names = Vararg.listOf("Анна", "Борис", "Виктор");

        System.out.println(numbers);
        System.out.println(names);

        System.out.println();
        System.out.println(Vararg.allEmailsValid("test@mail.com", "user@domain.org"));
        System.out.println(Vararg.allEmailsValid("test@mail.com", "invalid"));

        System.out.println();
        // Vararg: удобно передавать
        System.out.println(Vararg.sumVararg(1, 2, 3, 4, 5));

        // ArrayList: динамическое построение
        java.util.List<Integer> numbers1 = Vararg.buildList(5);
        System.out.println(numbers1);

        // Можно комбинировать!
        java.util.List<Integer> dynamic = Vararg.buildList(3);
        System.out.println(Vararg.sumVararg(dynamic.get(0), dynamic.get(1), dynamic.get(2)));
    }
}