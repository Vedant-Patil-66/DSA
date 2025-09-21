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

        ArrayList<String> result1 = getSubSet(input.substring(1), output);
        ArrayList<String> result2 = getSubSet(input.substring(1), output + input.charAt(0));
        result1.addAll(result2);
        return result1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input String: ");
        String input = sc.next();

        System.out.println("Subset of string : "+ input + " is "+ getSubSet(input, ""));
        sc.close();
    }
}
