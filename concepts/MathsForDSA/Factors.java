package concepts.MathsForDSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Factors {
    
    private static ArrayList<Integer> getFactors(int n){
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n) ;i++) {
            if(n % i == 0){
                if(n/i == i){
                    result.add(i);
                }else{
                    result.add(i);
                    result.add(n/i);
                }
            } 
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();
        System.out.println(getFactors(num));
        sc.close();
    }
}
