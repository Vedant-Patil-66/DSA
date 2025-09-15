package concepts.BitwiseOperators;

import java.util.Scanner;

public class Power {
    private static int findApowerB(int a, int b){
        int result = 1;
        int base = a;
        while(b > 0){
            int lastDigitOfb = b & 1; // & with 1 gives last digit
            if(lastDigitOfb == 1){
                result = result * base * lastDigitOfb;
            }
            base = base * base;
            b = b >> 1; // right-shift removes last digit
        }
        return result; 
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter Number2: ");
        int num2 = sc.nextInt();
        System.out.println(findApowerB(num1,num2));
        sc.close();
    }
}
