class ByteExample {
    static void byteExample() {
        byte temperature = -10;
        byte age = 25;
        byte score = 127;

        System.out.println("Температура: " + temperature);
        System.out.println("Возраст: " + age);
        System.out.println("Рекорд: " + score);
    }
}


class ShortExample {
    static void shortExample() {
        short maxHeight = 8848;
        short population = 32000;
        short year = 2026;

        System.out.println("Высота Эвереста: " + maxHeight + " м");
        System.out.println("Население города: " + population);
        System.out.println("Текущий год: " + year);
    }
}


class IntExample {
    static void intExample() {
        // Ошибка sudo teach
        long worldPopulation = 8_000_000_000L;
        int secondsInMonth = 86_400 * 31;
        int distanceToMoonInMM = 384_400_000;

        System.out.println("Население мира: " + worldPopulation);
        System.out.println("Секунд в месяце: " + secondsInMonth);
        System.out.println("Расстояние до Луны (мм): " + distanceToMoonInMM);
    }
}


class LongExample {
    static void longExample() {
        long worldPopulation = 8_000_000_000L;
        long secondsInYear = 31_536_000L;
        long starsInGalaxy = 100_000_000_000L;
        long distanceInLightYears = 9_461_000_000_000_000L;

        System.out.println("Население мира: " + worldPopulation);
        System.out.println("Секунд в году: " + secondsInYear);
        System.out.println("Звёзд в галактике: " + starsInGalaxy);
        System.out.println("Расстояние в световых годах: " + distanceInLightYears);
    }
}


class HexExample {
    static void hexExample() {
        int hex1 = 0xFF;
        int hex2 = 0x1A;
        long hex3 = 0xDEAD_BEEFL;

        System.out.println("0xFF = " + hex1);
        System.out.println("0x1A = " + hex2);
        System.out.println("0xDEAD_BEEF = " + hex3);
    }
}


class OctalExample {
    static void octalExample() {
        int oct1 = 010;
        int oct2 = 077;
        int oct3 = 0100;

        System.out.println("010 = " + oct1);
        System.out.println("077 = " + oct2);
        System.out.println("0100 = " + oct3);
    }
}


class BinaryExample {
    static void binaryExample() {
        int bin1 = 0b1010;
        int bin2 = 0b1111_1111;
        int bin3 = 0b1000_0000;

        System.out.println("0b1010 = " + bin1);
        System.out.println("0b11111111 = " + bin2);
        System.out.println("0b10000000 = " + bin3);
    }
}


class SeparatorExample {
    static void separatorExample() {
        int million = 1_000_000;
        long billion = 1_000_000_000L;
        int hexColor = 0xFF_DD_00;
        long binary = 0x1010_1100_1111_0000L;

        System.out.println("Миллион: " + million);
        System.out.println("Миллиард: " + billion);
        System.out.println("Цвет: " + hexColor);
        System.out.println("Двоичное: " + binary);
    }
}


class OverflowExample {
    static void overflowExample() {
        int maxInt = 2_147_483_647;
        System.out.println("Максимум int: " + maxInt);
        System.out.println("Макисимум + 1: " + (maxInt + 1));

        int minInt = -2_147_483_648;
        System.out.println("Минимум int: " + minInt);
        System.out.println("Минимум - 1: " + (minInt - 1));

        byte maxByte = 127;
        System.out.println("Максимум byte: " + maxByte);
        System.out.println("Максимум + 1: " + (maxByte + 1));
    }
}


class Year2038Problem {
    static void year2038Problem() {
        int maxUnitTimestamp = 2_147_483_647;
        System.out.println("Максимальная дата Unix (int): " + maxUnitTimestamp);

        long safeTimestamp = 2_147_483_647L + 1;
        System.out.println("Следующая секунда (long): " + safeTimestamp);
    }
}


class WideningExample {
    static void wideningExample() {
        byte b = 42;
        short s = b;
        int i = s;
        long l = i;

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);

        long bigNumber = 100L;
        int smallNumber = (int) bigNumber;
        System.out.println("Приведение long к int: " + smallNumber);
    }
}


class PromotionExample {
    static void promotionExample() {
        byte a = 10;
        int b = 20;
        long c = 30L;

        int result1 = a + b;
        long result2 = a + c;
        long result3 = a + b + c;

        System.out.println("byte + int = " + result1);
        System.out.println("byte + long = " + result2);
        System.out.println("byte + int + long = " + result3);
    }
}


class AgeCalculator {
    static void ageCalculator() {
        byte ageYears = 25;
        short daysInYear = 365;
        int totalDays = ageYears * daysInYear;
        long totalSeconds = totalDays * 24L * 60 * 60;

        System.out.println("Возраст: " + ageYears + " лет");
        System.out.println("Примерно " + totalDays + " дней");
        System.out.println("Примерно " + totalSeconds + " секунд жизни");
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        ByteExample.byteExample();

        System.out.println();
        ShortExample.shortExample();

        System.out.println();
        IntExample.intExample();

        System.out.println();
        LongExample.longExample();

        System.out.println();
        HexExample.hexExample();

        System.out.println();
        OctalExample.octalExample();

        System.out.println();
        BinaryExample.binaryExample();

        System.out.println();
        SeparatorExample.separatorExample();

        System.out.println();
        OverflowExample.overflowExample();

        System.out.println();
        Year2038Problem.year2038Problem();

        System.out.println();
        WideningExample.wideningExample();

        System.out.println();
        PromotionExample.promotionExample();

        System.out.println();
        AgeCalculator.ageCalculator();
    }
}
