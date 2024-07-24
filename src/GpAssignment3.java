public class GpAssignment3 {
    public static void main(String[] args) {

    }
}

class Product{
    private String name;
    private double price;
    private int quantity;

    Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    void displayProduct(){
        System.out.println("Name: " + getName() +
                "\nPrice: RM" + getPrice() +
                "\nQuantity: " + getQuantity());
    }
}


