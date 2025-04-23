import java.util.Arrays;

class FirstAndLastOccurence {

    private int possibleAnswer(int[] nums, int target, boolean firstOrLast){
        int l=0;
        int h=nums.length-1;
        int mid;
        int ans=-1;
        while(l<=h){
            mid = (l+h)/2;
            if(nums[mid] == target){
                ans = mid;
                if(firstOrLast){
                    h = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else if(nums[mid] < target){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = possibleAnswer(nums,target,true);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = possibleAnswer(nums,target,false);
        return new int[]{first,last};
    }

    // main method
    public static void main(String[] args) {
        int[] nums1 = new int[]{5,7,7,8,8,10}; // output == [3,4]
        int target1 = 8;
        FirstAndLastOccurence obj = new FirstAndLastOccurence();
        int[] result1 = obj.searchRange(nums1,target1);
        // we will get address if directly pass "result1" as when you try to concatenate an array with a string, Java calls the toString() method on the array. The default toString() for arrays doesn't print the contents—it prints the type and hashcode, like [I@15db9742.
        System.out.println("Output1: "+ Arrays.toString(result1));
    }
}
