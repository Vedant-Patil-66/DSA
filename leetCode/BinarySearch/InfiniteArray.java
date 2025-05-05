import java.util.Arrays;

public class InfiniteArray {

    public int binarySearchForInfiteArrayWithFixedWindow(int[] arr, int target){
        int fixedWindowSize = 5;
        int start=0;
        int end=fixedWindowSize-1;
        while(target > arr[end]){
            start += fixedWindowSize;
            end += fixedWindowSize; 
        }
        return binarySearch(start, end, arr, target);
    }

    // Binary Search
    public int binarySearch(int start,int end,int[] arr, int target){
        int mid=0;
        while(start<=end){
            mid = (start+end)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public int binarySearchForInfiteArrayWithVariableWindow(int[] arr,int target){
        int start=0;
        int end=1;
        int windowSize=2;
        while(target > arr[end]){
            start = end+1;
            windowSize *= 2;
            end = start + windowSize;
        }
        return binarySearch(start, end, arr, target);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        int target = 6;
        InfiniteArray obj = new InfiniteArray();
        int result1 = obj.binarySearchForInfiteArrayWithFixedWindow(nums, target);
        System.out.println("index: "+result1);
        int result2 = obj.binarySearchForInfiteArrayWithVariableWindow(nums, target);
        System.out.println("index: "+result2);
    }
}
