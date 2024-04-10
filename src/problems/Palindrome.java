package problems;

/**
 * Java program to check if the given string is palindrome or not
 * Using Recursion
 */
public class Palindrome {
    public boolean isPalindrome(String word){
        String reverseWord = getReverseWord(word);
        //if word equals its reverse, then it is a palindrome
        if (word.equals(reverseWord)){
            return true;
        }
        return false;
    }
    public String getReverseWord(String word){
        if (word == null || word.isEmpty()){
            return word;
        }

        return word.charAt(word.length() - 1) + getReverseWord(word.substring(0, word.length() - 1));
        //Explanation: for input word "kumar"
        //r + getReverseWord(kuma)
        //r + (a + getReverseWord(kum))
        //r + (a + m + getReverseWord(ku))
        //r + (a + m + u + getReverseWord(k))
        //r + (a + m + u + k) and hence final output is ramuk which is desired/expected

    }
}
