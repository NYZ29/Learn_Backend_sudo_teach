import java.math.BigDecimal;


class TemperatureConverter {
    static void temperatureConverter() {
        double celsius = 25.0;

        double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
        double kelvin = celsius + 273.15;

        System.out.println("=== Конвертер температуры ===");
        System.out.printf("Цельсий: %.1f°C%n", celsius);
        System.out.printf("Фаренгейт: %.1f°F%n", fahrenheit);
        System.out.printf("Кельвин: %.1f K%n", kelvin);

        System.out.println();
        System.out.println("--- Таблица ---");
        for (double c = -40; c <= 100; c += 20) {
            double f = c * 9.0 / 5.0 + 32.0;
            double k = c + 273.15;
            System.out.printf("%6.1f°C = %7.1f°F = %7.1f K%n", c, f, k);
        }
    }
}


class MathMethods {
    static void mathMethods() {
        double x = 2.7;

        System.out.println("abs(-5.5) = " + Math.abs(-5.5));
        System.out.println("ceil(2.3) = " + Math.ceil(2.3));
        System.out.println("floor(2.9) = " + Math.floor(2.9));
        System.out.println("round(2.5) = " + Math.round(2.5));
        System.out.println("max(3.14, 2.72) = " + Math.max(3.14, 2.72));
        System.out.println("min(3.14, 2.72) = " + Math.min(3.14, 2.72));

        System.out.println();
        System.out.println("sqrt(144) = " + Math.sqrt(144));
        System.out.println("pow(2, 10) = " + Math.pow(2, 10));
        System.out.println("PI = " + Math.PI);
        System.out.println("E = " + Math.E);

        System.out.println();
        System.out.println("log(2.718) = " + Math.log(Math.E));
        System.out.println("sin(PI/2) = " + Math.sin(Math.PI / 2));
    }
}


class GeometryCalculator {
    static void geometryCalculator() {
        double radius = 5.0;
        double height = 10.0;

        double circleArea = Math.PI * radius * radius;
        double cylinderVolume = circleArea * height;

        System.out.println("=== Геометрический калькулятор ===");
        System.out.printf("Радиус: %.1f%n", radius);
        System.out.printf("Высота: %.1f%n", height);
        System.out.printf("Площадь круга: %.4f%n", circleArea);
        System.out.printf("Объём цилиндра: %.4f%n", cylinderVolume);

        System.out.println();
        System.out.println("=== Квадратный корень ===");
        for (int i = 1; i <= 10; i++) {
            double power = Math.pow(2, i);
            System.out.printf("2^%d = %.0f%n", i, power);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        TemperatureConverter.temperatureConverter();

        System.out.println();
        MathMethods.mathMethods();

        System.out.println();
        GeometryCalculator.geometryCalculator();
    }
}