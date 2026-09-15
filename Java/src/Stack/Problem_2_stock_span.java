package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 The stock span problem is a financial problem where we have a series of N daily price quotes for a stock and we need to calculate the span of the stock's price for all N days. The span Si of the stock's price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than its price on the given day.

 Examples:

 Input: N = 7, price[] = [100 80 60 70 60 75 85]
 Output: 1 1 1 2 1 4 6
 Explanation: Traversing the given input span for 100 will be 1, 80 is smaller than 100 so the span is 1, 60 is smaller than 80 so the span is 1, 70 is greater than 60 so the span is 2 and so on. Hence the output will be 1 1 1 2 1 4 6.

 Input: N = 6, price[] = [10 4 5 90 120 80]
 Output:1 1 2 4 5 1
 Explanation: Traversing the given input span for 10 will be 1, 4 is smaller than 10 so the span will be 1, 5 is greater than 4 so the span will be 2 and so on. Hence, the output will be 1 1 2 4 5 1.


=======================  Result  ============================
 Time Complexity: O(N). It seems more than O(N) at first look.
 Auxiliary Space: O(N) in the worst case when all elements are sorted in decreasing order.


 **/


public class Problem_2_stock_span {

    private static void calculateSpan(int[] price, int n, int[] s) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){

            //pop the value till it reaches the previous maximum
            while(!stack.isEmpty() && price[i] >= price[stack.peek()]){
                stack.pop();
            }

            // stack calculation to get the result
            s[i] = stack.isEmpty() ? i + 1: i - stack.peek();
            stack.push(i);
        }

    }

    public static void main(String[] args) {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int S[] = new int[n];
        S[0] = 1;

        // Fill the span values in array S[]
        calculateSpan(price, n, S);
        System.out.println(Arrays.toString(S));
    }


}
