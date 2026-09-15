package Bitwise_operations;
/* Given the number  need to find the set bits in it with 0(1) complexity
* Approach: look up table
* Time complexity = 0(1)  space complexity 0(1)  consider integer upto 32 bits are given
*
*
* */


public class Problem_1_Count_set_bits {

    public static int count_set_bit(int num){
        int count = 0;
        while (num > 0){
            num =num & (num - 1);
            count++; }
        return count;
    }


    public static void main(String[] args) {

        int n = 256;
        int []lookup_table = new int[256];
        for(int i =0; i<256;i++){
            lookup_table[i] = count_set_bit(i);
        }

        int result = lookup_table[n & 255] + lookup_table[(n>>8) & 255] + lookup_table[(n>>16) & 255] + lookup_table[(n>>24)];
        System.out.println(result);

    }
}
