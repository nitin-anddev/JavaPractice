package problems;

/**
 * Fibonacci series using recursion
 */
public class FibonacciSeries {
    public static void printFibonacci(int val1, int val2, int num){
        //Base case
        if (num == 0)
            return;
        //Printing the next Fibonacci number
        System.out.println(val1 + val2 + " ");
        //Recursively calling for printing Fibonacci for remaining length
        printFibonacci(val2, val1+val2, --num);
    }
}
