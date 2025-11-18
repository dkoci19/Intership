public static void divide(int a, int b) {
    try {
        int result = a / b;
        System.out.println("Rezultati: " + result);
    } catch (ArithmeticException e) {
        System.out.println("Nuk mund të pjestosh me zero!");
    }
}