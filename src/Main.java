class DiscountCalculator {
    static void discountCalculator() {
        double price = 5_000;
        int age = 25;
        boolean isVIP = true;
        boolean isBirthday = false;
        int purchaseCount = 12;

        boolean isStudent = age >= 18 && age <= 25;
        boolean hasLoyalty = purchaseCount >= 10;

        double discount = 0;

        if (isVIP) {
            discount = 15;
        } else if (isStudent) {
            discount = 10;
        }

        if (isBirthday) {
            discount += 5;
        }

        if (hasLoyalty) {
            discount += 3;
        }

        discount = Math.min(discount, 30);

        double finalPrice = price * (1 - discount / 100);

        System.out.println("=== Калькулятор скидок ===");
        System.out.printf("Цена: %.2f руб.%n", price);
        System.out.println("VIP: " + isVIP);
        System.out.println("Студент: " + isStudent);
        System.out.println("День рождения: " + isBirthday);
        System.out.println("Постоянный клиент: " + hasLoyalty);
        System.out.printf("Скидка: %.0f%%%n", discount);
        System.out.printf("Итого: %.2f руб.%n", finalPrice);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();
        DiscountCalculator.discountCalculator();
    }
}
