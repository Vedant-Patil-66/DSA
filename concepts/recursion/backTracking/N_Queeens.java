package concepts.recursion.backTracking;

import java.util.Scanner;

public class N_Queeens {
    
    // we are going column wise i.e. we will put queen in colums wise one after another
    private static int getBoardWithNQueens(int currCol, boolean[][] isReserved){
        if(currCol == isReserved[0].length){
            displayBoard(isReserved);
            return 1;
        }

        int count = 0;
        for (int currRow = 0; currRow < isReserved.length; currRow++) {
            if(isSafe(currRow,currCol,isReserved)){
                isReserved[currRow][currCol] = true;
                count += getBoardWithNQueens(currCol+1, isReserved);
                isReserved[currRow][currCol] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(int currRow, int currCol, boolean[][] isReserved){
        // check row 
        for (int i = 0; i < currCol; i++) {
            if(isReserved[currRow][i]){
                return false;
            }
        }

        // diagonal up
        int maxUpLeft = Math.min(currRow, currCol);
        for (int i = 1; i <= maxUpLeft; i++) {
            if(isReserved[currRow-i][currCol-i]){
                return false;
            }
        }

        // diagonal down
        int maxDownLeft = Math.min(isReserved.length - 1 - currRow, currCol);
        for (int i = 1; i <= maxDownLeft; i++) {
            if(isReserved[currRow+i][currCol-i]){
                return false;
            }
        }

        return true;
    }

    private static void displayBoard(boolean[][] isReserved){
        for (int i = 0; i < isReserved.length; i++) {
            for (int j = 0; j < isReserved.length; j++) {
                if(isReserved[i][j]){
                    System.out.print('Q');
                }
                else{
                    System.out.print('_');
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dimension: ");
        int dimension = sc.nextInt();

        // deafult value is false
        boolean[][] isReserved = new boolean[dimension][dimension];

        System.out.println("Number of ways: "+getBoardWithNQueens(0,isReserved));

        sc.close();
    }
}
