class Calculator{
    int a;
    int b;

    Calculator(){
        this.a = 0;
        this.b = 0;
    }

    public int Add(int a, int b){
        int c;
        return c = a + b;
    }

    public double Add(double a, double b){
        double c;
        return c = a + b;
    }
}

public class Example {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int SumInt = calculator.Add(6,8);
        double SumDouble = calculator.Add(8, 4.5);

        System.out.println("Sum of the both integers is " + SumInt);
        System.out.println("Sum of the both decimals is " + SumDouble);
    }
}