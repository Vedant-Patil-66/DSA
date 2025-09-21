package concepts.recursion.backTracking;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * All paths, except the path where we came from(tracked using univisted array)
 * Here we go from (0,0) to (maze.length - 1,maze.length - 1)
 */
public class MazeProblemWithAllPaths {

    // return total number of paths
    private static int countPath(Boolean[][] unvisited, int currRow, int currCol){

        if(currRow == unvisited.length-1 && currCol == unvisited[0].length-1){
            return 1;
        }

        int count = 0;
        unvisited[currRow][currCol] = true;
        if(currRow < unvisited.length-1 && !unvisited[currRow+1][currCol]){
            // go down
            count += countPath(unvisited, currRow+1, currCol);
        }

        if(currRow > 0 && !unvisited[currRow-1][currCol]){
            // go up
            count += countPath(unvisited, currRow-1, currCol);
        }

        if(currCol < unvisited[0].length-1 && !unvisited[currRow][currCol+1]){
            // go right
            count += countPath(unvisited, currRow, currCol+1);
        }
        
        if(currCol > 0 && !unvisited[currRow][currCol-1]){
            // go left
            count += countPath(unvisited, currRow, currCol-1);
        }
        unvisited[currRow][currCol] = false;
        return count;
    }

    // print all paths
    private static void printPaths(Boolean[][] unvisited, String path, int currRow, int currCol){

        if(currRow == unvisited.length-1 && currCol == unvisited[0].length-1){
            System.out.println(path);
            return;
        }

        unvisited[currRow][currCol] = true;
        if(currRow < unvisited.length-1 && !unvisited[currRow+1][currCol]){
            // go down
            printPaths(unvisited, path+"D", currRow+1, currCol);
        }

        if(currRow > 0 && !unvisited[currRow-1][currCol]){
            // go up
            printPaths(unvisited, path+"U", currRow-1, currCol);
        }

        if(currCol < unvisited[0].length-1 && !unvisited[currRow][currCol+1]){
            // go right
            printPaths(unvisited, path+"R", currRow, currCol+1);
        }
        
        if(currCol > 0 && !unvisited[currRow][currCol-1]){
            // go left
            printPaths(unvisited, path+"L", currRow, currCol-1);
        }
        unvisited[currRow][currCol] = false;
    }

    // print paths along with PathArray
    private static void printPathsAndPathArray(Boolean[][] unvisited, String path, int currRow, int currCol, int pathLen, int[][] pathArray){

        if(currRow == unvisited.length-1 && currCol == unvisited[0].length-1){
            System.out.println(path +" "+ pathLen);

            pathArray[currRow][currCol] = pathLen;
            for (int[] arr : pathArray) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }

        unvisited[currRow][currCol] = true;
        pathArray[currRow][currCol] = pathLen;
        if(currRow < unvisited.length-1 && !unvisited[currRow+1][currCol]){
            // go down
            printPathsAndPathArray(unvisited, path+"D", currRow+1, currCol, pathLen+1, pathArray);
        }

        if(currRow > 0 && !unvisited[currRow-1][currCol]){
            // go up
            printPathsAndPathArray(unvisited, path+"U", currRow-1, currCol, pathLen+1, pathArray);
        }

        if(currCol < unvisited[0].length-1 && !unvisited[currRow][currCol+1]){
            // go right
            printPathsAndPathArray(unvisited, path+"R", currRow, currCol+1, pathLen+1, pathArray);
        }
        
        if(currCol > 0 && !unvisited[currRow][currCol-1]){
            // go left
            printPathsAndPathArray(unvisited, path+"L", currRow, currCol-1, pathLen+1, pathArray);
        }
        unvisited[currRow][currCol] = false;
        pathArray[currRow][currCol] = 0;
    }

    // add paths to list and return list
    private static ArrayList<String> addPathsToList(Boolean[][] unvisited, String path, int currRow, int currCol){

        if(currRow == unvisited.length-1 && currCol == unvisited[0].length-1){
            ArrayList<String> result = new ArrayList<>();
            result.add(path);
            return result;
        }

        ArrayList<String> result = new ArrayList<>();
        unvisited[currRow][currCol] = true;
        if(currRow < unvisited.length-1 && !unvisited[currRow+1][currCol]){
            // go down
            result.addAll(addPathsToList(unvisited, path+"D", currRow+1, currCol));
        }

        if(currRow > 0 && !unvisited[currRow-1][currCol]){
            // go up
            result.addAll(addPathsToList(unvisited, path+"U", currRow-1, currCol));
        }

        if(currCol < unvisited[0].length-1 && !unvisited[currRow][currCol+1]){
            // go right
            result.addAll(addPathsToList(unvisited, path+"R", currRow, currCol+1));
        }
        
        if(currCol > 0 && !unvisited[currRow][currCol-1]){
            // go left
            result.addAll(addPathsToList(unvisited, path+"L", currRow, currCol-1));
        }
        unvisited[currRow][currCol] = false;
        
        return result;
    }

    public static void main(String[] args) {

        // for simplicity, lets take 3x3 maze
        Boolean[][] unvisited = new Boolean[][]{
            {false,false,false},
            {false,false,false},
            {false,false,false}
        };

        System.out.println("Total paths: " + countPath(unvisited, 0, 0));
        System.out.println("Path List: " + addPathsToList(unvisited, "", 0, 0));

        int[][] pathArray = new int[][]{
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        printPaths(unvisited, "", 0, 0);
        printPathsAndPathArray(unvisited, "", 0, 0, 0, pathArray);
    }
}
