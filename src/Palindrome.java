import java.util.Scanner;

class CheckPalindrome{
    String str;

    CheckPalindrome(String str){
        this.str = str.toLowerCase();
    }

    public String getStr() {
        return str;
    }

    public void checkPalindromeMethod(){
        char[] arr = getStr().toCharArray();
        Boolean palindrome = true;
        int reverseIndex = arr.length - 1;

        for (int i = 0; i < arr.length; i++){
            if(arr[i] != arr[reverseIndex]){
                palindrome = false;
            }
            System.out.println(arr[i] + " " + arr[reverseIndex]);
            reverseIndex--;
        }

        String result = (palindrome) ? "The word given is Palindrome." : "The word given is not a Palindrome.";
        System.out.println(result);
    }
}

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = scanner.nextLine();

        CheckPalindrome checkPalindrome = new CheckPalindrome(input);
        checkPalindrome.checkPalindromeMethod();
    }
}
