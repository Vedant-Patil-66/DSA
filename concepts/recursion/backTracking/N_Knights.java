package concepts.recursion.backTracking;

import java.util.Scanner;

public class N_Knights {

    private static int getBoardWithNKnights(int currRow, int currCol, boolean[][] isReserved, int knights){
        
        // Base Case 1: All knights are placed.
        if(knights == 0){
            displayBoard(isReserved);
            return 1;
        }

        // Base Case 2: We've exhausted the board.
        if(currRow == isReserved.length){
            return 0;
        }

        // Calculate next row and column
        // condition ? ifTrue : ifFalse
        int nextRow = currCol == isReserved.length - 1 ? currRow + 1 : currRow;
        int nextCol = currCol == isReserved.length - 1 ? 0 : currCol + 1;

        int count = 0;
        
        // Option 1: Place a knight if it's safe
        if (isSafe(currRow, currCol, isReserved)) {
            isReserved[currRow][currCol] = true;
            count += getBoardWithNKnights(nextRow, nextCol, isReserved, knights - 1);
            isReserved[currRow][currCol] = false; // Backtrack
        }
        
        // Option 2: Skip the current cell
        count += getBoardWithNKnights(nextRow, nextCol, isReserved, knights);

        return count;
    }

    // one knight can travel 8 positions
    private static boolean isSafe(int currRow, int currCol, boolean[][] isReserved){

        // check 2 up and 1 right, same as 1 right and 2 up
        if(isValid(currRow-2, currCol+1, isReserved) && isReserved[currRow-2][currCol+1]){
            return false;
        }

        // check 1 up and 2 right
        if(isValid(currRow-1, currCol+2, isReserved) && isReserved[currRow-1][currCol+2]){
            return false;
        }

        // check 2 left and 1 up
        if(isValid(currRow-1, currCol-2, isReserved) && isReserved[currRow-1][currCol-2]){
            return false;
        }
        
        // check 1 left and 2 up
        if(isValid(currRow-2, currCol-1, isReserved) && isReserved[currRow-2][currCol-1]){
            return false;
        }
        
        // no need to check down, because we haven't placed knight there yet
        // check 2 right and 1 down
        // if(isValid(currRow+1, currCol+2, isReserved) && isReserved[currRow+1][currCol+2]){
        //     return false;
        // }

        // // check 1 right and 2 down
        // if(isValid(currRow+2, currCol+1, isReserved) && isReserved[currRow+2][currCol+1]){
        //     return false;
        // }

        // // check 2 down and 1 left
        // if(isValid(currRow+2, currCol-1, isReserved) && isReserved[currRow+2][currCol-1]){
        //     return false;
        // }

        // // check 1 down and 2 left
        // if(isValid(currRow+1, currCol-2, isReserved) && isReserved[currRow+1][currCol-2]){
        //     return false;
        // }
        return true;
    }

    private static boolean isValid(int currRow, int currCol, boolean[][] isReserved){
        if(currRow >= 0 && currRow < isReserved.length && currCol >= 0 && currCol < isReserved.length){
            return true;
        }
        return false;
    }

    private static void displayBoard(boolean[][] isReserved){
        for (int i = 0; i < isReserved.length; i++) {
            for (int j = 0; j < isReserved.length; j++) {
                if(isReserved[i][j]){
                    System.out.print('K');
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

        System.out.println("Number of ways: "+ getBoardWithNKnights(0, 0,isReserved,dimension));

        sc.close();
    }
}
