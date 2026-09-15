/**
 * 💡 Count Set Bits from 1 to N
 *
 * This program calculates the total number of set bits (1s) in the binary representation
 * of integers from 1 to a given integer N.
 *
 * The core logic recursively computes the count of set bits.
 *
 * ➡️ Time Complexity: O(log N)
 *    - The time complexity is determined by the number of times the findpower function is called.
 *      It is called approximately log₂(N) times.
 *
 * ➡️ Space Complexity: O(log N)
 *    - The space complexity is determined by the function call stack during recursion.
 *      It can go up to log₂(N) levels deep.
 *
 * 🔁 find_set_bit_n(num) recursively computes the count of set bits for integers from 1 to num.
 *   It utilizes a helper function findpower(n) to find the highest power of 2 less than or equal to num.
 *   The final result is built by combining the count of set bits for various ranges.
 *
 * ➡️ To use, call find_set_bit_n(num) with your desired value of num.

**/

package Bitwise_operations;
public class Problem_3_count_set_bit_1_to_n {

    // Finding power of the number using bitwise operator
    public static int findpower(int n){
        int result = 0;
        while (n > 0){
            n = n >> 1;
            result+=1;
        }
        return result - 1;
    }

    //core logic to execute the set bit business logic from 1 to n
    public static int find_set_bit_n(int num){

        int power = findpower(num);

        if (num <= 0)
            return 0;
        int result = (power * (1<<(power - 1)) + ((num - (1<<power) ) + 1)  + find_set_bit_n(num - (1<<power)));

        return result;
    }


    public static void main(String[] args) {

        System.out.println(find_set_bit_n(12));
    }

}
