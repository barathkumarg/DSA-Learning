package Matrix;

/**
 Given a matrix of size n x m, where every row and column is sorted in increasing order, and a number x. Find whether element x is present in the matrix or not.

 Example 1:

 Input:
 n = 3, m = 3, x = 62
 matrix[][] = {{ 3, 30, 38},
 {36, 43, 60},
 {40, 51, 69}}
 Output: 0
 Explanation:
 62 is not present in the matrix,
 so output is 0.

 =======================================  Results =====================================================
 Expected Time Complexity: O(N + M)
 Expected Auxiliary Space: O(1)

**/

public class Problem_2_Row_column_sort_search {
    static boolean search(int matrix[][], int n, int m, int x)
    {

        int start_row = 0;
        int start_column = m-1;
        while( start_row < n && start_column >= 0){

            if(matrix[start_row][start_column] == x) return true;

            if(matrix[start_row][start_column] < x )start_row++;
            //if(matrix[start_row][start_column] == x) return true;
            else start_column--;

        }
        return false;
    }

    public static void main(String[] args) {
        int [][]arr ={{3, 4, 5, 13, 13, 15, 15, 24, 30},
                {13, 14, 19, 19, 27, 31, 32, 33, 35},
                {62, 14, 23, 24, 25, 36, 37, 38, 44},
                {44, 63, 30, 34, 36, 38, 40, 42, 43},
                {47, 55, 65, 36, 39, 40, 41, 42, 51},
                {51, 58, 59, 69, 43, 44, 44, 49, 56},
                {59, 64, 64, 75, 82, 46, 46, 47, 63},
                {64, 66, 67, 70, 85, 89, 54, 57, 58},
                {65, 67, 70, 74, 88, 88, 93, 70, 72},
                {75, 76, 90, 90, 91, 93, 93, 98, 84},
                {85, 93, 95, 96, 97, 97, 99, 100, 100}};
        int n=9;
        int m=9;
        search(arr,n,m,63);
    }




}
