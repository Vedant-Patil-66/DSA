import java.util.Arrays;

public class BubbleSort {

    /*
     * Bubble Sort(Stable): 
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
        int[] nums1 = new int[]{3,1,5,4,2};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(bubbleSort(nums1)));
        int[] nums2 = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(bubbleSort(nums2)));
        int[] nums3 = new int[]{5,4,3,2,1};
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(bubbleSort(nums3)));
        int[] nums4 = new int[]{};
        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(bubbleSort(nums4)));
        int[] nums5 = new int[]{1};
        System.out.println(Arrays.toString(nums5));
        System.out.println(Arrays.toString(bubbleSort(nums5)));
    }
}
