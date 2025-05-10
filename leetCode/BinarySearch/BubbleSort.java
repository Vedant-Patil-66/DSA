import java.util.Arrays;

public class BubbleSort {

    /*
     * Bubble Sort: 
     *  Time Complexity(Worst case) == O(n^2)
     *  Time Complexity(Best case) == O(n)
     *  We try to push the largest element to end and reduce sorting space by 1 from end
     *  every iteration
     */
    private static int[] bubbleSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j+1] < nums[j]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,4,2};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(bubbleSort(nums)));
    }
}
