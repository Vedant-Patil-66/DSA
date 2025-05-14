package leetCode.SortingAlgo;

import java.util.ArrayList;
import java.util.List;

/*
 * 448: Find all numbers disappeared in an array
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array 
 * of all the integers in the range [1, n] that do not appear in nums.
 * 
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * 
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 */
public class FindAllNumberDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(arr[nums[i]-1] == false){
                arr[nums[i]-1] = true;
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(arr[i] == false){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllNumberDisappeared obj = new FindAllNumberDisappeared();
        int[] nums = new int[]{ 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(obj.findDisappearedNumbers(nums));
    }
}
