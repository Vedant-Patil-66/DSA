package concepts.BitwiseOperators;

import java.util.Scanner;

public class MagicNumber {

    /*Magic Number: power of 5, at every bit and its addition
    * (001) ==> 0+0+5 = 5
    * (010) ==> 0+25+0 = 25
    * (011) ==> 0+25+5 = 30
    * (100) ==> 125+0+0 = 125
    * (101) ==> 125+0+5 = 130
    * (111) ==> 125+25+5 = 155
    */
    private static int findMagicNumber(int num){
        int result = 0;
        int base=5;
        while (num > 0) {
            int lastDigit = num & 1;
            result += (lastDigit * base);
            base *= 5;
            num = num >> 1;
        }
        return result; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();
        System.out.println(findMagicNumber(num));
    }
}
