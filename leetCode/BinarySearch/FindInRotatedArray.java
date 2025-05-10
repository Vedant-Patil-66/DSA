public class FindInRotatedArray {
    int findTopElement(int[] nums){
        int l=0;
        int h=nums.length-1;
        while(l < h){
            int mid = (l + h) / 2;
            if(nums[mid] > nums[h]){
                l = mid + 1;
            } else {
                h = mid; // include mid as possible minimum
            }
        }
        return l; // l is index of smallest element
    }

    int binarySearch(int[] nums, int target, int l, int h){
        while(l <= h){
            int mid = (l+h)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if(nums.length == 1){
            return target == nums[0] ? 0:-1;
        }
        int topElement = findTopElement(nums);
        // System.out.println("Pivot: "+ topElement);

        if(binarySearch(nums,target,0,topElement) == -1){
            return binarySearch(nums,target,topElement,nums.length-1);
        }
        return binarySearch(nums,target,0,topElement);
    }

    private int numberOfTimesArrayIsRotated(int[] nums){
        return findTopElement(nums);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,5,6,7,0,1,2};
        int target1 = 0;
        FindInRotatedArray obj1 = new FindInRotatedArray();
        int result1 = obj1.search(nums1,target1);
        System.out.println("index: "+result1); // 4
        System.out.println("Number of times array is rotated: "+obj1.numberOfTimesArrayIsRotated(nums1));
        
        int[] nums2 = new int[]{4,5,6,7,0,1,2};
        int target2 = 3;
        FindInRotatedArray obj2 = new FindInRotatedArray();
        int result2 = obj2.search(nums2,target2);
        System.out.println("index: "+result2); // -1
        System.out.println("Number of times array is rotated: "+obj2.numberOfTimesArrayIsRotated(nums2));
        
        int[] nums3 = new int[]{2,9,2,2,2};
        int target3 = 9;
        FindInRotatedArray obj3 = new FindInRotatedArray();
        int result3 = obj3.search(nums3,target3);
        System.out.println("index: "+result3); // 1
        System.out.println("Number of times array is rotated: "+obj3.numberOfTimesArrayIsRotated(nums3));
        
        int[] nums4 = new int[]{15,18,2,3,6,12};
        int target4 = 9;
        FindInRotatedArray obj4 = new FindInRotatedArray();
        int result4 = obj4.search(nums4,target4);
        System.out.println("index: "+result4); // 1
        System.out.println("Number of times array is rotated: "+obj4.numberOfTimesArrayIsRotated(nums4));
    }   
}
