class IntegerTypesOverview {
    static void integerTypesOverview() {
        byte smallNumber = 42;
        short mediumNumber = 1_000;
        int bigNumber = 1_000_000;
        long hugeNumber = 1_000_000_000L;

        System.out.println("=== Все типы ===");
        System.out.println("byte: " + smallNumber + " (от -128 до 127)");
        System.out.println("short: " + mediumNumber + " (от -32768 до 32767)");
        System.out.println("int: " + bigNumber + " (от -2.1 млрд до 2.1 млрд)");
        System.out.println("long: " + hugeNumber + " (огромный диапазон)");

        System.out.println();
        System.out.println("=== Системы счисления ===");
        int decimal = 255;
        int hex = 0xFF;
        int octal = 0377;
        int binary = 0b1111_1111;

        System.out.println("Десятичная: " + decimal);
        System.out.println("Шестнадцатеричная: " + hex);
        System.out.println("Восьмеричная: " + octal);
        System.out.println("Двоичная: " + binary);

        System.out.println();
        System.out.println("=== Разделители разрядов ===");
        int withSeparator = 1_234_567_890;
        long bigWithSeparator = 9_223_372_036_854_775_807L;
        System.out.println("С разделителем: " + withSeparator);
        System.out.println("Большое число: " + bigWithSeparator);

        System.out.println();
        System.out.println("=== Автоматическое расширение ===");
        byte b = 10;
        short s = b;
        int i = s;
        long l = i;
        System.out.println("byte → short → int → long: " + l);

        System.out.println();
        System.out.println("=== Переполнение ===");
        int max = Integer.MAX_VALUE;
        System.out.println("MAX_VALUE: " + max);
        System.out.println("MAX_VALUE + 1: " + (max + 1));
    }
}


class WrapperExample {
    static void wrapperExample() {
        System.out.println("Максимум int: " + Integer.MAX_VALUE);
        System.out.println("Минимум int: " + Integer.MIN_VALUE);
        System.out.println("Максимум long: " + Long.MAX_VALUE);
        System.out.println("Минимум long: " + Long.MIN_VALUE);

        int parsed = Integer.parseInt("12345");
        System.out.println("Из строки: " + parsed);

        String hexString = Integer.toHexString(255);
        System.out.println("255 в hex: " + hexString);

        String binaryString = Integer.toBinaryString(42);
        System.out.println("42 в двоичной: " + binaryString);

        int compared = Integer.compare(10, 20);
        System.out.println("Сравнение 10 и 20: " + compared);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        IntegerTypesOverview.integerTypesOverview();

        System.out.println();
        WrapperExample.wrapperExample();
    }
}