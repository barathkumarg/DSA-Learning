package Math;

/*
Problem: Find the trailing zeros approach in the given factorial

Approach: Divide the factorial of the by the increasing powers of 5
n/5 +  n/25  +  n/125 .............

Time complexity = 0(log n)

Space Complexity = 0(1)

*/

public class Problem_2_Find_Trailingzeros_In_Factorial {
    public static void main(String[] args) {

        int num = 10;
        int result = 0;
        for (int i=5;i<num;i*=5){
            result = result + (int)(num/i);
        }

        System.out.println(result);

    }
}
