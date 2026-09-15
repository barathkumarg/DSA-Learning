package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 Given an unsorted array of integers and a sum. The task is to count the number of subarray which adds to the given sum.

 Example 1:

 Input:
 n = 5
 arr[] = {10,2,-2,-20,10}
 sum = -10
 Output: 3
 Explanation: Subarrays with sum -10 are:
 [10, 2, -2, -20], [2, -2, -20, 10] and
 [-20, 10].

 **/


public class Problem_4_Sum_of_sub_array {

    static int subArraySum(int arr[], int n, int sum)
    {
        //using map to store the prefix sum which has appeared already.
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int res = 0;
        int currsum = 0;

        //iterating over the array elements.
        for (int i = 0; i < n; i++) {

            //storing prefix sum which is sum of elements till current element.
            currsum += arr[i];

            //checking if sum up to current element is equal to the given sum.
            if (currsum == sum)
                //updating the counter.
                res++;

            //if map contains (currsum - sum) i.e. difference of current and
            //given sum, it means there is a subarray with sum of elements
            //equal to sum given.
            if (prevSum.containsKey(currsum - sum))
                //adding number of times (curr_sum - sum)has
                //appeared in map to the counter.
                res += prevSum.get(currsum - sum);

            //storing the prefix sum in map.
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count + 1);
        }
        //returning the count of subarrays.
        return res;
    }

    public static void main(String[] args) {
        int []arr = {1,4,20,3,10,5};
        System.out.println(subArraySum(arr,arr.length,33));

    }
}
