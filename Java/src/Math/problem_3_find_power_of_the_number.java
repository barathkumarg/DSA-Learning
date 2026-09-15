/*
* Problem : find the power of the given number in 0(log n) complexity
*
* Approach : using the binary digits of the given num be can achieve it
*
* time complexity = 0(n)
* space complexity = 0(1)
*
* */


package Math;

public class problem_3_find_power_of_the_number {

    public static int power(int num, int pow){
        int result = 1;
        while(pow>0) {
            if (pow % 2 != 0) {
                result = result * num;
            }
            pow = (int)pow / 2;
            num = num * num;
        }
     return result;

    }

    public static void main(String[] args) {
        System.out.println(power(2,10));

    }
}
