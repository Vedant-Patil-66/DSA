package concepts.Recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {

    private static int[] getbubbleSortedArray(int[] arr, int curr, int last){

        if(last == 0){
            return arr;
        }
        if(curr == last){
            return getbubbleSortedArray(arr, 0, last-1);
        }

        if(arr[curr] > arr[curr+1]){
            int temp = arr[curr];
            arr[curr] = arr[curr+1];
            arr[curr+1] = temp;
        }
        return getbubbleSortedArray(arr, curr+1, last);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,4,7,6,3};
        System.out.println("Array before sorting: "+ Arrays.toString(arr));
        System.out.println("Array after sorting: "+Arrays.toString(getbubbleSortedArray(arr,0,  arr.length-1)));
    }
}
