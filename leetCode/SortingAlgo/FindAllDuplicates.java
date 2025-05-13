package leetCode.SortingAlgo;

// 442. Find All Duplicates in an Array
/* 
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.
 * You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output
 * 
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * 
 * Example 2:
 * Input: nums = [1,1,2]
 * Output: [1]
 * 
 */
import java.util.ArrayList;
import java.util.List;
public class FindAllDuplicates {
    private List<Integer> findDuplicates(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i] == i+1 || nums[i] == nums[nums[i]-1]){
                i++;
            }
            else{
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicates obj = new FindAllDuplicates();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(obj.findDuplicates(nums));
    }
}


