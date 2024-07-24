class Vehicle {
    String make;
    String model;
    int year;
    double rentalPricePerDay;

    public Vehicle(String make, String model, int year, double rent) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPricePerDay = rent;
    }

    public String getMake(String make) {
        return this.make;
    }

    public String getModel(String model) {
        return this.model;
    }

    public int getYear(int year) {
        return this.year;
    }

    public double getRentalPricePerDay(double rent) {
        return rentalPricePerDay;
    }

    public double calculateRentalCost(double rent, int day){
        return rent * day;
    }
}

class Car extends Vehicle{
    int numSeats;
    int numDoors;
    int day;

    public Car (int numSeats, int numDoors, int day, String make, String model, int year, double rent){
        super(make, model, year, rent);
        this.numSeats = numSeats;
        this.numDoors = numDoors;
        this.day = day;
    }

    public void CarInfo(){
        System.out.println("\nMake: " + getMake(make) +
                "\nModel: " + getModel(model) +
                "\nYear: " + getYear(year) +
                "\nRental Price Per Day: RM" + getRentalPricePerDay(rentalPricePerDay) +
                "\nNumber of Seats: " + numSeats +
                "\nNumber of Doors: " + numDoors +
                "\n\nTotal Cost for " + day +" day(s): " + calculateRentalCost(rentalPricePerDay,day));
    }
}

class Motorcycle extends Vehicle {
    int engineSize;
    int day;

    public Motorcycle (int engineSize, int day, String make, String model, int year, double rent){
        super(make, model, year, rent);
        this.engineSize = engineSize;
        this.day = day;
    }

    public void MotorcycleInfo(){
        System.out.println("\nMake: " + getMake(make) +
                "\nModel: " + getModel(model) +
                "\nYear: " + getYear(year) +
                "\nRental Price Per Day: RM" + getRentalPricePerDay(rentalPricePerDay) +
                "\nEngine Size: " + engineSize + "CC" +
                "\n\nTotal Cost for " + day +" day(s): " + calculateRentalCost(rentalPricePerDay,day));
    }
}

public class Exercise31 {
    public static void main(String[] args) {
        Motorcycle motorcycle = new Motorcycle(998, 2,"Kawasaki", "H2R", 2022, 150);
        Car car = new Car(4, 4, 3, "Perodua", "Myvi", 2024, 180);

        car.CarInfo();
        motorcycle.MotorcycleInfo();
    }
}