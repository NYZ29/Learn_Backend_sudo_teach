class BooleanBasic {
    static void booleanBasic() {
        boolean isRaining = true;
        boolean isSuuny = false;
        boolean temperatureAboveZero = true;

        System.out.println("Идёт дождь: " + isRaining);
        System.out.println("Солнечно: " + isSuuny);
        System.out.println("Температура выше нуля: " + temperatureAboveZero);
    }
}


class BooleanVar {
    static void booleanVar() {
        var flag = true;
        var result = true;

        System.out.println("flag: " + flag);
        System.out.println("result: " + result);
    }
}


class ComparisonOperators {
    static void comparisonOperators() {
        int a = 10;
        int b = 20;

        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        String s1 = "Привет";
        String s2 = "Привет";
        String s3 = "Мир";

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println();
    }
}


class AndOperator {
    static void andOperator() {
        boolean sunny = true;
        boolean warm = true;
        boolean raining = false;

        boolean goSwimming = sunny && warm;
        boolean goHiking = sunny && !raining;

        System.out.println("Идти купаться: " + goSwimming);
        System.out.println("идти на прогулку: " + goHiking);

        int age = 25;
        boolean hasID = true;
        boolean canEnter = age >= 18 && hasID;

        System.out.println("Можно войти: " + canEnter);
    }
}


class OrOperator {
    static void orOperator() {
        boolean hasTicket = true;
        boolean hasVIP = false;
        boolean hasInvitation = true;

        boolean canEnter = hasTicket || hasVIP || hasInvitation;

        boolean isWeekend = true;
        boolean isHoliday = false;
        boolean dayOff = isWeekend || isHoliday;

        System.out.println("Можно войти: " + canEnter);
        System.out.println("Выходной: " + dayOff);

        int score = 85;
        boolean passed = score >= 60 || score >= 80;

        System.out.println("Экзамен сдан: " + passed);
    }
}


class NotOperator {
    static void notOperator() {
        boolean isDaytime = true;
        boolean isNighttime = !isDaytime;

        boolean isRaining = false;
        boolean isNotRaining = !isRaining;

        System.out.println("День: " + isDaytime);
        System.out.println("Ночь: " + isNighttime);
        System.out.println("Не дождь: " + isNotRaining);

        int age = 15;
        boolean isAdult = age >= 18;
        boolean isMinor = !isAdult;

        System.out.println("Совершеннолетний: " + isAdult);
        System.out.println("Несовершеннолетний: " + isMinor);
    }
}

class PriorityExample {
    static void priorityExample() {
        boolean a = true;
        boolean b = false;
        boolean c = true;

        boolean result1 = a || b && c;
        System.out.println("a || b && c: " + result1);

        boolean result2 = (a || b) && c;
        System.out.println("(a || b) && c: " + result2);

        boolean result3 = !a && b;
        System.out.println("!a && b: " + result3);

        boolean result4 = !(a && b);
        System.out.println("!(a && b): " + result4);
    }
}


class CompoundOperators {
    static void compoundOperators() {
        boolean a = true;
        boolean b = true;

        boolean xor = a ^ b;
        System.out.println("XOR (a ^ b): " + xor);

        boolean nand = !(a && b);
        System.out.println("NAND (!(a && b)): " + nand);

        boolean nor = !(a || b);
        System.out.println("NOR (!(a || b)): " + nor);
    }
}


class BooleanInConditions {
    static void booleanConditions() {
        int age = 20;
        boolean hasTicket = true;

        if (age >= 18 && hasTicket) {
            System.out.println("Добро пожаловать!");
        } else if (age >= 18) {
            System.out.println("Нужен билет");
        } else {
            System.out.println("Только для взрослых");
        }

        boolean isWeekend = true;
        boolean isHoliday = false;

        if (isWeekend || isHoliday) {
            System.out.println("Можно отдохнуть!");
        } else {
            System.out.println("Рабочий день");
        }

        if (!isHoliday) {
            System.out.println("Нужно работать");
        }
    }
}

class TernaryOperator {
    static void ternaryOperator() {
        int age = 25;
        String status = (age >= 18) ? "взрослый" : "ребёнок";
        System.out.println("Статус: " + status);

        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        System.out.println("Максимум: " + max);

        boolean isPositive = true;
        int value = isPositive ? 1 : -1;
        System.out.println("Значение: " + value);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        BooleanBasic.booleanBasic();

        System.out.println();
        BooleanVar.booleanVar();

        System.out.println();
        ComparisonOperators.comparisonOperators();

        System.out.println();
        AndOperator.andOperator();

        System.out.println();
        OrOperator.orOperator();

        System.out.println();
        NotOperator.notOperator();

        System.out.println();
        PriorityExample.priorityExample();

        System.out.println();
        CompoundOperators.compoundOperators();

        System.out.println();
        BooleanInConditions.booleanConditions();

        System.out.println();
        TernaryOperator.ternaryOperator();
    }
}
