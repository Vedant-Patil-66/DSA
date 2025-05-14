package leetCode.SortingAlgo;

/*
 * 268. Missing Number
 * Given an array nums containing n distinct numbers in the range [0, n], return the only 
 * number in the range that is missing from the array.
 *  Example 1:
  *  Input: nums = [3,0,1]
  *  Output: 2
  *
  *  Example 2:
  *  Input: nums = [0,1]
  *  Output: 2
  *
  *  Example 3:
  *  Input: nums = [9,6,4,2,3,5,7,0,1]
  *  Output: 8
  * 
  * 
  */

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i || nums[i] == nums.length) {
                i++;
            } else {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == nums.length) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        int[] nums = new int[] {3,0,1};
        System.out.println(obj.missingNumber(nums));
    }
}
