import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListUtils {
    static <T> List<T> filter(List<T> list, Condition<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (condition.check(item)) {
                result.add(item);
            }
        }
        return result;
    }

    interface Condition<T> {
        boolean check(T item);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = ListUtils.filter(numbers, item -> item % 2 == 0);

        System.out.println("Чётные числа: " + evenNumbers);
    }
}