/*
* Palindrome check problem in recursive approach
*
*
* Time complexity : O(log n)
* Space complexity : O (log n)
* */


package Recursion;



public class Problem_4_palindrome_string {

    public static boolean find_palindrome(String str,int start,int end){
        if (start>end)
            return true;
        else
            return (str.charAt(start) == str.charAt(end)) && (find_palindrome(str,start+1,end-1));
    }

    public static void main(String[] args) {
        String str = "MADAMq";

        System.out.println(str.length());
        System.out.println(find_palindrome(str,0,str.length() - 1));
    }
}
