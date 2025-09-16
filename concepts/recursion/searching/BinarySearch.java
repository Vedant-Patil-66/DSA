package concepts.recursion.searching;

public class BinarySearch {
    private static int search(int[]arr, int l, int h, int target){
        if(l>h){
            return -1;
        }
        int mid = (l+h)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            return search(arr, mid+1, h, target);
        }
        else{
            return search(arr, l, mid-1, target);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7};
        int result1 = search(arr, 0, arr.length-1, 3);
        System.out.println("result1: "+result1);
        int result2 = search(arr, 0, arr.length-1, 0);
        System.out.println("result1: "+result2);
        int result3 = search(arr, 0, arr.length-1, 8);
        System.out.println("result1: "+result3);
    }
}
