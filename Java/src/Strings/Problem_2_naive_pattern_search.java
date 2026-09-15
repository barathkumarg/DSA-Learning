package Strings;


/**
 Given a string S and a pattern P both of lowercase characters. The task is to check if the given pattern exists in the given string or not.

 Example 1:

 Input:
 S = aabaacaadaabaaabaa
 P = aaba
 Output: Yes
 Explanation: Given pattern aaba is found
 in the string at index 0.

 ============================ Results ========================
 Expected Time Complexity: O(N*M).
 Expected Auxiliary Space: O(1).

 * **/


public class Problem_2_naive_pattern_search {

    public static Boolean naivePatternSearch(String word,String pattern){

        //traversal for complete actual string
        for(int i=0;i<word.length();i++){

            //if the first character matched then travese with the pattern search

            if(word.charAt(i) == pattern.charAt(0)){
                //index identicator for actual word
                int index = i;

                //inner loop to iterate for the pattern search
                for(int j=0;j<pattern.length();j++){
                    if(index < word.length() && word.charAt(index) == pattern.charAt(j)){
                        index++;
                    }
                    else{
                        break;
                    }

                    //return true if the pattern exactly matches with the word
                    if(j == pattern.length() -1) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String word = "encyclopedia";
        String pattern = "encyclopdia";
        System.out.println(naivePatternSearch(word,pattern));


    }
}
