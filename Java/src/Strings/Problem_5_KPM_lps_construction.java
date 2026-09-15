package Strings;

import java.util.Arrays;

/**
 https://www.youtube.com/watch?v=V5-7GzOfADQ

 **/

public class Problem_5_KPM_lps_construction {

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


    public static void main(String[] args) {
        int [] result = construct_lps("abacabad");
        System.out.println(Arrays.toString(result));

    }
}
