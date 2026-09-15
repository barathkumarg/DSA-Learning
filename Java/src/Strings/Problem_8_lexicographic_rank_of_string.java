package Strings;
/**
 You are given a string S of lowercase characters, find the rank of the string amongst its
 permutations when sorted lexicographically. Return 0 if the characters are repeated in the string.
 Note: Return the rank%1000000007 as the answer as rank might overflow.

 Example 1:

 Input:
 S = abc
 Output: 1
 Explanation: In 'abc' when we sort all the
 permutations in lexicographic order 'abc'
 will be at the first position.
 Example 2:

 Input:
 S = acb
 Output: 2
 Explanation: In 'acb' .The
 lexicographically sorted permutations
 with letters 'a', 'c', and 'b' will be
 at second position.
 Your Task:
 You only need to complete the function findRank that takes string S as a parameter and returns the rank.

 ===================================  Results  ===============================================
 Expected Time Complexity: O(N).
 Expected Auxiliary Space: O(N).

 ==================================  Techinque =============================================
 Permutation logic to place the charter in correct place.


 **/

import java.util.Arrays;

public class Problem_8_lexicographic_rank_of_string {

    //factorial calculation
    public static int factorial(int num){

        if (num <= 1) return 1;
        else {
            return num * factorial(num - 1);
        }
    }

    public static int findlexicographicOrder(String word){
        int [] asciiValues = new int[256];

        //mark the string presence
        for (int i=0;i<word.length();i++){
            int asciivalue = (int) word.charAt(i);
            asciiValues[asciivalue] = 1;
        }

        //prefix addition
        for (int i=1;i<asciiValues.length;i++){
            asciiValues[i] = asciiValues[i-1] + asciiValues[i];
        }


        int result = 0;
        //apply the permutation logic
        for(int i=0;i<word.length();i++){
            int asciivalue = (int) word.charAt(i);
            int position = asciiValues[asciivalue-1];

            result+=position*factorial(word.length()-i-1);


            //decrement the count for preceeding array
            for(int j=asciivalue;j<asciiValues.length;j++){
                asciiValues[j]-=1;
            }
            //System.out.println(Arrays.toString(asciiValues));

        }
        return result+1;


    }


    public static void main(String[] args) {
        System.out.println(findlexicographicOrder("abc"));

    }
}
