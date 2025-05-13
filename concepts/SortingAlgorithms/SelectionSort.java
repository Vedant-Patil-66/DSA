import java.util.Arrays;

public class SelectionSort {


    /*
     * Selection Sort(Unstable):
     *  Time Complexity(Worst case) == O(n^2)
     *  Time Complexity(Best case) == O(n^2)
     *  Here, we select the maximum/minimum element from the array and swap it to last/first 
     *  element respectively and then reduce the sorting space accordingly.  
     */
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
        int[] nums1 = new int[]{3,1,5,4,2};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(selectionSort(nums1)));
        int[] nums2 = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(selectionSort(nums2)));
        int[] nums3 = new int[]{5,4,3,2,1};
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(selectionSort(nums3)));
        int[] nums4 = new int[]{};
        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(selectionSort(nums4)));
        int[] nums5 = new int[]{1};
        System.out.println(Arrays.toString(nums5));
        System.out.println(Arrays.toString(selectionSort(nums5)));
    }
}
