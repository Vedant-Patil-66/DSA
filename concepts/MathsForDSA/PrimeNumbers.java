package concepts.MathsForDSA;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumbers {

    private static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        
        for(int i=2;i*i<=n;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    // more optimized
    private static ArrayList<Integer> AllPrimeTillNum(int num){

        if(num <= 1) return new ArrayList<>();
        boolean[] arr = new boolean[num];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = true;
        }
        
        int i=2; 
        while (i < num) {
            if(arr[i-1] == true){
                int j=i*2;
                int count = 2;
                while(j<=num){
                    arr[j-1] = false;
                    count++;
                    j = i * count;
                }
            }
            i++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int k=0;k<arr.length;k++){
            if(arr[k] == true){
                result.add(k+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();
        for (int i = 0; i <= num; i++) {
            // System.out.println(i+" : "+isPrime(i));
            
            if(isPrime(i)){
                System.out.println(i);
            }
        }

        System.out.println(AllPrimeTillNum(num));
    }
}
