import java.util.Scanner;

class Coffee{
    int coffeeType;
    int sugarLevel;

    Coffee(){
    }

    Coffee(int type, int sugar){
        this.coffeeType = type;
        this.sugarLevel = sugar;
    }

    public int getCoffeeType() {
        return coffeeType;
    }

    public int getSugarLevel() {
        return sugarLevel;
    }

}

class Topping extends Coffee {
    int firstTopping;
    int secondTopping;

    Topping() {
    }

    Topping(int type, int sugar) {
        super(type, sugar);
    }

    Topping(int type, int sugar, int top1) {
        super(type, sugar);
        this.firstTopping = top1;
    }

    Topping(int type, int sugar, int top1, int top2) {
        super(type, sugar);
        this.firstTopping = top1;
        this.secondTopping = top2;
    }

    public int getFirstTopping() {
        return firstTopping;
    }

    public int getSecondTopping() {
        return secondTopping;
    }

    public void viewMenu() {
        System.out.println("\nCoffee type:" +
                "\nAmericano --> RM7.50" +
                "\nLatte --> RM8.90" +
                "\n\nSugar level:" +
                "\nLess --> (-)RM1.50" +
                "\nExtra --> (+)RM1.50" +
                "\n\nTopping:" +
                "\nRainbowchip --> (+)RM1.00" +
                "\nOreo --> (+)RM1.20\n");
    }

    public void Price() {
        double coffeePrice = 0;
        double sugarPrice = 0;
        double topping1Price = 0;
        double topping2Price = 0;

        System.out.println("\n--Your Order--");

        switch (getCoffeeType()) {
            case 1: //Americano
                coffeePrice = 7.50;
                System.out.println("Americano: " + coffeePrice);
                break;
            case 2: //Latte
                coffeePrice = 8.90;
                System.out.println("Latte: " + coffeePrice);
                break;
            default:
                //throw exception
                break;
        }

        switch (getSugarLevel()) {
            case 1: //Less Sugar
                sugarPrice = -1.50;
                System.out.println("Less sugar: " + sugarPrice);
                break;
            case 2: //Normal level
                sugarPrice = 0;
                System.out.println("Normal sugar: " + sugarPrice);
                break;
            case 3: //Extra Sugar
                sugarPrice = 1.50;
                System.out.println("Extra sugar: " + sugarPrice);
                break;
            default:
                //throw exception
                break;
        }

        switch (getFirstTopping()) {
            case 1: //Rainbow chip
                topping1Price = 1;
                System.out.println("Rainbow chip: " + topping1Price);
                break;
            case 2: //Oreo
                topping1Price = 1.2;
                System.out.println("Oreo: " + topping1Price);
                break;
            default:
                //throw exception
                break;
        }

        switch (getSecondTopping()) {
            case 1: //Rainbow chip
                topping2Price = 1;
                System.out.println("Rainbow chip: " + topping2Price);
                break;
            case 2: //Oreo
                topping2Price = 1.2;
                System.out.println("Oreo: " + topping2Price);
                break;
            default:
                //throw exception
                break;
        }

        double totalPrice = coffeePrice + sugarPrice + topping1Price + topping2Price;

        double tax = 0.06 * totalPrice;

        double includeTax = totalPrice + tax;

        System.out.println("\nPrice: " + totalPrice +
                "\nTax: " + tax +
                "\nTotal Price: " + includeTax);
    }
}

public class Exercise47 {
    public static void main(String[] args) {
        Topping topping = new Topping();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Welcome to 47 Coffee Station ===");
        topping.viewMenu();

        try {
            int coffee;
            int sugar;
            int topping1;
            int topping2 = 0;


            //Coffee type block
            do{
                System.out.print("Select type: (1) Americano | (2) Latte | (3) Exit: ");
                String tempInput = scanner.nextLine();
                coffee = Integer.parseInt(tempInput);

                if(coffee < 1 || coffee > 3){
                    System.out.println("Invalid input.");
                }else if (coffee == 3){
                    throw new IllegalArgumentException();
                }

            }while(coffee < 1 || coffee > 3);

            //Sugar level block
            do {
                System.out.print("Select sugar level: (1) Less Sugar | (2) Normal | (3) Extra Sugar | (4) Exit: ");
                String tempInput = scanner.nextLine();
                sugar = Integer.parseInt(tempInput);

                if(sugar < 1 || sugar > 4){
                    System.out.println("Invalid input.");
                } else if (sugar == 4) {
                    throw new IllegalArgumentException();
                }

            }while (sugar < 1 || sugar > 4);

            //Topping 1 & 2 block
            do {
                System.out.print("1st Topping: (0) No Topping | (1) Rainbow chip | (2) Oreo | (3) Exit: ");
                String tempInput = scanner.nextLine();
                topping1 = Integer.parseInt(tempInput);

                if(topping1 == 3){
                    throw new IllegalArgumentException();
                } else if(topping1 >= 1 && topping1 <3){
                    do {
                        System.out.print("2nd Topping: (0) No Topping | (1) Rainbow chip | (2) Oreo | (3) Exit: ");
                        String tempInput1 = scanner.nextLine();
                        topping2 = Integer.parseInt(tempInput1);

                        if(topping2 < 0 || topping2 > 3){
                            System.out.println("Invalid input.");
                        }else if (topping2 == 3) {
                            throw new IllegalArgumentException();
                        }
                    }while (topping2 < 0 || topping2 > 3);
                } else if (topping1 < 0 || topping1 > 3) {
                    System.out.println("Invalid input.");
                }
            }while (topping1 < 0 || topping1 > 3);

            if(topping2 > 0){
                Topping topping4arg = new Topping(coffee, sugar, topping1, topping2);
                topping4arg.Price();
            } else if (topping2 <= 0 && topping1 > 0) {
                Topping topping3arg = new Topping(coffee, sugar, topping1);
                topping3arg.Price();
            } else {
                Topping topping2arg = new Topping(coffee, sugar);
                topping2arg.Price();
            }

        }

        catch (NumberFormatException e){
            System.out.println("\nInvalid input. Please enter a number. Please restart again.");
        }

        catch (IllegalArgumentException e){
            System.out.println("\nThank you for using 47 Coffee Station.");
        }
    }
}