public class FindInMountainArray {

    int[] arr;

    FindInMountainArray(int[] arr){
        this.arr = arr;
    }
    
    private int length(){
        return this.arr.length;
    }

    private int get(int k){
        return arr[k];
    }

    // finding peak element
    private int findPeakElement(FindInMountainArray mountainArr) {
        int l = 0;
        int h = mountainArr.length()-1;

        while (l < h) {
            int mid = (l + h) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    //  order => 
    //      true: ascending
    //      false: descending
    private int binarySearch(int l, int h, FindInMountainArray mountainArr, int target,boolean order) {
        if(order == true){
            while (l <= h) {
                int mid = (l + h) / 2;
                if (mountainArr.get(mid) == target) {
                    return mid;
                } else if (mountainArr.get(mid) > target) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        else{
            while (l <= h) {
                int mid = (l + h) / 2;
                if (mountainArr.get(mid) == target) {
                    return mid;
                } else if (mountainArr.get(mid) > target) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, FindInMountainArray mountainArr) {
        int peakElement = findPeakElement(mountainArr);
        int result = binarySearch(0, peakElement, mountainArr, target, true);
        if (result == -1) {
            return binarySearch(peakElement + 1, mountainArr.length()-1, mountainArr, target, false);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5,3,1};
        int target1 = 3;
        FindInMountainArray obj1 = new FindInMountainArray(nums1);
        int result1 = obj1.findInMountainArray(target1,obj1);
        System.out.println("index: "+result1); // 2
        
        int[] nums2 = new int[]{0,1,2,4,2,1};
        int target2 = 3;
        FindInMountainArray obj2 = new FindInMountainArray(nums2);
        int result2 = obj2.findInMountainArray(target2,obj2);
        System.out.println("index: "+result2); // -1
    }
}
