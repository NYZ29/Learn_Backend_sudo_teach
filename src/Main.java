class CharExample {
    static void charExample() {
        char letter = 'A';
        char digit = '7';
        char symbol = '@';
        char space = ' ';
        char russian = 'Я';
        char emoji = '😀';

        System.out.println("Буква: " + letter);
        System.out.println("Цифра: " + digit);
        System.out.println("Символ: " + symbol);
        System.out.println("Пробел: [" + space + "]");
        System.out.println("Русская буква: " + russian);
        System.out.println("Эмодзи: " + emoji);
    }
}


class UnicodeExample {
    static void unicodeExample() {
        char latinA = 'A';
        char cyrillicA = 'А';
        char greekA = 'Α';
        char arabicA = 'أ';
        char chineseChar = '中';
        char yenSign = '¥';
        char copyrightSign = '©';

        System.out.println("Латинская А: " + latinA + " = " + (int) latinA);
        System.out.println("Кириллическая A: " + cyrillicA + " = " + (int) cyrillicA);
        System.out.println("Греческая A: " + greekA + " = " + (int) greekA);
        System.out.println("Арабская أ: " + arabicA + " = " + (int) arabicA);
        System.out.println("Китайский иероглиф: " + chineseChar + " = " + (int) chineseChar);
        System.out.println("Знак yen: " + yenSign + " = " + (int) yenSign);
        System.out.println("Знак копирайта: " + copyrightSign + " = " + (int) copyrightSign);
    }
}


class StringExample {
    static void stringExample() {
        String greeting = "Привет, мир!";
        String empty = "";
        String name = "Александр";
        String withNumber = "Мне 25 лет";
        String withSpecial = "Цена: $9.99";
        String multiLine = "Это\nстрока\nс\nпереводами\nстрок";

        System.out.println(greeting);
        System.out.println("Имя: " + name);
        System.out.println(withNumber);
        System.out.println(withSpecial);
        System.out.println(multiLine);
    }
}


class TextBlockExample {
    static void textBlockExample() {
        String html = """
                <html>
                    <body>
                        <p>Привет, мир!</p>
                    </body>
                </html>
                """;

        String sql = """
                SELECT *
                FROM users
                WHERE age > 18
                ORDER BY name;
                """;

        System.out.println(html);
        System.out.println(sql);
    }
}


class ConcatenationExample {
    static void concatenationExample() {
        String firstName = "Иван";
        String lastName = "Петров";
        String fullName = firstName + " " + lastName;

        System.out.println("Полное имя: " + fullName);

        int age = 25;
        String info = "Мне " + age + " лет";
        System.out.println(info);

        String result = "1" + 2 + 3;
        String result2 = 1 + 2 + "3";

        System.out.println("\"1\" + 2 + 3 = " + result);
        System.out.println("1 + 2 + \"3\" = " + result2);
    }
}


class StringComparison {
    static void stringComparison() {
        String s1 = "Привет";
        String s2 = "Привет";
        String s3 = new String("Привет");

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
    }
}


class StringMethods {
    static void stringMethods() {
        String text = "Привет, Мир!";

        System.out.println("Длина: " + text.length());
        System.out.println("Буква[0]: " + text.charAt(0));
        System.out.println("Подстрока: " + text.substring(8));
        System.out.println("Подстрока 0-5: " + text.substring(0, 6));
        System.out.println("В верхнем регистре: " + text.toUpperCase());
        System.out.println("В нижнем регистре: " + text.toLowerCase());
        System.out.println("Содержит 'Мир'? " + text.contains("Мир"));
        System.out.println("Начинается с 'Привет'? " + text.startsWith("Привет"));
        System.out.println("Заканчивается на '!'? " + text.endsWith("!"));
        System.out.println("Индекс 'Мир': " + text.indexOf("Мир"));
        System.out.println("Замена: " + text.replace("Мир", "Java"));
        System.out.println("Убрать пробелы: [" + "  Привет  ".trim() + "]");
    }
}


class ImmutabilityExample {
    static void immutabilityExample() {
        String original = "Привет";
        String upper = original.toUpperCase();
        String replaced = original.replace("и", "И");

        System.out.println("оригинал: " + original);
        System.out.println("Верхний регистр: " + upper);
        System.out.println("После замены: " + replaced);
    }
}


class StringBuilderExample {
    static void stringBuilderExample() {
        StringBuilder sb = new StringBuilder();
        sb.append("Привет");
        sb.append(", ");
        sb.append("мир");
        sb.append("!");
        String result = sb.toString();

        System.out.println(result);

        StringBuilder reversed = new StringBuilder("Java");
        reversed.reverse();
        System.out.println("Наоборот: " + reversed);

        StringBuilder builder = new StringBuilder("Привет");
        builder.insert(6, ", мир");
        System.out.println("Вставка: " + builder);

        StringBuilder deleter = new StringBuilder("Удалить этот текст");
        deleter.delete(8, 12);
        System.out.println("Удаление: " + deleter);
    }
}


class FormatExample {
    static void formatExample() {
        String name = "Александр";
        int age = 30;
        double salary = 75_000.50;

        System.out.printf("Имя: %s, Возраст: %d%n", name, age);
        System.out.printf("Зарплата: %,.2f руб.%n", salary);

        String formatted = String.format(
                "%-10s | %5d | %10.2f",
                name, age, salary
        );
        System.out.println(formatted);

        System.out.printf("Число Пи: %.10f%n", Math.PI);
        System.out.printf("В двоичной: %s%n", Integer.toBinaryString(42));
    }
}


class GreetingGenerator {
    static void greetingGenerator() {
        String name = "Мария";
        int hour = 14;

        String greeting;
        if (hour < 6) {
            greeting = "Доброй ночи";
        } else if (hour < 12) {
            greeting = "Доброе утро";
        } else if (hour < 18) {
            greeting = "Добрый день";
        } else {
            greeting = "Добрый вечер";
        }

        String message = greeting + ", " + name + "!";
        System.out.println(message);

        String upperName = name.toUpperCase();
        String reversed = new StringBuilder(name).reverse().toString();

        System.out.println("Имя верхним регистром: " + upperName);
        System.out.println("Имя наоборот: " + reversed);
        System.out.println("Длина имени: " + name.length() + " символов");

        String padded = String.format("[%20s]", name);
        System.out.println("С выравниванием: " + padded);
    }
}


class CharConversion {
    static void charConversion() {
        char ch = 'A';
        int code = ch;
        System.out.println("Символ: " + ch + ", Код: " + code);

        char fromInt = (char) 97;
        System.out.println("Код 97: " + fromInt);

        char[] chars = {'J', 'a', 'v', 'a'};
        String word = new String(chars);
        System.out.println("Из массива: " + word);

        String str = "Hello";
        char[] array = str.toCharArray();
        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        CharExample.charExample();

        System.out.println();
        UnicodeExample.unicodeExample();

        System.out.println();
        StringExample.stringExample();

        System.out.println();
        TextBlockExample.textBlockExample();

        System.out.println();
        ConcatenationExample.concatenationExample();

        System.out.println();
        StringComparison.stringComparison();

        System.out.println();
        StringMethods.stringMethods();

        System.out.println();
        ImmutabilityExample.immutabilityExample();

        System.out.println();
        StringBuilderExample.stringBuilderExample();

        System.out.println();
        FormatExample.formatExample();

        System.out.println();
        GreetingGenerator.greetingGenerator();

        System.out.println();
        CharConversion.charConversion();
    }
}
