package problems;

/**
 * Java program to find factorial of a given number.
 */
public class Factorial {
    public static void printFactorial(int number){
        long factorial = 1L;
        for (int i = 1; i <= number; i++){
            factorial = factorial * i;
        }
        System.out.println("Factorial: "+factorial);
    }

    public static boolean isContainTripletWithSumZero(int array[]){
        int end = 0;
        int start = 0;
        while(start != array.length - 1){
            end = start + 1;
            int firstElement = array[start];
            int secondElement = array[end];
            for(int i = 0; i < array.length; i++){
                if (array[i] != firstElement && array[i] != secondElement){
                    System.out.println(firstElement + secondElement + array[i]);
                    if (firstElement + secondElement + array[i] == 0){
                        return true;
                    }

                }
            }

            start++;
        }
        return false;
    }

}
