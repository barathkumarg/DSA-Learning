package Hashing;

/**
 Given an array of integers. Find if there is a subarray (of size at-least one) with 0 sum.
 You just need to return true/false depending upon whether there is a subarray present with 0-sum or not. Printing will be taken care by the driver code.

 Example 1:

 Input:
 n = 5
 arr = {4,2,-3,1,6}
 Output:
 Yes
 Explanation:
 2, -3, 1 is the subarray with sum 0.

 ======================================= Results ===============================
 Expected Time Complexity: O(n).
 Expected Auxiliary Space: O(n).
 * **/

import java.util.HashSet;

public class Problem_3_subArray_zero_sum {

    static boolean findsum(int arr[],int n)
    {
        //using the implementation of hash set
        HashSet<Integer> hashTable = new HashSet<Integer>();
        int prefixsum = 0;
        //prefix sum logic
        for(int i=0;i<n;i++){
            prefixsum+=arr[i];

            if(prefixsum==0 || hashTable.contains(prefixsum)){
                return true;
            }
            hashTable.add(prefixsum);

        }
        return false;
    }

    public static void main(String[] args) {
        int []arr = {4,2,-3,1,6};
        System.out.println(findsum(arr,arr.length));


    }
}
