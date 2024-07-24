
public class Tolls {
    private static int yesterday = 1;
    int tomorrow = 10;
    public static void main(String[] args) {
        Tolls tolls = new Tolls();
        int today = 90;
        System.out.println(tolls.tomorrow + today + yesterday );
    }
}
