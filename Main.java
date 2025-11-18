import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public static void writeToFile() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Shkruaj tekstin që do të ruhet në file: ");
    String text = sc.nextLine();

    try {
        FileWriter writer = new FileWriter("data.txt");
        writer.write(text);
        writer.close();
        System.out.println("Teksti u ruajt me sukses në data.txt!");
    } catch (IOException e) {
        System.out.println("Gabim gjatë shkrimit në file.");
    }
}