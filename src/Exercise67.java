import java.util.ArrayList;
import java.util.Scanner;

class Book{
    int bookId;
    String title;
    String author;
    String isbn;
    String genre;
    boolean avalaible;

    Book(int bookId){
        this.bookId = bookId;
    }

    Book(int bookId,String title,String author,String isbn,String genre,boolean avalaible){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.avalaible = avalaible;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setAvalaible(boolean avalaible) {
        this.avalaible = avalaible;
    }

    public boolean isAvalaible() {
        return avalaible;
    }

    public void displayBookDetail(){
        System.out.print("\nBook detail:-" +
                "\nID: " + getBookId() +
                "\nTitle: " + getTitle() +
                "\nAuthor: " + getAuthor() +
                "\nISBN: " + getIsbn() +
                "\nGenre: " + getGenre() +
                "\nAvailability: ");
        String result = (isAvalaible()) ? "YES" : "NO";
        System.out.println(result);
    }
}

class Patron extends Book{
    int patronId;
    String name;

    Patron(int bookId, int patronId, String name){
        super(bookId);
        this.patronId = patronId;
        this.name = name;
    }

    public int getPatronId() {
        return patronId;
    }

    public String getName() {
        return name;
    }

    void displayPatronInfo(){
        System.out.println("\nPatron ID: " + getPatronId() +
                "\nPatron Name: " + getName());
    }
}

class Library{
    ArrayList<Book> bookArray = new ArrayList<>();
    ArrayList<Patron> patronArray = new ArrayList<>();

    void addBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------------------------------------------------------------");
        System.out.print("\nAdd a book:-" +
                "\nBook ID: ");
        int id = scanner.nextInt();
        System.out.print("Title: ");
        String title = scanner.next();
        System.out.print("Author: ");
        String author = scanner.next();
        System.out.print("ISBN: ");
        String isbn = scanner.next();
        System.out.print("Genre: ");
        String genre = scanner.next();
        boolean available = true;
        Book newBook = new Book(id,title,author,isbn,genre,available);
        bookArray.addFirst(newBook);

    }

    void returnBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter book's ID want to return: ");
        int bookId = scanner.nextInt();
        System.out.print("Enter Patron's ID: ");
        int patronId = scanner.nextInt();
        boolean check = false;
        for (int i = 0; i < patronArray.size();i++){
            if(bookId == patronArray.get(i).getBookId() && patronId == patronArray.get(i).getPatronId()){
                check = true;
            }
        }

        if (check){
            for (int i = 0 ; i < bookArray.size() ; i++){
                if(bookId == bookArray.get(i).getBookId()){
                    bookArray.get(i).setAvalaible(true);
                    System.out.println("Returning successfully.");
                }
            }
            for (int i = 0; i< patronArray.size() ; i++){
                if(patronId == patronArray.get(i).patronId)patronArray.remove(i);
            }
        } else {
            System.out.println("Returning unsuccessfully. Please enter valid input.");
        }
    }

    void borrowingBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter book's ID want to borrow: ");
        int bookId = scanner.nextInt();
        System.out.print("Enter Patron's ID: ");
        int patronId = scanner.nextInt();
        System.out.print("Enter Patron's name: ");
        String name = scanner.next();
        Patron patron = new Patron(bookId,patronId,name);
        patronArray.addFirst(patron);
        displayBorrowingBook();
    }

    void displayBorrowingBook(){
        System.out.println("\n------------------------------------------------------------");
        patronArray.get(0).displayPatronInfo();
        for(int i = 0; i < bookArray.size() ; i++){
            if(bookArray.get(i).getBookId() == patronArray.get(0).getBookId()){
                bookArray.get(i).setAvalaible(false);
                bookArray.get(i).displayBookDetail();
            }
        }
    }

    void displayBorrowedBook(){
        System.out.println("\n------------------------------------------------------------");
        System.out.println("\nViewing all borrowed books.");
        int count = 0;
        for(int i = 0; i < patronArray.size(); i++){
            for (int j = 0; j < bookArray.size();j++){
                if(patronArray.get(i).getBookId() == bookArray.get(j).getBookId()){
                    count++;
                    patronArray.get(i).displayPatronInfo();
                    bookArray.get(j).displayBookDetail();
                }
            }
        }
        if(count == 0)System.out.println("\nNo book been borrow.");
    }

    void displayAvailableBook(){
        System.out.println("\n------------------------------------------------------------");
        System.out.println("\nViewing all available books for borrow");
        int count = 0;
        for (Book bookArray : bookArray){
            if (bookArray.isAvalaible()){
                count++;
            }
        }
        if(count == 0) System.out.println("\nNo book available.");
        for (Book bookArray : bookArray){
            if (bookArray.isAvalaible()){
                bookArray.displayBookDetail();
            }
        }
    }

    void displayAllBook(){
        System.out.println("\n------------------------------------------------------------");
        System.out.println("\nViewing all Library's books");
        int count = 0;
        for (Book bookArray : bookArray){
            if (bookArray.isAvalaible()){
                count++;
            }
        }
        if(count == 0) System.out.println("\nNo book in Library.");
        for (Book bookArray : bookArray){
                bookArray.displayBookDetail();
        }
    }

    void action(){
        Scanner scanner = new Scanner(System.in);
        Book bk1 = new Book(406, "Si Pujangga", "Ahmad Aslam","1234-56-7890","Fiction BM",true);
        Book bk2 = new Book(407,"Tapak Kaki Kuda", "Khari Jamaluddin", "2345-67-8901","Fiction BM",true);
        bookArray.add(bk1);
        bookArray.add(bk2);

        int choice = 1;
        while(choice > 0 && choice <= 6){
            System.out.println("\n------------------------------------------------------------");
            System.out.print("\n1 - View all books in Library" +
                    "\n2 - View all available books to borrow" +
                    "\n3 - View all borrowed books" +
                    "\n4 - Add a new book" +
                    "\n5 - Return a book" +
                    "\n6 - Borrow a book" +
                    "\n0 - Exit" +
                    "\n\nAction > ");
            choice = scanner.nextInt();
            switch (choice){
                case 0:
                    break;
                case 1:
                    displayAllBook();break;
                case 2:
                    displayAvailableBook();break;
                case 3:
                    displayBorrowedBook();break;
                case 4:
                    addBook(); break;
                case 5:
                    returnBook();break;
                case 6:
                    borrowingBook(); break;
            }
        }

        System.out.println("\n------------------------------------------------------------");
        System.out.println("\nThank you. Bye bye!");
    }

}

public class Exercise67 {
    public static void main(String[] args) {
        Library library = new Library();
        library.action();
    }
}
