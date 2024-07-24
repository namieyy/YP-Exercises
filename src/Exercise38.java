class Person{
    String firstName;
    String lastName;

    Person(String firstName, String lastName){
        this.firstName = getFirstName(firstName);
        this.lastName = getLastName(lastName);
    }

    public String getFirstName(String firstName) {
        return firstName;
    }

    public String getLastName(String lastName) {
        return lastName;
    }
}

class Employee extends Person{
    String employeeId;

    Employee(String firstName, String lastName, String employeeId){
        super(firstName, lastName);
        this.employeeId = getEmployeeId(employeeId);
    }

    public String getEmployeeId(String employeeId) {
        return employeeId;
    }

    @Override
    public String getLastName(String lastName) {
        return lastName;
    }

    public void Display(){
        System.out.println("Employee ID: " + this.employeeId +
                "\nEmployee first name: " + this.firstName +
                "\nEmployee last name: " + this.lastName);
    }
}

public class Exercise38 {
    public static void main(String[] args) {

        Employee employee = new Employee("Nazmi", "Ahmad", "SE10101");
        employee.Display();

    }
}
