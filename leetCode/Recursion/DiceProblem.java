package leetCode.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class DiceProblem {
    
    private static void getPermuations(int expectedSum, int currSum, ArrayList<Integer> currList, ArrayList<ArrayList<Integer>> result){
        // we have 6 choices, we can choose 1 of them at every step

        if(currSum == expectedSum){
            result.add(currList);
            currList = new ArrayList<>();
            return;
        }

        if(currSum > expectedSum){
            currList = new ArrayList<>();            
            return;
        }

        for (int i = 1; i <= 6; i++) {
            ArrayList<Integer> tempCurrList = new ArrayList<>(currList);
            int tempCurrSum = currSum + i;
            tempCurrList.add(i);
            getPermuations(expectedSum, tempCurrSum, tempCurrList, result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expected sum: ");
        int expectedSum = sc.nextInt();

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        getPermuations(expectedSum, 0, new ArrayList<Integer>(), result);
        System.out.println("ANS: "+result);
        sc.close();
    }
}
