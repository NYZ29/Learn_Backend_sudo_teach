/**
 * Вычисляет факториал числа n.
 * Факториал числа n – это произведение всех натуральных чисел от 1 до n включительно.
 */
class Factorial {
    /// @param n
    /// @return
    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int k = 10;
        System.out.println(Factorial.factorial(k));
    }
}
