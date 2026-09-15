package Strings;

/**

 Given a number 'N'. The task is to find the Nth number whose each digit is a prime number i.e 2, 3, 5, 7.
 In other words you have to find nth number of this sequence : 2, 3, 5, 7, 22, 23 ,.. and so on.

 =========== Approach ================
 /                                 |                        |                            \
 2                                3                       5                            7
 / |  | \                         / | |  \                 /  | | \                    /  | |  \
 22 23 25 27        32 33 35 37         52 53 55 57        72 73 75 77
 /||\/||\/||\/||\       /||\/||\/||\/||\         /||\/||\/||\/||\        /||\/||\/||\/||\
 We can notice following :
 1st. 5th, 9th. 13th, ….. numbers have 2 as last digit.
 2nd. 6th, 10th. 14th, ….. numbers have 3 as last digit.
 3rd. 7th, 11th. 15th, ….. numbers have 5 as last digit.
 4th. 8th, 12th. 16th, ….. numbers have 7 as last digit.


 ==========================================  Result =================================
 Time complexity: 0(n)
 Space Complexity: 0(1)
 * **/

public class Problem_4_Sequence_number_formation {

    public static int primeDigits(int n)
    {
        String result = "";

        while(n > 0){

            int digit_result = n % 4;
            switch (digit_result){
                case 1:
                    result = '2' + result;
                    break;
                case 2:
                    result = '3' + result;
                    break;
                case 3:
                    result = '5' + result;
                    break;
                case 0:
                    result = '7' + result;
                    break;

            }
            if (digit_result == 0) n--;
            n = n / 4;
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        int result = primeDigits(5);
        System.out.println(result);
    }
}
