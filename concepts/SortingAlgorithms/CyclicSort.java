import java.util.Arrays;

public class CyclicSort {

    private static int[] cyclicSort(int[] nums){
        int i=0;
        while (i<nums.length) {
            if(nums[i] == i+1){
                i++;
            }
            else{
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,1,5,4,2};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(cyclicSort(nums1)));
    }
}
