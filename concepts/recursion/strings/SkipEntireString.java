package concepts.recursion.strings;

import java.util.Scanner;

public class SkipEntireString {
    
    private static String getSkippedString(String stringToSkip, String input){

        if(input.isEmpty()){
            return "";
        }

        if(input.startsWith(stringToSkip)){
            return getSkippedString(stringToSkip, input.substring(stringToSkip.length()));
        }
        else{
            return input.charAt(0) + getSkippedString(stringToSkip, input.substring(1));
        }
    }

    // required string
    private static String skipAppNotApple(String input){

        if(input.isEmpty()){
            return "";
        }

        if(input.startsWith("app") && !input.startsWith("apple")){
            return skipAppNotApple(input.substring(3));
        }

        return input.charAt(0) + skipAppNotApple(input.substring(1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input String: ");
        String input = sc.next();
        System.out.print("Enter char to skip: ");
        String stringToskip = sc.next();

        System.out.println("String after skipping character: "+getSkippedString(stringToskip, input));
        
        System.out.print("Enter apple wali String: ");
        String appleString = sc.next();
        System.out.println("String after skipping app not apple: "+skipAppNotApple(appleString));
        sc.close();

    }
}
