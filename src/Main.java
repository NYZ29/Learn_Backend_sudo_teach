class Example {
    static void example() {
        int x = 10;
        if (x > 5) {
            System.out.println("Больше пяти");
            if (x > 8) {
                System.out.println("Больше восьми");
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Example.example();
    }
}
