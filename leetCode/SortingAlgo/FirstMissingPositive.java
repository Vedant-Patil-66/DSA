package leetCode.SortingAlgo;


/*
 * 41. First missing positive number
 * Given an unsorted integer array nums. Return the smallest positive integer that is not 
 * present in nums.
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        int i=0;
        for(i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();
        int[] nums = new int[] {3,4,-1,1,0};
        System.out.println(obj.firstMissingPositive(nums));
    }
}
