package Sorting;
import java.util.Arrays;

/**
 Given an array arr[] of n integers. Check whether it contains a triplet that sums up to zero.

 Note: Return 1, if there is at least one triplet following the condition else return 0.

 Example 1:

 Input: n = 5, arr[] = {0, -1, 2, -3, 1}
 Output: 1
 Explanation: 0, -1 and 1 forms a triplet
 with sum equal to 0


 <=================================== Implementation ========================>
 Two poniter approach with triplets


 <================================= Results =========================>
 Expected Time Complexity: O(n2)
 Expected Auxiliary Space: O(1)

 **/


public class Problem_13_Triplet_count_zero {
    //Function to find triplets with zero sum.
    public static boolean findTriplets(int A[] , int n) {
        Arrays.sort(A);

        //if(arr[start] + arr[end] > 0) return false;

        for (int i = 0; i < n-1; i++) {
            int start = i + 1;
            int end = n-1;
            while (end > start) {

                int result = A[start] + A[end] + A[i];

                if(result == 0) return true;
                else if(result > 0) end --;
                else start++;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int[] arr ={60,-65,5,-21,8,93};
        System.out.println(findTriplets(arr,6));
    }
}
