package Arrays_;


/**
 Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute
 how much water can be trapped between the blocks during the rainy season.

 link: https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
 Example 1:

 Input:
 N = 6
 arr[] = {3,0,0,2,0,4}
 Output:
 10
 Explanation:

 */

public class Problem_3_Water_trap_problem {

    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) {

        long result = 0;
        int[] leftMostWall = new int[n];
        int[] rightMostWall = new int[n];

        leftMostWall[0] = arr[0];

        // Find the leftmost peek wall height
        for (int i=1;i<n;i++){

            leftMostWall[i] = Math.max(leftMostWall[i-1],arr[i]);
        }
        // Find the right most peek wall height
        rightMostWall[n-1] = arr[n-1];

        for (int i=n-2;i>=0;i--){

            rightMostWall[i] = Math.max(rightMostWall[i+1],arr[i]);
        }

        //Calculate the water filled height
        for (int i=1;i<n-1;i++){
            result += Math.min(leftMostWall[i],rightMostWall[i]) - arr[i];

        }

        return result;


    }

    public static void main(String[] args) {
        int[] arr = {2,1,0,9};
        int n = 4;
        System.out.println(trappingWater(arr,n));

    }
}
