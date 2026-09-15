package Strings;

/**
 Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
 (eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)

=============================== Results =========================================
 Time complexity = O(n)
 Space complexity = 0(1)
 **/

import java.util.Objects;

public class Problem_7_Rotated_string {

    public static boolean isrotated(String word, String rotatedWord){
        String wordCopy = rotatedWord;
        int StringLength = wordCopy.length();
        if (Objects.equals(word, rotatedWord)) return true;
        for (int i=0;i<rotatedWord.length();i++){
            rotatedWord = rotatedWord.substring(1,StringLength) + rotatedWord.substring(0,1); //inbulit method for substring
            System.out.println(rotatedWord);
            if (Objects.equals(word, rotatedWord)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String word = "abcd";
        System.out.println(isrotated(word,"cdcb"));

    }
}
