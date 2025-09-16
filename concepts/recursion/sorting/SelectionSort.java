package concepts.recursion.sorting;

import java.util.Arrays;

public class SelectionSort {
    
    private static int[] getSelectionSortedArray(int[] arr, int first, int curr, int currMin){

        if(first == arr.length-1){
            return arr;
        }

        if(curr == arr.length){
            int temp = arr[first];
            arr[first] = arr[currMin];
            arr[currMin] = temp;
            return getSelectionSortedArray(arr,first+1,first+1,first+1);
        }

        if(arr[curr] < arr[currMin]){
            currMin = curr;
        }
        return getSelectionSortedArray(arr, first, curr+1, currMin);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,4,7,6,3};
        System.out.println("Array before sorting: "+ Arrays.toString(arr));
        System.out.println("Array after sorting: "+Arrays.toString(getSelectionSortedArray(arr, 0, 0, 0)));
    }
}
