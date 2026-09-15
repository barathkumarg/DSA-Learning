package Hashing;
/**
 Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.


 Example 1:

 Input:
 N = 7
 a[] = {2,6,1,9,4,5,3}
 Output:
 6
 Explanation:
 The consecutive numbers here
 are 1, 2, 3, 4, 5, 6. These 6
 numbers form the longest consecutive
 subsquence.
 ================================== Results ====================================================

 Expected Time Complexity: O(R), where R is the maximum integer in the array.
 Expected Auxiliary Space: O(N).
 **/


import java.util.HashSet;

public class Problem_6_longest_subsequence {

    static int findLongestConseqSubseq(int arr[])
    {
        HashSet<Integer> hashset = new HashSet<>();

        //add the elements in the hash set for look
        for(int i=0;i<arr.length;i++) hashset.add(arr[i]);

        int result = 0;

        //traverse the array to find the conseqcutive values
        for(int i=0;i<arr.length;i++){
            int count = 0;

            //if the previous element not in hashSet the proceed
            if(!hashset.contains(arr[i] - 1)){
                int consecutive = arr[i];

                //loop to iterate consecutive numbers
                while(hashset.contains(consecutive)){
                    consecutive+=1;
                    count++;
                }
            }
            result = Math.max(result,count);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {2,6,1,9,4,5,3};
        System.out.println(findLongestConseqSubseq(arr));

    }
}
