import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            // a) Lexon nje file
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            System.out.println("Përmbajtja e file-it:");
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

            // b) Merr një numër nga përdoruesi
            Scanner sc = new Scanner(System.in);
            System.out.print("Shkruaj një numër: ");
            int number = sc.nextInt();

            // c) Bën një operacion matematikor (p.sh. pjestim)
            int result = 100 / number;
            System.out.println("100 / " + number + " = " + result);
        }

        // d) Trajto gabimet
        catch (FileNotFoundException e) {
            System.out.println("Gabim: File nuk ekziston!");
        }
        catch (InputMismatchException e) {
            System.out.println("Gabim: Ke futur një input të pavlefshëm!");
        }
        catch (ArithmeticException e) {
            System.out.println("Gabim: Nuk mund të pjestosh me zero!");
        }
        catch (IOException e) {
            System.out.println("Gabim gjatë leximit të file-it.");
        }
    }
}