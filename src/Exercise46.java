import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise46 {
    public static void main(String[] args) {
        try {
            File file = new File("src/file.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                try {
                    int i = Integer.parseInt(scanner.next());
                    System.out.println(i);
                }
                catch (NumberFormatException e){
                    System.out.println("Not a number.");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
