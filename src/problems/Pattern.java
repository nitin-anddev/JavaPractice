package problems;

import java.util.Arrays;

/**
 * aab: aa
 * abbb: bbb
 * abab: ""
 */
public class Pattern {
    /**
     * Print pattern:
     * Sample Input: 3:
     * Output: 3 3 3 2 2 2 1 1 1 $3 3 2 2 1 1 $3 2 1 $
     * Sample Input: 2
     * Output: 2 2 1 1 $2 1 $
     * @param n
     */
    public static void printPattern(int n){
        for (int c = n; c > 0; c--) {
            //In the first iteration:
            //Let's say n = 3
            //Then c = 3, in first iteration
            //This will print 1 row correctly: 3 3 3 2 2 2 1 1 1
            for (int i = 0; i < n; i++) {
                //here i = 0 which will help in printing number
                //in first iteration i = 0 hence below code will execute


                //in the second iteration:
                // now i becomes 1 but since c is still 3 below loop will execute 3 times again
                // and n - i or 3 - 1 or 2 will be printed 3 times
                for (int j = c; j > 0; j--) {
                    //Now in first iteration j = c = 3 which is > 0
                    //hence below statement executes and print 3 - 0 = 3
                    //after printing this control is still in this loop because the exit condition isn't matched yet
                    //j is now 2

                    //Second iteration starts here for this internal loop
                    // and print 3 - 0  again
                    //since i is still 0; but now j becomes 2
                    //after printing 3 again j becomes 1 which is still greater than zero and hence
                    // 3 will print again and control will now exit this loop
                    // and enter this loop's parent loop

                    System.out.print((n - i) + " ");
                }
            }
            System.out.print("$");
        }
    }
    public static void largestSegmentOfString(String s){
        int ans = 1, temp = 1;
        StringBuilder sb = new StringBuilder();

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
