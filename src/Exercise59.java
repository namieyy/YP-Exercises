import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise59 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int positiveInput = -1;

        while (positiveInput < 0){
            System.out.print("Enter an age: ");
            String temp = scanner.next();
            try {
                positiveInput = Integer.parseInt(temp);
                if (positiveInput < 0){
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e){
                System.err.println("Error. Age must be positive number.");
            }
        }
        System.out.println("\nAwesome!");
    }
}
