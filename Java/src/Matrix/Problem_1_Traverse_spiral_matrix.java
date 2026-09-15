package Matrix;
/**
Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output:
1 2 3 4 8 12 16

 ================================================= Result ==========================================
 Expected Time Complexity: O(r*c)
 Expected Auxiliary Space: O(r*c), for returning the answer only.
**/
import java.util.ArrayList;

public class Problem_1_Traverse_spiral_matrix {

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {

        ArrayList<Integer> result = new ArrayList<>();
        int top = 0;
        int right = c;
        int  bottom = r;
        int left = 0;

        while(top < bottom && left < right){
            //traverse top row to column
            for(int i=left;i<right;i++){
                result.add(matrix[top][i]);
            }
            top++;

            //traverse top row to bottom
            for (int i=top;i<bottom;i++){
                result.add(matrix[i][right-1]);
            }
            right --;

            //last column to row
            if(top < bottom) {

                for(int i=right-1;i>=left;i--){
                    result.add(matrix[bottom-1][i]);
                }
                bottom--;
            }

            //last column to row
            if(left < right){
                for(int i=bottom-1;i>=top;i--){
                    result.add(matrix[i][left]);
                }
            }
            left++;

        }
        return result;

    }

    public static void main(String[] args) {

    }
}
