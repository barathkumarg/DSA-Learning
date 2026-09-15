package Strings;
/**
 Given a string str, find the length of the longest substring without repeating characters.

 Example:

 For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.

 For “BBBB” the longest substring is “B”, with length 1.

 For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7

 Method 3 ( Linear Time ): Using this solution the problem can be solved in linear time using the window sliding technique.
 Whenever we see repetition, we remove the window till the repeated string.

 ***********************************************  Result  ******************************************************8

 Time Complexity: O(n) since we slide the window whenever we see any repetitions.
 Auxiliary Space: O(1)

 **/

public class Problem_9_longest_unique_subsequence {


    public static int longestSubsequence(String text){
        if (text.isEmpty() || text.length() ==1) return text.length();
        else{
            int maxLength = 0;
            //Will add the words under unique condition
            String processedString = "";
            for (char word : text.toCharArray()){
                String currentWord = String.valueOf(word);
                if(processedString.contains(currentWord)){
                    processedString = processedString.substring(processedString.indexOf(currentWord)+1);
                }
                processedString+=currentWord;
                maxLength = Math.max(maxLength,processedString.length());
            }
            return maxLength;
        }

    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence("geeksforgeeks"));

    }
}
