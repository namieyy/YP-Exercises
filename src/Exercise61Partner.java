import java.util.ArrayList;
import java.util.Scanner;

class Course{
    private String courseId;
    private String courseName;
    private String instructor;
    private int duration;
    private double price;

    Course(String courseId,String courseName, String instructor, int duration, double price){
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.duration = duration;
        this.price = price;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    void displayCourseDetails(){
        System.out.println("Course ID: " + getCourseId() +
                "\nName: " + getCourseName() +
                "\nInstructor: " + getInstructor() +
                "\nDuration: " + getDuration() +
                "\nPrice: " + getPrice());
    }
}

class ProgrammingCourse extends Course{
    private String programmingLanguage;
    private String difficultyLevel;

    ProgrammingCourse(String courseId,String courseName, String instructor, int duration,
                      double price, String programmingLanguage, String difficultyLevel){
        super(courseId, courseName, instructor, duration, price);
        this.programmingLanguage = programmingLanguage;
        this.difficultyLevel = difficultyLevel;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    void displayCourseDetails(){
        System.out.println("Course ID: " + getCourseId() +
                "\nName: " + getCourseName() +
                "\nInstructor: " + getInstructor() +
                "\nDuration: " + getDuration() +
                "\nPrice: " + getPrice() +
                "\nProgramming Language: " + getProgrammingLanguage() +
                "\nDifficulty Level: " + getDifficultyLevel());
    }
}

class LanguageCourse extends Course{
    private String language;
    private String level;

    LanguageCourse(String courseId,String courseName, String instructor, int duration,
                   double price, String language, String level){
        super(courseId, courseName, instructor, duration, price);
        this.language = language;
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public String getLevel() {
        return level;
    }

    void displayCourseDetails(){
        System.out.println("Course ID: " + getCourseId() +
                "\nName: " + getCourseName() +
                "\nInstructor: " + getInstructor() +
                "\nDuration: " + getDuration() +
                "\nPrice: " + getPrice() +
                "\nLanguage: " + getLanguage() +
                "\nLevel: " + getLevel());
    }
}

public class Exercise61Partner {
    public ArrayList<Course> course = new ArrayList<>();

    void AddLangCourse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAdd a language course");
        System.out.print("Course ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Instructor: ");
        String instructor = scanner.nextLine();
        System.out.print("Duration: ");
        int duration = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Language: ");
        String language = scanner.nextLine();
        System.out.print("Level: ");
        String level = scanner.nextLine();

        LanguageCourse languageCourse =
                new LanguageCourse(id,name,instructor,duration,price,language,level);

        course.add(languageCourse);
    }

    public void addProgCourse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAdd a programming course");
        System.out.print("Course ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Instructor: ");
        String instructor = scanner.nextLine();
        System.out.print("Duration: ");
        int duration = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Programming Language: ");
        String language = scanner.nextLine();
        System.out.print("Difficulty Level: ");
        String level = scanner.nextLine();

        ProgrammingCourse programmingCourse =
                new ProgrammingCourse(id,name,instructor,duration,price,language,level);
        course.add(programmingCourse);
    }

    public void deleteCourse(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter which course to remove(int): ");
        int toDelete = scanner.nextInt();
        course.remove(toDelete-1);
    }

    public void displayAllCourses(){
        if(course.isEmpty()){
            System.out.println("\nNo course available.");
        }
        int i = 1;
        for(Course course : course){
            System.out.println("\n(" + i + ")");
            i++;
            course.displayCourseDetails();
        }
    }

    public void displayProgrammingCourses() {
        System.out.println("\nProgramming Courses:");
        int count = 0;
        for (Course course : course) {
            if (course instanceof ProgrammingCourse)count++;
        }
        if(count == 0) System.out.println("No Programming course available");
        for (Course course : course) {
            if (course instanceof ProgrammingCourse) {
                System.out.println();
                course.displayCourseDetails();
            }
        }
    }

    public void displayLanguageCourses() {
        System.out.println("\nLanguage Courses:");
        int count = 0;
        for (Course course : course) {
            if (course instanceof LanguageCourse)count++;
        }
        if(count == 0) System.out.println("No Language course available");
        for (Course course : course) {
            if (course instanceof LanguageCourse) {
                System.out.println();
                course.displayCourseDetails();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Exercise61Partner test = new Exercise61Partner();

        int mainMenu = 1;
        System.out.println("\n=========== Welcome to Course Portal ===========");

        while (mainMenu > 0){
            System.out.println("\n1 - View All Courses" +
                    "\n2 - View Programming Courses" +
                    "\n3 - View Language Courses" +
                    "\n4 - Add Programming Course" +
                    "\n5 - Add Language Course" +
                    "\n6 - Delete Course" +
                    "\n0 - Exit");

            System.out.print("\nEnter your choice: ");
            mainMenu = scanner.nextInt();

            switch (mainMenu){

                case 0:
                    break;

                case 1:
                    test.displayAllCourses();
                    break;
                case 2:
                    test.displayProgrammingCourses();
                    break;
                case 3:
                    test.displayLanguageCourses();
                    break;
                case 4:
                    test.addProgCourse();
                    break;
                case 5:
                    test.AddLangCourse();
                    break;
                case 6:
                    test.deleteCourse();
                    break;

            }
        }
    }
}
