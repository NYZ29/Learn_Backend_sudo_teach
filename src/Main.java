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
    }
}
