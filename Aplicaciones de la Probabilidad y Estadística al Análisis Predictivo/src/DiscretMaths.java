public class DiscretMaths {
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la clase DiscretMaths
        int factorialResult = DiscretMaths.factorial(5);
        System.out.println("Factorial of 5: " + factorialResult);
    }
}
