package concepts.BitwiseOperators;

public class BitwiseOperatorsProblems {

    // logic is
    // a^a => 0, so duplicate numbers cancel each other
    private static int uniqueElement(int[] nums){
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            result = result^nums[i];
        }
        return result; 
    }

    // find ith bit
    private static int findithBit(int num, int i){
        int mask = (1 << i);
        return (num & mask) >> i;
    }

    private static int setithBit(int num, int i){
        int mask = (1 << i);
        return (num | mask) >> i;
    }

    private static int resetithBit(int num, int i){
        int mask = ~(1 << i);
        return (num & mask);
    }
    
    private static int findPositionOfRightMostSetBit(int num){
        if(num == 0){
            return -1;
        }
        int pos=0;
        while((num & (1 << pos)) == 0){
            pos++;
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5,5,1,2,3,4}; // All numbers appear twice expect 1 unique number
        System.out.println(uniqueElement(nums));

        int num = 6;
        System.out.println(findithBit(num, 0));

        System.out.println(setithBit(num, 0));

        System.out.println(resetithBit(num, 0));

        System.out.println(findPositionOfRightMostSetBit(num));
    }
}
