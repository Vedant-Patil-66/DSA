package concepts.recursion.strings;

import java.util.Scanner;

public class SkipACharacter {

    private static String getStringwithSkippedChar(Character charToSkip, String input){
        if(input.isEmpty()){
            return "";
        }

        if(input.charAt(0) != charToSkip){
            return input.charAt(0) + getStringwithSkippedChar(charToSkip, input.substring(1)); 
        }
        
        return getStringwithSkippedChar(charToSkip, input.substring(1));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input String: ");
        String input = sc.next();
        System.out.print("Enter char to skip: ");
        Character charToskip = sc.next().charAt(0);

        System.out.println("String after skipping character: "+getStringwithSkippedChar(charToskip, input));
        sc.close();
    }
}
