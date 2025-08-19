package concepts.BitwiseOperators;

import java.util.Scanner;

public class NumberOfSetBites {
    private static int numberOfSetBites(int num){
        int result = 0;
        while (num > 0) {
            int lastDigit = num & 1;
            if (lastDigit == 1) {
                result++;
            }
            num = num >> 1;
        }
        return result; 
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();
        System.out.println(numberOfSetBites(num));
        System.out.println(Integer.toBinaryString(num));
    }
}
