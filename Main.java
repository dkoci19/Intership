public static void validateNumber(int number) {
    if (number < 20) {
        throw new IllegalArgumentException("Numri duhet të jetë të paktën 20!");
    }
}