package concepts.Recursion;

import java.util.ArrayList;

public class LinearSearch {
    
    private static ArrayList<Integer> linearSearch(int[] arr,int currIndex, int target){
        ArrayList<Integer> result = new ArrayList<>();
        if(currIndex == arr.length){
            return result;
        }
        if(arr[currIndex] == target){
            result.add(currIndex);
        }
        ArrayList<Integer> ans = linearSearch(arr, currIndex+1, target);
        ans.addAll(result);
        return ans;
    }

    public static void main(String[] args){
        int[] arr = new int[]{10,40,20,30,40,40,50};
        ArrayList ans = linearSearch(arr, 0, 40);
        System.out.println(ans);
    }
}
