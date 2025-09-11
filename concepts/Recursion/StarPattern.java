package concepts.Recursion;

import java.util.Scanner;

/*
 *  Pattern: 
 *  ****
 *  ***
 *  **
 *  *
 */

public class StarPattern {
    
    private static void printStarPattern(int row, int col){
        if(row == 0){
            return;
        }

        if (row > col) {
            System.out.print("*");
            printStarPattern(row, col+1);
        }
        else{
            System.out.println();
            printStarPattern(row-1, 0);
        }
    }

    private static void printStarPattern2(int row, int col){
        if(row == 0){
            return;
        }

        if (col < row) {
            printStarPattern2(row, col+1);
            System.out.print("*");
        }
        else{
            printStarPattern2(row-1, 0);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num1 = sc.nextInt();
        printStarPattern(num1,0);
        printStarPattern2(num1,0);
        sc.close();
    }
}
