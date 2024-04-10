package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Automata {

    /**
     * Asked in NatWest Group Preliminary round
     *Input:
     * 6
     * 29 38 12 48 39 55
     * 30
     * 50
     * Output:
     * 38 48 39
     */
    public static int[] inRange(int[] inputDist, int start, int end){
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < inputDist.length; i++){
            System.out.println("inputDist at "+ i + " " + inputDist[i]);

            if (inputDist[i] >= start && inputDist[i] <= end){
                System.out.println("adding "+ inputDist[i]);
                temp.add(inputDist[i]);
                //temp[i] = inputDist[i];
                //answer.add(inputDist[i]);// = inputDist[i];
            }
        }
        temp.removeAll(Collections.singletonList(0));
        int[] answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++){
            answer[i] = temp.get(i);
        }
        return answer;
    }

    /**
     * Asked in NatWest Group Preliminary round
     * @param arr
     * @return
     */

    public static int[] interChange(int[] arr){
        int[] answer = new int[arr.length];
        for (int i = 0; i < answer.length; i++){
            if (i % 2 == 0) {
                answer[i] = arr[i + 1];
                answer[i + 1] = arr[i];
            }
        }
        return answer;
    }
}
