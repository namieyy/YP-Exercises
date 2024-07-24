import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Quiz3 {
    public static void main(String[] args) {
        /*1 -Write a program that shows current Date
        based on this format m/d/yyyy. */
        System.out.println("\n====== Question 1 ======");

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String str = sdf.format(new Date());

        System.out.println("\nCurrent date in mm-dd-yyyy: " + str);

        /*2- Write a program that reads the name, and age
         of a user from the keyboard, and display it in the console.*/
        System.out.println("\n====== Question 2 ======");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("\nName: " + name + "\nAge: " + age);

        /*3- Generate 10 random number using for loop using the Random class*/
        System.out.println("\n====== Question 3 ======\n");

        Random random = new Random();

        for (int i = 1; i < 11; i++){
            int rand = random.nextInt(50);
            System.out.println(i + " - " + rand);
        }
    }
}


