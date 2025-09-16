package concepts.recursion.sorting;

import java.util.Arrays;

public class MergeSort {

    private static int[] getMergeSortedArray(int[] arr){

        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;
        int[] arr1 = Arrays.copyOfRange(arr,0,mid);
        int[] arr2 = Arrays.copyOfRange(arr,mid,arr.length);

        return mergeSortedArrays(getMergeSortedArray(arr1),getMergeSortedArray(arr2));
    }

    private static int[] mergeSortedArrays(int[] arr1, int[] arr2){

        int[] result = new int[arr1.length+arr2.length];
        int index1=0;
        int index2=0;
        int resultIndex=0;

        while(index1 < arr1.length && index2 < arr2.length){
            if(arr1[index1] < arr2[index2]){
                result[resultIndex] = arr1[index1];
                index1++;
            }
            else{
                result[resultIndex] = arr2[index2];
                index2++;
            }
            resultIndex++;
        }
        while (index1 < arr1.length) {
            result[resultIndex] = arr1[index1];
            resultIndex++;
            index1++;
        }
        while (index2 < arr2.length) {
            result[resultIndex] = arr2[index2];
            resultIndex++;
            index2++;
        }

        return result;
    }

    // In place Merge Sort
    private static void getInPlaceMergeSortedArray(int[] arr, int l, int h){

        if(h - l == 1){
            return;
        }

        int mid = (l+h)/2;

        getInPlaceMergeSortedArray(arr, l, mid);
        getInPlaceMergeSortedArray(arr, mid, h);

        mergeSortedArraysInPlace(arr, l, mid, h);
    }

    private static void mergeSortedArraysInPlace(int[] arr, int l, int mid, int h){

        int[] result = new int[h - l];

        int index1=l;
        int index2=mid;
        int resultIndex=0;

        while(index1 < mid && index2 < h){
            if(arr[index1] < arr[index2]){
                result[resultIndex] = arr[index1];
                index1++;
            }
            else{
                result[resultIndex] = arr[index2];
                index2++;
            }
            resultIndex++;
        }
        while (index1 < mid) {
            result[resultIndex] = arr[index1];
            resultIndex++;
            index1++;
        }
        while (index2 < h) {
            result[resultIndex] = arr[index2];
            resultIndex++;
            index2++;
        }
        
        for(int i=0;i<result.length;i++){
            arr[l+i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,4,7,6,3};
        System.out.println("Array before sorting: "+ Arrays.toString(arr));
        System.out.println("Array after sorting: "+Arrays.toString(getMergeSortedArray(arr)));

        System.out.println("Array before sorting: "+ Arrays.toString(arr));
        getInPlaceMergeSortedArray(arr,0,arr.length);
        System.out.println("Array after sorting: "+Arrays.toString(arr));
    }
}
