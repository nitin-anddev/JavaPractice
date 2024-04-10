package problems;

import java.util.Arrays;

/**
 * Java program to check if the two strings are anagrams
 * An anagram of a string is another string that contains the same characters,
 * only the order of characters can be different.
 * For example, “abcd” and “dabc” are an anagram of each other.
 */
public class Anagram {
    public static boolean isAnagram(String firstString, String secondString){
        boolean isAnagram = false;
        if (firstString.length() == secondString.length()){
            //convert strings to char array
            char[] firstStringChars = firstString.toCharArray();
            char[] secondStringChars = secondString.toCharArray();
            //sort the arrays
            Arrays.sort(firstStringChars);
            Arrays.sort(secondStringChars);
            //check for equality, if found equal then anagram, else not an anagram
            isAnagram = Arrays.equals(firstStringChars, secondStringChars);
        }
        return isAnagram;
    }
}
