package Strings;

public class Problem_1_reverse_string_with_words {

    public static void reverse(int start,int end,char[] charArray){

        while(start<end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;end--;
        }



    }


    public static void main(String[] args) {
        String str ="i.like.this.program.very.much";
        char[] charArray = str.toCharArray();
        int start = 0;
        for(int i=0;i<charArray.length;i++){

            if(charArray[i] == '.') {
                reverse(start, i - 1, charArray);
                start = i + 1;
            }
        }

        //reverse the last word
        reverse(start,charArray.length-1,charArray);

        //reverse the whole sentence
        reverse(0,charArray.length - 1,charArray);

        System.out.println(charArray);
    }
}
