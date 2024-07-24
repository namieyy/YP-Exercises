class Person44{
    String Fname;
    String Lname;

    Person44(String fname, String lname){
        this.Fname = fname;
        this.Lname = lname;
    }
    public String getFirstName(){
        return Fname;
    }

    public String getLastName(){
        return Lname;
    }
}

class Employee44 extends Person44{
    String EmployeeId;
    String JobTitle;

    Employee44(String fname, String lname, String EmployeeId, String jobTitle){
        super(fname, lname);
        this.EmployeeId = EmployeeId;
        this.JobTitle = jobTitle;
    }
    public  String getEmployeeId(){
        return EmployeeId;
    }

    public String getJobTitle(){
        return JobTitle;
    }

    @Override
    public String getLastName(){
        return Lname;
    }

    public void display(){
        System.out.println("Name: " + getFirstName() + " " + getLastName() +
                "\nID: " + getEmployeeId() +
                "\nJob Title: " + getJobTitle());
    }
}

public class Exercise44 {
    public static void main(String[] args) {

        Employee44 employee44 = new Employee44("Nazmi", "Ahmad", "S12032", "Programmer");
        employee44.display();
    }
}
