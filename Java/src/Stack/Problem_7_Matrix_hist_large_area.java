package Stack;

import java.util.Arrays;

import static Stack.Problem_5_Find_Max_Area_Rectangle.computeLargestArea;

/**
 Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1's.

 Example:

 Input:
 0 1 1 0
 1 1 1 1
 1 1 1 1
 1 1 0 0
 Output :
 8
 Explanation :
 The largest rectangle with only 1's is from
 (1, 0) to (2, 3) which is
 1 1 1 1
 1 1 1 1

 Intitution: https://www.youtube.com/watch?v=tOylVCugy9k
 **/

public class Problem_7_Matrix_hist_large_area {

    public static void reformatMatrix(int[][] Matrix){

        int row = 1;
        while(row < Matrix.length){
            for(int col=0;col<Matrix[0].length;col++){
                if (Matrix[row][col]!=0){
                    Matrix[row][col] = Matrix[row][col] + Matrix[row-1][col];
                }
            }
            row++;
        }
    }

    public static void main(String[] args) {
        int[][] Matrix = {
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}
        };

        reformatMatrix(Matrix);

        int maxResult = 0;

        for(int row=0;row<Matrix.length;row++) {
            maxResult = Math.max(maxResult, computeLargestArea(Matrix[row]));
        }
        System.out.println("Maximum Area in rectangle "+ maxResult);

    }


}
