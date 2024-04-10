import problems.MathP;

import java.util.*;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // int[] nodesData = new int[]{ 100, 3, 4, 7, 9, 10, 30, 40 };
        //        int[] tree = new int[]{}
        //        Node root = buildTree(nodesData);
        //        printTree(root);

        //int[] data = new int[]{ 1, 2, 3, 4, 5, 6, 5, 4, 3, 2,};
        //oolean isPalindrome = isPalindrome(data);
        //System.out.println(isPalindrome);


        Employee e1 = new Employee("Ajay", "IT", 35);
        Employee e2 = new Employee("Ajay", "IT", 35);
        Employee e3 = new Employee("Zack", "IT", 40);
        Employee e4 = new Employee("David", "Finance", 28);
        Employee e5 = new Employee("Surya", "IT", 60);
        //e1.getName().startsWith("M");
        String first = "nitin";
        String second = "Nitin";

        boolean isPalindromeString = isPalindromeString(second);
        System.out.println(isPalindromeString + " is");

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(isPalindrome(list));

//        for(int start = 0, end = list.size() - 1;  start < end; start++, end--){
//           if(list.get(start) != list.get(end)){
//
//           }
//        }



        //System.out.println(e1.equals(e2));
        //System.out.println(e2 == e1);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))
                .filter(employee -> employee.getAge() > 30000)
                .collect(Collectors.toList());



        Map<String, List<Employee>> employeeByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        List<String> departments = new ArrayList<>(employeeByDepartment.keySet());
        //System.out.println(departments);
//        for (String department: departments){
//            System.out.println(department);
//        }
//        employeeByDepartment.entrySet().forEach(employeeByDepartment.values().);
//        employeeByDepartment.get
//        System.out.println(Arrays.toString(employeeByDepartment.entrySet().toArray()));
//        System.out.println(Arrays.toString(employeeByDepartment.keySet().toArray()));

        for (int i = 0; i < employeeByDepartment.size(); i++){

        }

        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(2);
        numbersList.add(3);

        List<Integer> n = numbersList.stream().filter(num -> num == 3).collect(Collectors.toList());
        String myString = "Nitin Kumar";
        Integer myInt = 1;



        //sorted --> intermediate operator
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))
                .collect(Collectors.toList());

        try{

        }catch (NoClassDefFoundError e){
            //e.toString()
        }
        //filter --> intermediate operator
        //sorted --> intermediate operator
        //collect --> terminal operator'
        List<Employee> ageGreaterThan30 = employees.stream().filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        //distinct --> intermediate operator
        //collect --> terminal operator
        List<Integer> distinctElements = numbersList.stream().distinct().collect(Collectors.toList());
//        numbersList.stream().mapToInt();
//        IntStream.rangeClosed(1, 100)
//                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i + ""))
//                .forEach(System.out::println);


        //IntStream.rangeClosed(1, distinctElements.get(distinctElements.size() - 1)).forEach(System.out::println);
//
//        for(int i : distinctElements){
//            System.out.println(i);
//        }
//
//        for(Employee employee : ageGreaterThan30){
//            System.out.println(employee.getName());
//        }

    }

    private static boolean isPalindrome(LinkedList<Integer> data){
        for(int start = 0, end = data.size() - 1; start < end; start++, end--){
            if(!Objects.equals(data.get(start), data.get(end))){
                return false;
            }
            //System.out.print(" " + data[start] + " " + data[end]);
        }
        return true;
    }

    private static boolean isPalindromeString(String string){
        //Nitin
        String k = string.toLowerCase();
        for(int start = 0, end = k.length() - 1; start < end; start++, end--){
            if (k.charAt(start) != k.charAt(end)) {
                return false;
            }
        }
        return true;
    }

//    private static int findIteration(){
//
//    }

    static List<Integer> leftView(Node root){
        Queue<Node> q = new LinkedList<>();
        List<Integer> leftView = new ArrayList<>();
        if(root != null){
            q.add(root);
            while(!q.isEmpty()){
                if (q.peek().left != null) q.add(q.peek().left); //add left node in queue
                else if (q.peek().right != null && q.peek().right.left != null)
                    q.add(q.peek().right.left); // add left of right child
                leftView.add(q.remove().data);
            }
        }
        return leftView;
    }
    static class Node {
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Build Tree : Level Order Traversal
     * @param array
     * @return
     */
    static Node buildTree(int[] array){
        //base case
        if(array == null || array.length == 0) return null;

        int index = 0;
        Node root = new Node(array[index]); //creating root node which contains first element of array as data
        Queue<Node> q = new LinkedList<>(); //creating a queue to use its FIFO property
        q.add(root); //adding root node to queue
        index++; //incrementing index since first index value is added to queue already
        while(index < array.length){
            Node currentNode = q.remove(); //getting current node from queue || remember FIFO
            currentNode.left = new Node(array[index++]); //adding left child to current node
            q.add(currentNode.left); //adding left child of current node to queue
            if (index < array.length){
                currentNode.right = new Node(array[index++]); // adding right child to current node
                q.add(currentNode.right); // adding right child of current node to queue
            }
        }
        return root;
    }
    static void printTree(Node root){
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }
    static int print2largest(int arr[], int n) {
        Arrays.sort(arr);
        int temp = -1;
        for(int i = n-1;i>=0 ;i--){
            if(arr[i]!= arr[n-1]){
                temp = arr[i];
                break;
            }
            continue;
        }
        return temp;
    }

    public static int squareRoot(int x){
        //base cases
        if(x == 0 || x == 1)
            return x;
        int i = 1, result = 1;
        while(result <= x){
            result = i * i;
            i++;
            System.out.println(result);
        }
        return i - 1;
    }
    public static int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(i + needle.length() <= haystack.length()) {
                    String hn = haystack.substring(i, i + needle.length());
                    if (hn.equals(needle))
                        return i;
                }else return -1;
            }
        }
        return -1;
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int maxSum = 0;
        int windowSum = 0;
        int temp = 0;
        for(int start = 0, end = 0; end < nums.length; end++){
            temp = start;
            while(temp <= end){
                windowSum = windowSum + nums[temp];
                maxSum = Math.max(windowSum, maxSum);
                temp++;
            }
            if(windowSum < 0){
                windowSum = 0;
                start = start + 1;
            }else {
                windowSum = 0;
            }
        }
        System.out.println("maxSum: "+maxSum);
        return maxSum;
    }
    public static boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        long absoluteNumber = n < 0 ? -1 * (long) n : (long) n;
        System.out.println("absoluteNumber: "+absoluteNumber);
        if(absoluteNumber % 2 == 0){
            //its an even number
            long quotient = absoluteNumber / 2;
            System.out.println("quotient: "+quotient);
            double power = pow(2.0, quotient);
            System.out.println("power: "+power);
            return power == absoluteNumber;
        }
        return false;
    }
    static double pow(double x, long n){
        if(n == 0)  return 1;
        if(n % 2 == 0) return pow(x * x, n /2);
        else return x * pow(x * x, (n - 1) / 2);
    }
    public static int reverseNumber(int number){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < String.valueOf(number).length(); i++){
            double digit = (number % Math.pow(10, i + 1)) / Math.pow(10, i);
            sb.append((int) digit);
        }
        return Integer.parseInt(sb.toString());
    }
    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[j] = nums[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> windowMaxs = new ArrayList<>();
        int currentWindowMax = Integer.MIN_VALUE;

        for(int left = 0, right = k - 1; right < nums.length; left++, right++){
            for(int i = left; i <= right; i++){
                currentWindowMax = Math.max(currentWindowMax, nums[i]);
            }
            windowMaxs.add(currentWindowMax);
        }
        int[] out = new int[windowMaxs.size()];
        for(int i = 0; i < windowMaxs.size(); i++){
            out[i] = windowMaxs.get(i);

        }
        return out;
    }
    public static String longestPalindrome(String s) {
        int j = 0;
        String longestPalindrome = "";
        for(int i = 0; i < s.length(); i++){
            while(j < s.length()){
                if(i != j){
                    if(s.charAt(i) == s.charAt(j)){
                        for(int k = i; k <= j; k++){
                            longestPalindrome = longestPalindrome.concat(String.valueOf(s.charAt(k)));
                        }
                    }
                }
                j++;
            }
        }
        return longestPalindrome;
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0, start = 0;
        for(int i = 0; i < s.length(); i++) {
            int index = s.indexOf(s.charAt(i), start);
            System.out.println(s.charAt(i) + " : " + "start -> " + start + " Index == "+index);
            if(index != i)
                start = index + 1;
            maxLen = Math.max(maxLen, index - start + 1);
        }
        return maxLen;
    }

    public static int maxProfit(int[] stockPrices) {
        int profit = 0;
        int todayPrice = Integer.MAX_VALUE;
        int pist = 0;
        for (int i = 0; i < stockPrices.length; i++) {
            if(stockPrices[i] < todayPrice)
                todayPrice = stockPrices[i];
            pist = stockPrices[i] - todayPrice;
            System.out.println(pist);
            if(profit < pist)
                profit = pist;
        }
        return profit;
    }

    // Runtime: 1 ms, faster than 92.94% of Java online submissions for Find Pivot Index.
    // Time Complexity : O(n)
    public int pivotIndex(int[] nums) {
        // Initialize total sum of the given array...
        int totalSum = 0;
        // Initialize 'leftsum' as sum of first i numbers, not including nums[i]...
        int leftsum = 0;
        // Traverse the elements and add them to store the totalSum...
        for (int ele : nums)
            totalSum += ele;
        // Again traverse all the elements through the for loop and store the sum of i numbers from left to right...
        for (int i = 0; i < nums.length; leftsum += nums[i++])
            // sum to the left == leftsum.
            // sum to the right === totalSum - leftsum - nums[i]..
            // check if leftsum == totalSum - leftsum - nums[i]...
            if (leftsum * 2 == totalSum - nums[i])
                return i;       // Return the pivot index...
        return -1;      // If there is no index that satisfies the conditions in the problem statement...
    }
    static int[] remove_duplicate(int a[], int n){
        int i = 0;
        int j = 1;
        int temp;

        while(j < n){
            if(a[i] != a[j]){
                temp = a[i + 1];
                a[i + 1] = a[j];
                a[j] = temp;
                i++;
            }
            j++;
            //System.out.println(Arrays.toString(a));
        }
        return a;
    }

    static int nCr(int n, int r){
        //nCr = n! / r! * (n – r)!
        int nFact = 1;
        int rFact = 1;
        int nMinusRFact = 1;
        for(int i = n; i > 0; i--){
            nFact *= i;
            if(i <= r)
                rFact *= i;
            if(i <= (n - r))
                nMinusRFact *= i;
        }
        return nFact /(rFact * nMinusRFact);
    }
    public static int binary_to_decimal(String str){
        double product = 0;

        for(int i = str.length() - 1, j = 0; i >= 0 || j < str.length(); i--, j++){
            //System.out.println("charAt: "+ j + " -> "+ str.charAt(j));
            //System.out.println("value of i: "+ i);
            //long multiplier = MathP.aPowerB(2, j + 1); //Math.pow(2, i);
            //System.out.println("multiplier: "+ multiplier);
            product = product + (Integer.parseInt(String.valueOf(str.charAt(j))) * Math.pow(2, i));
            //System.out.println(product);
        }
        return (int) product;
    }
    static long kthDigit(int A,int B,int K){
        double ab =  Math.pow(A, B);
        double lastDigit = (ab % Math.pow(10, K)) / Math.pow(10, K - 1);
        return (long) lastDigit;
    }
    static int isDigitSumPalindrome(int N) {
        // code here
        int sum = 0;
        String number = String.valueOf(N);
        for(int i = 0; i < number.length(); i++){
            sum+= Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        System.out.println("number also: " +sum);
        if(isPalindrome(String.valueOf(sum)))
            return 1;
        else return 0;
    }

   static boolean isPalindrome(String number){
       System.out.println("number here: " + number);
        StringBuilder reversedNumber = new StringBuilder();
       System.out.println("number length " + number.length());
        for(int i = number.length() - 1; i >= 0; i--){
            reversedNumber.append(number.charAt(i));
        }
        return reversedNumber.toString().equals(number);
    }
    static String armstrongNumber(int n){
        // code here
        String number = String.valueOf(n);
        double cube = Double.MIN_VALUE;
        for(int i = 0; i < number.length(); i++){
            double thisNumber = Double.parseDouble(String.valueOf(number.charAt(i)));
            cube += Math.pow(thisNumber, 3);
        }
        boolean isArmstrongNumber = cube == Double.parseDouble(number);
        if(isArmstrongNumber) return "Yes";
        else return "No";
    }

    /**
     * Given an array arr of n integers,
     * task is to print the array in the order – smallest number, largest number,
     * 2nd smallest number, 2nd largest number,
     * 3rd smallest number, 3rd largest number and so on.
     * @return rearrangedArray
     */
    private static int[] getReArrangedArray(int[] array){
        Arrays.sort(array);
        int[] tempArray = new int[array.length];
        int pivot = 0;
        //traverse the array from begin and end simultaneously
        for(int i = 0, j = array.length - 1; i <= array.length / 2 || j > array.length / 2; i++, j--){
            if (pivot < array.length){
                tempArray[pivot] = array[i];
                pivot++;
            }
            if (pivot < array.length){
                tempArray[pivot] = array[j];
                pivot++;
            }
        }
        return tempArray;
    }

    public static long[] gp(int a, int r, int n){
        long[] series = new long[n];
        series[0] = a;
        for (int i = 1; i < n; i++){
            double multiple = Math.pow(r, i);
            long temp = (long) (a * multiple);
            //long temp = series[i - 1] * r;
            series[i] = temp;
        }
        return series;
    }

    public static int nthTerm(int a, int r, int n){
        int nthTerm = a * (int) Math.pow(r, n - 1);
        int last = nthTerm % 1000000007;
        return last;
    }
    public static int Nth_term(int a, int r, int n){
        int m = 1000000007;
        long x = (long) a * power(r, n - 1) % m;
        return (int) x;
    }

    public static long power(int r, int n) {
        System.out.println("called power");
        int m = 1000000007;
        if (n == 0) {
            return 1;
        }
        long t = power(r, n / 2) % m;
        t = (t * t) % m;
        if (n % 2 == 0) {
            System.out.println("returning: " + (t % m));
            return t % m;
        }
        System.out.println("returning: (r * t) % m " + (r * t) % m);
        return (r * t) % m;
    }

    private static int isContainTripletWithZero(int[] array){
        if (array.length == 3 && array[0] == 0 && array[1] == 0 && array[2] == 0) return 1;
        for(int i = 0; i < array.length; i++){
            if (i < array.length - 1) {
                int firstElement = array[i];
                int secondElement = array[i + 1];
                for(int j = 0; j < array.length; j++){
                    if (array[j] != firstElement && array[j] != secondElement) {
                        int sum = firstElement + secondElement + array[j];
                        if (sum == 0)
                            return 1;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Merge without extra space
     */
    private static void mergeArrays(int[] array1, int[] array2){
        int temp;
        for (int i = 0; i < array2.length; i++){
            for (int j = 0; j < array1.length; j++) {
                if (array1[j] > array2[i]){
                    //first array item is larger
                    //swap with second array item
                    temp = array1[j];
                    array1[j] = array2[i]; //1 3 5 7 : 0 2 6 8 9
                    array2[i] = temp;
                    if (i < array2.length - 1) {
                        if (array2[i] > array2[i + 1]) {
                            temp = array2[i];
                            array2[i] = array2[i + 1];
                            array2[i + 1] = temp;
                        }
                    }
                }
            }
            if (i < array2.length - 1) {
                if (array2[i] > array2[i + 1]) {
                    temp = array2[i];
                    array2[i] = array2[i + 1];
                    array2[i + 1] = temp;
                    i = -1;
                }
            }
        }
        System.out.println(Arrays.toString(array1) + Arrays.toString(array2));
    }
    private static void mergeAs(long[] array1, long[] array2){
        int i = 0;
        while(i < array1.length  && i < array2.length && array1[array1.length - i - 1] > array2[i]){
            long j = array1[array1.length - i - 1];
            array1[array1.length - i - 1] = array2[i];
            array2[i] = j;
            i++;
        }

        //Arrays.sort(array1);
        //Arrays.sort(array2);

        System.out.println(Arrays.toString(array1) + Arrays.toString(array2));
    }




    /**
     * Kadane's Algorithm
     * find sub array sum
     * if current sub array sum > maxSum : then maxSum = currentSubArray and end++
     */
    private static int maxSumAchieved(int[] array){
        int currentWindowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            //move the right bound by 1 step. update the currentWindowProduct
            currentWindowSum += array[i];
            if (maxSum < currentWindowSum)
                maxSum = currentWindowSum;
            //discard sub array with negative sum
            if (currentWindowSum < 0)
                currentWindowSum = 0;
        }
        return maxSum;
    }



    class Solution{

        // arr: input array
        // n: size of array
        //Function to find the sum of contiguous subarray with maximum sum.
        long maxSubarraySum(int arr[], int n){

            // Your code here
            long res=Integer.MIN_VALUE;
            long curr=0;
            for(int a:arr){
                curr=curr+a;
                res=Math.max(res,curr);
                if(curr<0){
                    curr=0;
                }

            }
            return res;

        }

    }


    private static int missingNumber(int[] array, int n){
        int nPlus1 = n + 1;
        int sum = (n * nPlus1) / 2;
        int ararySum = 0;
        for (int j : array) ararySum += j;
        return sum - ararySum;
    }

    private static MathP.Pair subArrayWithSum(int[] array, int sum){
        long currentWindowSum = 0;
        for (int start = 0, end = 0; end < array.length; end++){
            //move the right bound by 1 step. update the currentWindowProduct
            currentWindowSum += array[end];

            //move left bound so guarantee that currentWindowProduct is again less than maxProductOfElements
            while(start < end && currentWindowSum > sum)
                currentWindowSum -= array[start++];

            //If currentWindowProduct is less than maxProductOfElements, update the counter.
            //Note that this is working even for (start == end)
            //it means that the previous window cannot grow
            //anymore and a single array element is the only addendum
            if (currentWindowSum == sum){
                return new MathP.Pair(start + 1, end + 1);
            }
        }
        return new MathP.Pair(-1, -1);
    }



    /**
     * Companies Asked:
     * Paytm Flipkart Morgan Stanley Accolite Amazon Microsoft Samsung
     * D-E-Shaw Hike MakeMyTrip Ola Cabs Oracle Walmart Goldman Sachs Directi Intuit SAP Labs Quikr Facebook Salesforce Pubmatic Sapient Swiggy
     */

    private static int maxProfist(int[] stockPrices){
        int profit = 0;
        int todayPrice;
        for (int i = 0; i < stockPrices.length; i++) {
            todayPrice = stockPrices[i];

            if (i < stockPrices.length - 1) {
                int nextDayPrice = stockPrices[i + 1];
                if (isSellToday(todayPrice, nextDayPrice)){
                    //selling today : keeping profit as same
                    //buying next day stock
                    profit += getProfitAfterSell(todayPrice, todayPrice);
                }

                if (isSellNextDay(isSellToday(todayPrice, nextDayPrice))){
                    //selling at next day
                    profit += getProfitAfterSell(todayPrice, nextDayPrice);
                }
            }
        }
        return profit;
    }

    private static boolean isSellToday(int todayPrice, int nextDayPrice){
        return todayPrice > nextDayPrice;
    }
    private static boolean isSellNextDay(boolean isSellToday){
        return !isSellToday;
    }
    private static int getProfitAfterSell(int buyPrice, int sellPrice){
        return sellPrice - buyPrice;
    }
}