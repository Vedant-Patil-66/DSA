package concepts.recursion;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Taking only 2 ways to travel
 * Here we go from (row,col) to (1,1) i.e. (maze.length,maze.length)
 */
public class MazeProblemWithObstacles {

    private static int countPath(int row, int col, int obstacleRow, int obstacleCol){

        if(row == 1 && col == 1){
            return 1;
        }

        if(row == obstacleRow && col == obstacleCol){
            return 0;
        }

        int count=0;
        if(row > 1){
            count += countPath(row-1, col, obstacleRow, obstacleCol);
        }
        if(col > 1){
            count += countPath(row, col-1, obstacleRow, obstacleCol);
        }
        return count;
    }

    private static void printPaths(String path, int row, int col, int obstacleRow, int obstacleCol){

        if(row == 1 && col == 1){
            System.out.println(path);
            return;
        }

        if(row == obstacleRow && col == obstacleCol){
            return;
        }

        if(row > 1){
            //go down
            printPaths(path+"D", row-1, col, obstacleRow, obstacleCol);
        }

        if(col > 1){
            //go down
            printPaths(path+"R", row, col-1, obstacleRow, obstacleCol);
        }
    }

    private static ArrayList<String> addPathstoList(String path, int row, int col, int obstacleRow, int obstacleCol){

        if(row == 1 && col == 1){
            ArrayList<String> result = new ArrayList<>();
            result.add(path);    
            return result;
        }

        if(row == obstacleRow && col == obstacleCol){
            return new ArrayList<String>();
        }

        ArrayList<String> result = new ArrayList<>();
        if(row > 1){
            //go down
            result.addAll(addPathstoList(path+"D", row-1, col, obstacleRow, obstacleCol));
        }

        if(col > 1){
            //go down
            result.addAll(addPathstoList(path+"R", row, col-1, obstacleRow, obstacleCol));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter row: ");
        // int row = sc.nextInt();
        // System.out.print("Enter col: ");
        // int col = sc.nextInt();

        // Lets take
        int row = 3;
        int col = 3;

        int obstacleRow = 3;
        int obstacleCol = 1;

        System.out.println("Number of paths: "+ countPath(row,col,obstacleRow,obstacleCol));
        
        ArrayList<String> result = addPathstoList("",row,col,obstacleRow,obstacleCol);
        System.out.println("Paths: " + result);

        printPaths("", row, col, obstacleRow, obstacleCol);

        sc.close();
    }
}
