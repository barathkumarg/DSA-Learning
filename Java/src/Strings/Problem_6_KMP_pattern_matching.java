package Strings;

import java.util.Arrays;

public class Problem_6_KMP_pattern_matching {

    //lps construction
    public static int[] construct_lps(String pattern){
        int i = 1;
        int len = 0;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;

        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len!=0){
                    len = lps[len-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;

    }

    //search logic
    public static boolean kmp_search(String text,String pattern, int[] lps){

        int M = text.length();
        int N = pattern.length();
        int i = 0; //points the text length
        int j = 0; //points the pattern length

        while(M > i){
            System.out.println(i + " "+ j);
            //String matchinr case
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j==N){
                System.out.println("found");
                j = lps[j-1];
            }

                else if(M > i && text.charAt(i)!=pattern.charAt(j)){
                    if (j!=0){
                        j = lps[j-1];
                    }
                    else{
                        i++;
                    }
            }
        }
        return false;


    }

    public static void main(String[] args) {

        String text = "abadabababc";
        String pattern = "ababc";
        int[] lps = construct_lps(pattern);
        System.out.println(Arrays.toString(lps));
        System.out.println("lps completed");
        System.out.println(kmp_search(text,pattern,lps));

    }
}
