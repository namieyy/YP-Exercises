import java.util.Objects;
import java.util.Scanner;

public class Exercise40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            double converted;

            System.out.print("Please enter temperature: ");
            String tempInput = scanner.next();
            double userenter = Double.parseDouble(tempInput);

            System.out.print("Please enter unit (C/P): ");
            String unit = scanner.next();

            if(Objects.equals(unit, "C")){
                converted = (9 / 5 * userenter) + 32;
                System.out.println("Temperature in Fahreinheit: " + converted);
            } else if (Objects.equals(unit, "F")) {
                converted = (userenter - 32) * 5 / 9;
                System.out.println("Temperature in Celsius: " + converted);
            } else{
                throw new IllegalArgumentException();
            }

        }
        catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a number.");
            }
        catch (IllegalArgumentException e){
            System.out.println("Invalid unit. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }

    }
}

