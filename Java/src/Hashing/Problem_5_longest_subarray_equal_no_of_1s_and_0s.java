package Hashing;

/**
 Given an array containing only 0s and 1s, find the largest subarray which contains equal no of 0s and 1s. The expected time complexity is O(n).

 Examples:

 Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
 Output: 1 to 6
 (Starting and Ending indexes of output subarray)

 Input: arr[] = {1, 1, 1, 1}
 Output: No such subarray

 Input: arr[] = {0, 0, 1, 1, 0}
 Output: 0 to 3 Or 1 to 4

 =======================================  Results =========================================
 Time Complexity: O(n).
 As the given array is traversed only once.
 Auxiliary Space: O(n).
 As hash_map has been used which takes extra spa

 **/


import java.util.HashMap;

public class Problem_5_longest_subarray_equal_no_of_1s_and_0s {

    static int count_equal_1s_and_0s(int[] arr){

        //converting the 0 to -1 to change the problem to zero sum subarray
        for(int i=0;i<arr.length;i++){
            if (arr[i] == 0)arr[i] = -1;
        }

        //HashMap to save the prefix sum and its initial position
        HashMap<Integer,Integer> hashmap = new HashMap<>();

        int prefix = 0;
        int result = 0;

        //Traverse the array
        for(int i=0;i<arr.length;i++){
            prefix+=arr[i];

            if (prefix==0) result = i+1;

            if(hashmap.containsKey(prefix)){
                result = Math.max(result, i - hashmap.get(prefix));
            }else{
                hashmap.put(prefix,i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 1, 0, 1, 1};
        System.out.println(count_equal_1s_and_0s(arr));

    }
}
