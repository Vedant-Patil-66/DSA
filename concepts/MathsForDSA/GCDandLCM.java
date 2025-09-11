package concepts.MathsForDSA;

import java.util.Scanner;

public class GCDandLCM {
    
    private static int getGCD(int a,int b){
        if(a == 0){
            return b;
        }
        return getGCD(b%a, a);
    }

    private static int getLCM(int a,int b){
        return (a*b)/getGCD(a,b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter Number2: ");
        int num2 = sc.nextInt();
        System.out.println("GCD of "+num1+" & "+num2+" is " +getGCD(num1, num2));
        System.out.println("LCM of "+num1+" & "+num2+" is " +getLCM(num1, num2));
    }
}
