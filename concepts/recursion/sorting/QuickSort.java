package concepts.recursion.sorting;

import java.util.Arrays;

public class QuickSort {

    private static void getQuickSortedArray(int[] arr, int l, int h){
        if(l >= h){
            return;
        }

        int pivot = partition(arr, l, h);
        getQuickSortedArray(arr, l, pivot-1);
        getQuickSortedArray(arr, pivot+1, h);
    }

    private static int partition(int[] arr, int l, int h){
        int pivot = arr[l];

        while(l < h){
            while(l < h && arr[l] < pivot){
                l++;
            }
            while(h > l && arr[h] > pivot){
                h--;
            }
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
        }
        
        return l;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,4,7,6,3};
        System.out.println("Array before sorting: "+ Arrays.toString(arr));
        getQuickSortedArray(arr,0,arr.length-1);
        System.out.println("Array after sorting: "+Arrays.toString(arr));
    }
}
