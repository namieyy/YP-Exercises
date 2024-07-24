import java.util.ArrayList;
import java.util.Scanner;

public class Exercise62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integers separated by spaces: ");
        String temp = scanner.nextLine();
        String[] arrTemp = temp.split(" ");

        ArrayList<Integer> num = new ArrayList<>();

        for (int i = 0; i < arrTemp.length; i++){
            num.add(i,Integer.parseInt(arrTemp[i]));
        }

        int sum = 0;
        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;
        for (int i = 0; i < num.size(); i++){
            sum = sum + num.get(i);

            if (num.get(i) > Max) Max = num.get(i);

            if (num.get(i) < Min) Min = num.get(i);
        }

        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + Max);
        System.out.println("Minimum: " + Min);
    }
}
