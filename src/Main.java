import java.math.BigDecimal;


class FloatExample {
    static void floatExample() {
        float price = 9.99F;
        float temperature = -36.6F;
        float pi = 3.14159F;
        float gravity = 9.8F;
        float distance = 150_000_000F;

        System.out.println("Цена: " + price);
        System.out.println("Температура: " + temperature);
        System.out.println("Число Пи: " + pi);
        System.out.println("Гравитация: " + gravity);
        System.out.println("Расстояние от Земли до Солнца (км): " + distance);
    }
}


class DoubleExample {
    static void doubleExample() {
        double pi = 3.14159265358973;
        double e = 2.718281828459045;
        double speedOfLight = 299_792_458.0;
        double avogadro = 6.0221407e23;

        System.out.println("Число Пи: " + pi);
        System.out.println("Число Эйлера: " + e);
        System.out.println("Скорость света (м/с): " + speedOfLight);
        System.out.println("Число Авогадро: " + avogadro);
    }
}


class ScientificNotation {
    static void scientificNotation() {
        double lightYear = 9.461e15;
        double atomSize = 1.0e-10;
        double electronMass = 9.109e-31;
        double sunMass = 1.989e30;

        System.out.println("Световой год (м): " + lightYear);
        System.out.println("Размер атома (м): " + atomSize);
        System.out.println("Масса электрона (кг): " + electronMass);
        System.out.println("Масса Солнца (кг): " + sunMass);
    }
}


class PrecisionProblem {
    static void precisionProblem() {
        double a = 0.1;
        double b = 0.2;
        double sum = a + b;

        System.out.println("0.1 + 0.2 = " + sum);
        System.out.println("Равно ли 0.3? " + (sum == 0.3));

        float f1 = 0.1F;
        float f2 = 0.2F;
        float fsum = f1 + f2;

        System.out.println("float: 0.1 + 0.2 = " + fsum);
    }
}


class SafeComparison {
    static void safeComparison() {
        double a = 0.1 + 0.2;
        double b = 0.3;
        double epsilon = 1e-10;

        boolean isEqual = Math.abs(a - b) < epsilon;
        System.out.println("Безопасное сравнение: " + isEqual);

        System.out.println("Небезопасное сравнение: " + (a == b));
    }
}


class DoubleConstants {
    static void doubleConstants() {
        System.out.println("MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("MIN_VALUE: " + Double.MIN_VALUE);
        System.out.println("POSITIVE_INFINITY: " + Double.POSITIVE_INFINITY);
        System.out.println("NEGATIVE_INFINITY: " + Double.NEGATIVE_INFINITY);
        System.out.println("NaN: " + Double.NaN);

        System.out.println("Epsilon: " + Double.MIN_VALUE);
        System.out.println("True epsilon: " + Math.ulp(1.0));
    }
}


class BigDecimalExample {
    static void bigDecimalExample() {
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        BigDecimal sum = a.add(b);
        BigDecimal expected = new BigDecimal("0.3");

        System.out.println("BigDecimal: 0.1 + 0.2 = " + sum);
        System.out.println("Равно ли 0.3? " + sum.equals(expected));

        System.out.println();
        System.out.println("double: 0.1 + 0.2 = " + (0.1 + 0.2));
        System.out.println("Равно ли 0.3? " + ((0.1 + 0.2) == 0.3));

        BigDecimal price1 = new BigDecimal("19.99");
        BigDecimal price2 = new BigDecimal("29.99");
        BigDecimal total = price1.add(price2);
        System.out.println();
        System.out.println("Итого: " + total);
    }
}


class BigDecimalCreation {
    static void bigDecimalCreation() {
        BigDecimal good = new BigDecimal("0.1");
        BigDecimal bad = new BigDecimal(0.1);

        System.out.println("Из строки: " + good);
        System.out.println("Из double: " + bad);

        BigDecimal precise = BigDecimal.valueOf(0.1);
        System.out.println("valueof: " + precise);
    }
}


class TypeConversion {
    static void typeConversion() {
        int i = 100;
        double d = i;
        System.out.println("int → double: " + d);

        double pi = 3.14159;
        int truncated = (int) pi;
        System.out.println("double → int (сужение): " + truncated);

        float f = 3.14F;
        double promoted = f;
        System.out.println("float → double: " + promoted);

        long big = 1_000_000L;
        float fromLong = big;
        System.out.println("long → float: " + fromLong);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        FloatExample.floatExample();

        System.out.println();
        DoubleExample.doubleExample();

        System.out.println();
        ScientificNotation.scientificNotation();

        System.out.println();
        PrecisionProblem.precisionProblem();

        System.out.println();
        SafeComparison.safeComparison();

        System.out.println();
        DoubleConstants.doubleConstants();

        System.out.println();
        BigDecimalExample.bigDecimalExample();

        System.out.println();
        BigDecimalCreation.bigDecimalCreation();

        System.out.println();
        TypeConversion.typeConversion();
    }
}