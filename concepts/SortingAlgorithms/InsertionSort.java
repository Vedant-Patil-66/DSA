import java.util.Arrays;

public class InsertionSort {

    /*
     * Insertion Sort:
     *  Time Complexity(Worst Case) == O(n^2)
     *  Time Complexity(Best Case) == O(n)
     */
    private static int[] insertionSort(int[] nums){

        // Sorting from end
        // for(int i=0;i<nums.length;i++){
        //     int currElementToInsert = nums[0];
        //     int curr;
        //     for(curr=0;curr<nums.length-i-1;curr++){
        //         nums[curr] = nums[curr+1];
        //     }
        //     while(curr < nums.length-1 && nums[curr+1] < currElementToInsert){
        //         nums[curr] = nums[curr+1];
        //         curr++;
        //     }
        //     nums[curr] = currElementToInsert;
        // } 


        // Sorting form start
        for(int i=1;i<nums.length;i++){
            int currElementToInsert = nums[i];
            int curr = 0;
            while(curr < i && nums[curr]<currElementToInsert){
                curr++;
            }
            int j = i;
            while (j > curr) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[curr] = currElementToInsert;
        }
        return nums;
    }
    
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,1,5,4,2};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(insertionSort(nums1)));
        int[] nums2 = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(insertionSort(nums2)));
        int[] nums3 = new int[]{5,4,3,2,1};
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(insertionSort(nums3)));
        int[] nums4 = new int[]{};
        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(insertionSort(nums4)));
        int[] nums5 = new int[]{1};
        System.out.println(Arrays.toString(nums5));
        System.out.println(Arrays.toString(insertionSort(nums5)));
    }
}
