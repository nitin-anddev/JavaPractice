package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problems based on math puzzles or formulas
 */
public class MathP {
    /**
     * A number said to be a magic number if after doing sum of digits in each step and
     * in turn doing sum of digits of that sum, the ultimate result when there is only one digit left is 1.
     * Example: 163 -> 1 + 6 + 3 = 10
     *                 1 + 0 = 1
     *                 Hence 163 is a magic number.
     * @param number is the number which needs to be checked
     */
    public static void isMagicNumber(int number){
        int givenNumber = number;
        int sumOfDigits = 0;
        while (number > 0 || sumOfDigits > 9){
            if (number == 0){
                number = sumOfDigits;
                sumOfDigits = 0;
            }
            sumOfDigits += number % 10;
            number /= 10;
        }
        //If sum is 1, original number is magic number
        if (sumOfDigits == 1){
            System.out.println("Yay! " +givenNumber + " is a magic number.");
        }
        else {
            System.out.println("Oops! " +givenNumber + " is not a magic number.");
        }
    }
    public static int checkPrime(int number){
        int flag = 0;
        for (int i = 2; i <= number/2; i++){
            if (number % i == 0) {
                flag = 1;
                break;
            }
        }
        return flag;
    }
    public static void splitToPrimeSum(int num){
        for (int i = 2; i <= num/2; i++){
            if (checkPrime(i) == 0){
                if (checkPrime(num - i) == 0){
                    System.out.println(num + " = "+ (num-i) + " "+ i);
                }
            }else System.out.println(num + " is not a sum of two primes.");
        }
    }
    public static ArrayList<Integer> getMultiplicationTable(int number){
        ArrayList<Integer> table = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            table.add(number * i);
        }
        return table;
    }
    /**
     * Given the first 2 terms A1 and A2 of an Arithmetic Series.Find the Nth term of the series.
     * Example 1:
     * Input:
     * A1=2
     * A2=3
     * N=4
     * Output:
     * 5
     * Explanation:
     * The series is 2,3,4,5,6....
     * Thus,4th term is 5.
     * Example 2:
     * Input:
     * A1=1
     * A2=2
     * N=10
     * Output:
     * 10
     * Explanation:
     * The series is 1,2,3,4,5,6,7,8,9,10,11..
     * Thus,10th term is 10.
     */
    public static int nthTermOfAP(int a1, int a2, int n) {
        //BruteForce Approach:
        if (n > 1){
            int difference = a2 - a1;
            //now prepare the series
            int[] series = new int[n];
            series[0] = a1;
            series[1] = a2;
            for (int i = 2; i < series.length; i++) {
                series[i] = series[i - 1] + difference;
            }
            return series[n - 1];
        }
        else return a1;
        /**
         * Using maths formula
         * The nth term of an AP(An) with the first term A1 and common difference "d"
         * is give by the formula: nth term of an AP, An = a + (n - 1)d.
         */
        /**
         * int commonDifference = a2 - a1;
         * return a1 + (n - 1) * commonDifference;
         */
    }
    public static int[] nthTermOfGP(int a, int r, int n){
        //prepare series
        int[] series = new int[n];
        series[0] = a;
        for (int i = 1; i < n; i++){
            series[i] = series[i - 1] * r;
        }
        return series;
    }
    /**
     * Function to find number closest to N which is divisible by M
     * If there are more than one such number, then output the one having maximum absolute value.
     * Microsoft Interview Question
     */
    public static int closestNumber(int n, int m){
        System.out.println("**** Closest Number ****");
        System.out.println("n = "+n + "\nm = "+m);
        // find the quotient
        int q = n / m;

        // 1st possible closest number
        int n1 = m * q;

        // 2nd possible closest number
        int n2 = (n * m) > 0 ? (m * (q + 1)) : (m * (q - 1));

        // if true, then n1 is the required closest number
        if (Math.abs(n - n1) < Math.abs(n - n2)) return n1;

        // else n2 is the required closest number
        return n2;
    }
    public static boolean isArmstrongNumber(int n){
        long kuch = 0;
        double currentItem = kuch;
        Math.pow(kuch, kuch);
        int temp, last, digits = 0, sum = 0;
        //assigning n into temp variable
        temp = n;
        //loop to determine number of digits in given number
        while(temp > 0){
            temp = temp / 10;
            digits++;
        }
        //again assigning n into temp variable
        temp = n;
        while (temp > 0){
            //determines the last digit from the number
            last = temp % 10;
            //calculate the power of a number n up to n times and add the result to the sum variable
            sum += Math.pow(last, digits);
            //removes the last digit
            temp = temp / 10;
        }

        //compares the sum with n;
        return n == sum;
    }
    public static int sumOfDigitsOfNumber(int number){
        int last, sum = 0;
        while(number > 0){
            //determines the last digit from the number
            last = number % 10;
            //add last digit to sum;
            sum += last;
            //remove last digit
            number = number / 10;
        }
        return sum;

    }
    public static long reverseNumber(long number){
        long temp;
        int digits = 0;
        long reverseNumber = 0;
        temp = number;
        while (temp > 0){
            digits++;
            temp = temp / 10;
        }

        long[] reverseNumberAr = new long[digits];
        for(int i = 0; i < digits; i++){
            reverseNumberAr[i] = number % 10;
            number = number / 10;
        }

        for (long j : reverseNumberAr) {
            reverseNumber = (long) (reverseNumber + j * Math.pow(10, digits - 1));
            digits--;
        }
        return reverseNumber;
    }
    /**
     * Given two numbers A and B, find Kth digit from right of A^B
     * Concept: The kth digit is the remainder after dividing (a divided by 10^k-1) by 10.
     * here a = A^B
     * hence answer is : kthDigit = (A^B / 10^k-1) % 10
     * A = 10
     * B = 2
     * K = 2
     * A^B = 100
     */
    public static long printKthDigit(int a, int b, int k){
        if (k > 1)
            return (aPowerB(a, b) / aPowerB(10, k - 1)  % 10 );
        else return aPowerB(a, b) % 10;
    }
    public static long aPowerB(int base, int exponent){
        //a is base and b is exponent here
        /* Approach 1:
        int result = base;
        for (int i = 1; i < b; i++){
            result *= base;
        }
        return result;
         */
        //* Approach 2:

        long result = 1;

        while (exponent != 0) {
            result *= base;
            --exponent;
        }
        return result;
    }
    /**
     *Let's say binary number is: 10001:
     * 1 * 2^4 + 0 * 2^3 + 0 * 2^2 + 0 * 2^1 + 1 * 2^0
     * int result = 0; initially
     * result = result + n(i) * base^i-1; : where i = binaryNumber.length() - 1
     */
    public static long binaryToDecimal(String binaryNumber){
        long decimalEquivalent = 0;
        int base = 2;
        for (int i = 0; i < binaryNumber.length() - 1; i++){
            int exponent = binaryNumber.length() - (i + 1);
            long multiplier = MathP.aPowerB(base, exponent);
            int binaryDigit = Integer.parseInt(String.valueOf(binaryNumber.charAt(i)));
            decimalEquivalent = (decimalEquivalent + (binaryDigit * multiplier));
        }
        return decimalEquivalent;
    }
    public static String decimalToBinary(String decimalNumber){
        StringBuilder sb = new StringBuilder();
        String number = decimalNumber;
        while(!number.equals("0")){
            int remainder = Integer.parseInt(number) % 2;
            sb.append(remainder);
            number = String.valueOf(Integer.parseInt(number) / 2);
        }
        StringBuilder binary = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--){
            binary.append(sb.charAt(i));
        }

        return binary.toString();
    }
    /**
     * Given a positive number X. Find the largest Jumping Number which is smaller than or equal to X.
     * Jumping Number: A number is called Jumping Number if all adjacent digits in it differ by only 1.
     * All single-digit numbers are considered as Jumping Numbers.
     * For example 7, 8987 and 4343456 are Jumping numbers but 796, 677 and 89098 are not.
     * Example 1________
     * Input:
     * X = 10
     * Output:
     * 10
     * Explanation:
     * 10 is the largest Jumping Number
     * possible for X = 10.
     * Example 2_________
     * Input:
     * X = 50
     * Output:
     * 45
     * Explanation:
     * 45 is the largest Jumping Number
     * possible for X = 50.
     */
    public static boolean isJumpingNumber(long num) {
        // code here
        long difference = 0;
        boolean flag = true;
        //execute until the condition becomes false
        while(num != 0){
            //determines the last digit from the given number
            long digit1 = num % 10;
            //removes the last digit
            num = num / 10;
            //checks if the number is equal to 0 or not
            if (num != 0){
                //If the above condition returns false
                //determines the second last digit from the number
                long digit2 = num % 10;
                //subtract the digits and finds the absolute value
                //after that checks if the difference of two adjacent digit is equal to 1 or not
                if (Math.abs(digit1 - digit2) != 1){
                    //if the difference is not equal to 1, set flag to false
                    flag = false;
                    //breaks the execution
                    break;
                }
            }
        }
        return flag;
    }
    /**
     * Print all jumping numbers between given range
     * By using DFS: Depth-first search Algorithm
     * Depth-first search is an algorithm for traversing or searching tree or graph data
     * structures.
     * The algorithm starts at the root node(selecting some
     * arbitrary node as the root node in case of graph) and explores as far as possible
     * along each branch before backtracking.
     */
    public static void jumpingNumbersInRange(){}
    public static int gcd(int n, int arr[]){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, arr[i]);
        }
        return min;
    }
    public static long gcd(long a, long b){
        if (a == 0) //base case: if one of the number is zero than the other number is gcd
            return b;
        return gcd(b % a, a);
    }
    public static long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
    }

    /**
     * Algorithm to add two fractions
     * Find a common denominator by finding the LCM(The Least Common Multiple) of the two denominators.
     * Change the fractions to have the same denominator and add both terms
     * Reduce the final fraction obtained into its simpler form by dividing both numerator and denominator by their largest common factor
     */
    public static void addTwoFractions(int num1, int den1, int num2, int den2){
//        System.arraycopy();


    }


    public long countOfElements(long arr[], long n, long x){
        int temp = 0;
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
            System.out.println(x);
            if(arr[i] <= x)
                temp++;
        }
        return (long)temp;
    }
    static void lowest(int den3, int num3){
        //finding gcd of both terms
        long commonFactor = gcd(num3, den3);
        //converting both terms into simpler
        //terms by dividing them by common factor
        den3 = (int) (den3/commonFactor);
        num3 = (int) (num3/commonFactor);
        System.out.println(num3+"/"+den3);
    }
    public static int[] twoSumBruteForce(int[] nums, int target){
        //Brute Force Approach
        //Input: nums = [2, 7, 11, 15], target = 9
        //Output: [0, 1]
        for(int i = 0; i < nums.length - 1; i++){
            //loop running from 0 to 2 because nums.length - 1 = 4 - 1 = 3
            for(int j = 1; j < nums.length; j++){
                //loop running from 1 to 3
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }
    /**
     * Simple math: complement of two numbers
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumTwoPassHashTable(int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;
        //Build the hashtable
        for (int i = 0; i < n; i++){
            numMap.put(nums[i], i);
        }
        //Find the complement
        for(int i = 0; i < n; i++){
            int complement = target - nums[i];
            boolean containsComplement = numMap.containsKey(complement);
            if (containsComplement){
                int complementIndex = numMap.get(complement);
                if (complementIndex != i) return new int[]{i, complementIndex};
            }
        }
        return new int[]{}; //no solution found
    }
    public static int[] twoSumOnePassHashTable(int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++){
            int complement = target - nums[i];
            if (numMap.containsKey(complement)){
                return new int[]{numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        return new int[]{}; //no solution found
    }

    /**
     * SlidingWindow Technique
     * Example: Given an array of integers
     * Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
     * Returns maximum sum in a sub-array of size k
     */
    public static int maxSumOfKSizeSubArray(int[] array, int k){
        //size of array must be greater
        if (array.length < k){
            System.out.println("Invalid array size");
            return -1;
        }

        //compute sum of first window of size k
        int maxSum = 0;
        for (int i = 0; i < k; i++)
            maxSum = maxSum + array[i];

        //compute sums of remaining windows by
        //removing first element of previous
        //window and adding last element of current window
        int windowSum = maxSum;
        for (int i = k; i < array.length; i++){
            windowSum = windowSum + array[i] - array[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static int noOfSubArrays(long[] array, long maxProductOfElements){
        long currentWindowProduct = 1;
        int subArrays = 0;
        for (int start = 0, end = 0; end < array.length; end++){
            //move the right bound by 1 step. update the currentWindowProduct
            currentWindowProduct *= array[end];

            //move left bound so guarantee that currentWindowProduct is again less than maxProductOfElements
            while(start < end && currentWindowProduct >= maxProductOfElements)
                currentWindowProduct /= array[start++];

            //If currentWindowProduct is less than maxProductOfElements, update the counter.
            //Note that this is working even for (start == end)
            //it means that the previous window cannot grow
            //anymore and a single array element is the only addendum
            if (currentWindowProduct < maxProductOfElements){
                int currentWindowSize = end - start + 1;
                subArrays = subArrays + currentWindowSize;
            }
        }
        return subArrays;
    }

    static Pair getMinMax(long a[]){
        long min = 1;
        long max = 1;
        for(int i = 0; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        min = max;
        for (int j = 0; j < a.length; j++){
            if (a[j] < min){
                min = Math.min(min, a[j]);
            }
        }

        return new Pair(min, max);
    }
    private static int roomsNeeded(int[] guestsPrefs){
        int rooms = 0;
        int couplePref = 0;
        for (int i = 0; i < guestsPrefs.length; i++){
            if (guestsPrefs[i] == 1) rooms++;
            else if (guestsPrefs[i] == 2) {
                couplePref++;
                if (couplePref % 2 == 0) {
                    rooms++;
                    couplePref = 0;
                }
            }
            else{
                rooms++;
            }

        }

        return rooms;
    }
    private static int difference(int guest1Pref, int guest2Pref){
        int difference = guest1Pref - guest2Pref;
        int absoluteDifference = Math.abs(difference);
        return difference;
    }
    private static int daysRequired(int[] missions, int maxDifficulty){
        int days = 0;
        for (int i = 0; i < missions.length; i++){
            if (i == missions.length - 1){
                days++;
                return days;
            }
            if (isEligible(missions[i], missions[i + 1], maxDifficulty)){
                days++;
                i++;
            }else{
                days++;
            }
        }
        return days;

    }
    private static boolean isEligible(int difficulty1, int difficulty2, int maxDifficulty){
        int difference = difficulty1 - difficulty2;
        if (Math.abs(difference) <= maxDifficulty) return true;
        else return false;
    }
    private static int evenPairs(int[] array){
        int evenPairs = 0;
        for(int i = 0; i < array.length; i++){
            if (i == array.length - 1) {
                if ((array[0] + array[array.length - 1]) % 2 == 0)
                    evenPairs++;
                return evenPairs;
            }
            if ((array[i] + array[i + 1]) % 2 == 0){
                evenPairs++;
                i++;
            }
        }
        return evenPairs;
    }
    public static int oddMemberInArray(int[] array){
        if (array.length == 1) return array[0];
        int count = 1;
        int oddMember = -1; //default case or even occurrence
        int temp = -1;
        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            oddMember = currentElement;
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    int anotherElement = array[j];
                    if (currentElement == anotherElement) {
                        //second time occurred
                        count++;
                        if (count % 2 == 0)
                            oddMember = -1;
                        else oddMember = array[i];
                    }
                }
            }
            if (oddMember > 0){
                temp = oddMember;
                System.out.println(count);
            }
            //reset counter
            count = 1;
        }
        return temp;
    }
    public static int[] rotateArray(int[] array, int k){
        int[] rotatedArray = new int[array.length];
        for (int j = 0; j < k; j++){
            //first rotation
            if (j == 0) {
                for (int i = 0; i < array.length; i++) {
                    if (i == array.length - 1)
                        //last value shifted to first
                        rotatedArray[0] = array[i];
                    else rotatedArray[i + 1] = array[i];
                }
            }
            else {
                k--;
                return rotateArray(rotatedArray, k);
            }
        }
        return rotatedArray;
    }
    public static int binaryGap(int N){
        String binary = MathP.decimalToBinary(String.valueOf(N));
        int temp = 0;
        int gap = 0;
        for (int i = 0; i < binary.length(); i++){
            //10000010001
            if (binary.charAt(i) == '1'){
                //first one occurred
                //look if next char is 0 or not
                for (int j = i + 1; j < binary.length(); j++){
                    if (binary.charAt(j) == '0'){
                        temp++;
                    }else if (binary.charAt(j) == '1'){
                        //second one occurred
                        gap = Math.max(gap, temp);
                        temp = 0;
                    }
                }
                temp = 0;
            }
        }
        return gap;
    }
    public static int missingNumber(int[] A) {
        // Implement your solution here
        int largestNumber = greatestNumber(A);
        int missingNumber = 1;

        for (int currentValue : A) {
            for (int j = 0; j < A.length; j++) {
                if (currentValue == largestNumber) {
                    //array has that value already
                    //just decrement largestNumber by 1;
                    largestNumber -= 1;

                } else {
                    //array doesn't contains that value
                    missingNumber = largestNumber;
                }
            }
        }
        return missingNumber;
    }
    public static int greatestNumber(int[] A){
        int greatestNumber = 1;
        for (int j : A) {
            if (j > greatestNumber)
                greatestNumber = j;
        }
        return greatestNumber;
    }
    private static List<Integer> jumpingNumbers(long number){
        int[] jumpingNumbers = new int[(int) (number + 1)];
        for (int i = 1; i <= number; i++){
            if (MathP.isJumpingNumber(i))
                jumpingNumbers[i] = i;
            else jumpingNumbers[i] = -1;
        }
        int temp= -1;
        for (int i = 0; i < jumpingNumbers.length; i++){
            if (jumpingNumbers[i] > 0)
                temp = i;
        }
        temp++;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < temp; i++){
            if (jumpingNumbers[i] > 0) {
                result.add(jumpingNumbers[i]);
            }
        }

        return result;
    }
    private static int largestJumpingNumber(List<Integer> jumpingNumbers){
        return jumpingNumbers.get(jumpingNumbers.size() - 1);
    }

    public static int[][] transposeOfAMatrix(int[][] squareMatrix){
        for(int i = 0; i < squareMatrix.length; i++){
            for(int j = i + 1; j < squareMatrix.length; j++){
                int temp = squareMatrix[i][j];
                squareMatrix[i][j] = squareMatrix[j][i];
                squareMatrix[j][i] = temp;
            }
        }
        return squareMatrix;
    }

    long power(int N,int R){
        //Your code here
        long ans = 1;
        long mod = 1000000007, pow = N;
        while (R > 0) {
            // When rev is odd
            if (R % 2 == 1) {
                ans = (ans * pow) % mod;
            }
            pow = (pow * pow) % mod;

            // Shifting right (rev = rev/2 )
            R >>= 1;
        }
        return ans;
    }
    public static class Pair {
        public long first, second;
        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}
