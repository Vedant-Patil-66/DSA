package concepts.MathsForDSA;

import java.util.Scanner;

public class SquareRoot {

    private static double squareRootWithPDecimal(int n, int p){

        // first find integer sqrt
        // Apply BinarySearch
        double integerSqrt=0;
        int l = 0;
        int h = n;
        while (l <= h) {
            int mid = (l+h)/2;
            if(mid*mid == n){
                return mid;
            }
            if(mid*mid > n){
                h = mid - 1;
            }
            else{
                integerSqrt = mid; // storing mid, because it can also be an answer
                l = mid + 1;
            }
        }

        double decimal = 0.1;
        for(int j=0;j<p;j++){
            double temp = integerSqrt;
            for (int i = 1; i < 10; i++) {
                temp += decimal*i;
                if(temp * temp > n){
                    break;
                }
                integerSqrt = temp;
            }
            decimal /= 10;
        }

        return integerSqrt;
    }

    private static double newtonRaphsonSqrt(int n){
        double x=n;
        double root;

        while(true){
            root = 0.5 * (x+n/x);
            if(Math.abs(root-x) < 0.1){
                break;
            }
            x = root;
        }
        return root;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();
        // System.out.print("Enter decimal points required: ");
        // int num2 = sc.nextInt();
        // System.out.print(squareRootWithPDecimal(num,num2));
        System.out.println(newtonRaphsonSqrt(num));
    }
}
