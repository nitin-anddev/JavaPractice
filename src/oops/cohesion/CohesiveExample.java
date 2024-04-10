package oops.cohesion;

public class CohesiveExample {
    //method for adding two numbers
    public void addition(int a, int b){
        int sum = a + b;
        System.out.println("Addition of the numbers " + a + "and " + b + "is " +sum);
    }

    //method for checking the vowels and consonants
    public void findingVowel(char c){
        switch (c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(c + " is a vowel.");
            break;
            default:
                System.out.println(c + " is not a vowel.");
        }
    }
}
