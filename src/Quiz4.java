import java.util.ArrayList;

public class Quiz4 {
    public static void main(String[] args) {
        System.out.printf("%d", 15);
        System.out.printf("%n");
        System.out.printf("%s", "hello");
        System.out.printf("%n");


        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        int sumEvenNum = 0;

        System.out.println("\n"+numbers);

        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) % 2 == 0){
                sumEvenNum += numbers.get(i);
            }

        }System.out.println("The sum of even number is " + sumEvenNum);

    }
}
