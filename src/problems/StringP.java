package problems;

import java.util.Arrays;

public class StringP {
    public static void reverseString(String string){
        //Pointers
        int i = 0, j = string.length() - 1;

        //Result character array to store the reversed string
        char[] reverseString = new char[j + 1];

        //Looping and reversing the string
        while (i < j){
            reverseString[j] = string.charAt(i);
            reverseString[i] = string.charAt(j);
            i++;
            j--;
        }
        //Printing the reversed String
        System.out.println("Reversed String = " + String.valueOf(reverseString));
    }
    public static void largestSegmentOfString(String s){
        int ans = 1, temp = 1;
        StringBuilder sb = new StringBuilder();
        //aab

        // Traverse the string
        for (int i = 1; i < s.length(); i++) {
            // If character is same as previous increment temp value
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++temp;
                ans = Math.max(ans, temp);
                System.out.println("temp at: "+ i + " --> "+temp);
                System.out.println("ans at: "+ i + " --> "+ans);
                if (temp == ans) {
                    System.out.println("temp is equal adding " +s.charAt(i));
                    //sb.delete(0, sb.length());
                    sb.append(s.charAt(i));
                }
            }
            else {
                //character not matched and hence reset temp value
                temp = 1;
            }
        }
        ans = Math.max(ans, temp);
        char[] mostRepeatedSegment = new char[ans];
        for(int i = 0; i < ans; i++){
            mostRepeatedSegment[i] = sb.charAt(sb.length() - 1);
        }
        System.out.println("Repeated Segment: "+ Arrays.toString(mostRepeatedSegment));
    }
}
