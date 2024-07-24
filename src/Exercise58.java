class InvalidAgeException extends Exception{
    InvalidAgeException(String errorMessage){
        System.err.println("Caught InvalidAgeException Error: " + errorMessage);
    }
}

class AgeValidator{
    void validateAge(int age) throws InvalidAgeException{
        if (age < 18 || age >65){
            throw new InvalidAgeException("Invalid age");
        }
    }
}

public class Exercise58 {
    public static void main(String[] args) {
        AgeValidator ageValidator = new AgeValidator();
        int[] arr = {20,19,68};
        try {
            for (int i = 0; i < arr.length ; i++){
                ageValidator.validateAge(arr[i]);
                System.out.println(arr[i] + " is in the age range.\n");
            }
        }catch (InvalidAgeException e){
            System.err.println("Age must be between 18 & 65.");
        }
    }
}
