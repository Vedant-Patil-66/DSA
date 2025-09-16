package concepts.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Subset {

    private static ArrayList<String> getSubSet(String input, String output){
        if(input.isEmpty()){
            ArrayList<String> result = new ArrayList<String>();
            result.add(output);
            return result;
        }

        ArrayList<String> result = getSubSet(input.substring(1), output);
        result.addAll(getSubSet(input.substring(1), output + input.charAt(0)));
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input String: ");
        String input = sc.next();

        System.out.println("Subset of string : "+ input + " is "+ getSubSet(input, ""));
        sc.close();
    }
}
