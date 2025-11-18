import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public static void readFile() {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    } catch (IOException e) {
        System.out.println("Gabim gjatë leximit të file-it.");
    }
}