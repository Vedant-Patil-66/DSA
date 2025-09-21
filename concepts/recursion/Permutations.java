package concepts.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutations {

    private static ArrayList<String> getPermuations(String str, String resultString, int curr){

        ArrayList<String> result = new ArrayList<>();

        if(str.isEmpty()){
            result.add(resultString);
            return result;
        }

        if(curr < str.length()){    
            result.addAll(getPermuations(str, resultString, curr+1));
    
            resultString = resultString + str.charAt(curr);  
            str = str.substring(0,curr) + str.substring(curr+1, str.length());
            result.addAll(getPermuations(str, resultString, 0));
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input String: ");
        String input = sc.next();

        System.out.println("Subset of string : "+ input + " is " + getPermuations(input, "", 0));
        sc.close();
    }
}
