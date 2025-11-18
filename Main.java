public static int countLines(String fileName) {
    int count = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        while (br.readLine() != null) {
            count++;
        }
    } catch (IOException e) {
        System.out.println("Gabim gjatë leximit të file-it.");
    }

    return count;
}
