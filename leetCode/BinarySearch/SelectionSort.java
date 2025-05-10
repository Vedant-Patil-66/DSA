import java.util.Arrays;

public class SelectionSort {

    private static int[] selectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int max=0;
            for(int j=0;j<nums.length-i;j++){
                if(nums[max] < nums[j]){
                    max = j;
                }
            }
            int temp = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = nums[max];
            nums[max] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,4,2};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(selectionSort(nums)));
    }
}
