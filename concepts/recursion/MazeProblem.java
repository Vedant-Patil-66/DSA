package concepts.recursion;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Taking only 3 ways to travel - Right, Down, Diagonal
 * Here we go from (row,col) to (1,1) i.e. (maze.length,maze.length)
 */
public class MazeProblem {

    private static int getNumberOfPaths(int currRow, int currCol){

        if(currRow == 1 || currCol == 1){
            return 1;
        }
        
        return getNumberOfPaths(currRow, currCol-1) + getNumberOfPaths(currRow-1, currCol) + getNumberOfPaths(currRow-1, currCol-1);
    }

    private static void printPaths(String processed, int currRow, int currCol){

        if(currRow == 1 && currCol == 1){
            System.out.println(processed);
            return;
        }

        if(currRow > 1){
            // go down
            printPaths(processed + "D", currRow-1, currCol);
        }
        if(currCol > 1){
            // go right
            printPaths(processed + "R", currRow, currCol-1);
        }
        if (currRow > 1 && currCol > 1) {
            // go diagonal
            printPaths(processed + "Dia", currRow-1, currCol-1);
        }
    }

    private static ArrayList<String> addPathstoList(String processed, int currRow, int currCol){
        
        ArrayList<String> result = new ArrayList<>();
        if(currRow == 1 && currCol == 1){
            result.add(processed);
            return result;
        }

        if(currRow > 1){
            // go down
            result.addAll(addPathstoList(processed + "D ", currRow-1, currCol));
        }
        if(currCol > 1){
            // go right
            result.addAll(addPathstoList(processed + "R ", currRow, currCol-1));
        }
        if (currRow > 1 && currCol > 1) {
            // go diagonal
            result.addAll(addPathstoList(processed + "Dia ", currRow-1, currCol-1));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row: ");
        int row = sc.nextInt();
        System.out.print("Enter col: ");
        int col = sc.nextInt();

        int count = getNumberOfPaths(row, col);
        System.out.println("Number of ways: "+count);

        ArrayList<String> result = addPathstoList("",row,col);
        System.out.println("Paths: " + result);
        printPaths("",row,col);

        sc.close();
    }
}
