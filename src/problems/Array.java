package problems;

import java.util.Scanner;

public class Array {
    /**
     * Find missing number using sum of n natural number formula
     * @param array
     * @return missingNumber in given array
     */
    public static int findMissingNumber(int[] array){
        int n = array.length + 1;
        int sumOfFirstNNumbers = n * (n + 1) / 2;
        int actualSumOfArr = 0;
        for (int j : array) {
            actualSumOfArr += j;
        }
        return sumOfFirstNNumbers - actualSumOfArr;
    }

    /**
     * Rotate array 90 degree clockwise
     */
    public static void rotateArray90DegreeClockwise(int sizeOfArray){
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[sizeOfArray][sizeOfArray];
        System.out.println("Enter "+sizeOfArray*sizeOfArray +" Element Array : ");
        for (int i = 0; i < sizeOfArray; i++){
            for (int j = 0; j < sizeOfArray; j++){
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("\nArray before rotation\n\n");
        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = 0; j < sizeOfArray; j++) {
                System.out.println(a[i][j] + " ");
            }
        }
        System.out.println("\n");
        //Rotation

        //Transpose
        for (int i = 0; i < sizeOfArray; i++){
            for(int j = i; j < sizeOfArray; j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        //Reverse each row
        for (int i = 0; i < sizeOfArray; i++){
            int l, j;
            for (j = 0, l = sizeOfArray - 1; j < 1; j++){
                int temp = a[i][j];
                a[i][j] = a[i][l];
                a[i][l] = temp;
                l--;
            }
        }
        System.out.println("Array after rotation - \n");
        for (int i = 0; i < sizeOfArray; i++){
            for (int j = 0; j < sizeOfArray; j++){
                System.out.println(a[i][j] + " ");
            }
        }
    }
}
