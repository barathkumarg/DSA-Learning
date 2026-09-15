package Recursion;
/*
* to generate the permutation of string for the given text
*
*
*
* */
import java.util.ArrayList;

public class Problem_2_generating_permutation {
    public static void permutate(String str,int length, String current){
        if(str.length() == length){
            System.out.println(current);
            return;
        }
        permutate(str,length+1,current);
        permutate(str,length + 1,current+str.charAt(length));
    }

    public static void main(String[] args) {
        String str = "abc";
        permutate(str,0,"");

    }
}
