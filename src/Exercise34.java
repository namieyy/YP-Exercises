import java.util.ArrayList;
import java.util.Scanner;

public class Exercise34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<String>();
        str.add("Black");
        str.add("Yellow");
        str.add("Blue");
        System.out.println("ArrayList for the Strings" + str);
        str.add(0,"Red");
        System.out.println("Added Red to the 1st.\nArrayList for the Strings" + str);

        ArrayList<Integer> num = new ArrayList<Integer>();
        System.out.print("Please input 1st integer: ");
        num.add(scanner.nextInt());
        System.out.print("Please input 2nd integer: ");
        num.add(scanner.nextInt());
        System.out.print("Please input 3rd integer: ");
        num.add(scanner.nextInt());
        System.out.println("ArrayList for the Integers" + num);
    }
}
