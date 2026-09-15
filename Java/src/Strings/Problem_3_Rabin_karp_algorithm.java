package Strings;

/**
 Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.

 Examples:
 Input:  txt[] = "THIS IS A TEST TEXT"
 pat[] = "TEST"
 Output: Pattern found at index 10

 Input:  txt[] =  "AABAACAADAABAABA"

 =====================================  Result  ==================================
 Time Complexity: The average and best case running time of the Rabin-Karp algorithm is O(n+m),
 but its worst-case time is O(nm). Worst case of Rabin-Karp algorithm occurs when all characters of
 pattern and text are the same as the hash values of all the substrings of txt[] match with the hash value of pat[].
 For example pat[] = "AAA" and txt[] = "AAAAAAA".


 * **/



public class Problem_3_Rabin_karp_algorithm {

    public static void search(String pattern, String text, int prime) {

        //Intiation the variables
        int ASCII = 256;
        int textHash = 0;
        int patternHash = 0;
        int hashlimit = 1;
        int j = 0;

        //compute the hash limit helps in subtraction while sliding the string search
        for(int i=0;i<pattern.length() - 1;i++){
            hashlimit = (hashlimit * ASCII)%prime;
        }

        //calculate the hash value for Pattern windo limit
        for(int i=0;i<pattern.length();i++){
            textHash = (textHash * ASCII + text.charAt(i)) % prime;
            patternHash = (patternHash * ASCII + pattern.charAt(i)) % prime;
        }

        //checkin for the matching case
        for(int i=0;i<=text.length()-pattern.length();i++){
            //System.out.println(textHash);


            //If match found
            if (textHash == patternHash){
                for(j=0;j<pattern.length();j++){

                    if(pattern.charAt(j) != text.charAt(i+j)) break;

                    }
                if(j == pattern.length()){
                    System.out.println("match found");
                }
            }

            //calculate hash for slide logic
            if(i<text.length() - pattern.length()) {
                textHash = (ASCII * (textHash - (text.charAt(i) * hashlimit) + text.charAt(i + pattern.length())))%prime;

                //CORNER CASE: if the text hash becomes negative
                if(textHash < 0) {
                    textHash +=prime;
                }
            }

        }




    }

    public static void main(String[] args)
    {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        int q = 101; // A prime number
        search(pat, txt, q);
    }


}
