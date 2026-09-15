package Math;
import java.lang.Math;

/*

Problem : Finding the number is palindrome or not without reversing
the given number

Approach : checking the first and last digit using the mod and divide operator


Time Complexity = O(n/2)

Space COmplexity =  O(1)

Inbulit Libraries used Math.log() and Math.pow()

*/
public class Problem_1_Palindrome_number {
    public static boolean palindrome(int num){

        while(num>9){

            int first_digit = num % 10;
            int last_digit = (int) num / (int) (Math.pow(10,(int)Math.log10(num)));

            if(first_digit != last_digit){

                return false;
            }

            num = (int) num / 10; // deleting the last digit
            //System.out.println(num);

            num = (int) num % (int) Math.pow(10,(int)Math.log10(num));// deleting the first digit
            //System.out.println(num);

        }
        return true;
    }


    public static void main(String[] args) {

        int num = 22122;
        System.out.println(palindrome(num));

    }


}
