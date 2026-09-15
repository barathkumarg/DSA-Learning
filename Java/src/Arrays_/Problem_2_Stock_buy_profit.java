package Arrays_;

/*
* The cost of stock on each day is given in an array price[] of size n. Each day you may decide to either buy or
sell the stock i at price[i], you can even buy and sell the stock on the same day, Find the maximum profit which you can get.

Note: Buying and Selling of the stock can be done multiple times, but you can only hold one stock at a time. In order to buy
another stock, firstly you have to sell the current holding stock.

Example 1:

Input:
n = 4
price[] = {3, 4, 1, 5}
Output:
5
Explanation:
We can buy stock on day 1 (at price 3) and sell it on day 2 (at price 4) profit will be 4-3=1,
We can buy another stock on day 3 (at price 1) and sell it on day 4 (at price 5) profit will be 5-1=4,
which will give us maximum profit of 1+4=5.
*
-------------------------------------------------------------------------------------------------------------------------------------------------------
Time complexity : 0(n)
Space complexity : 0(n)

* */


public class Problem_2_Stock_buy_profit {

    public static int stockBuyAndSell(int n, int[] prices) {


        int finalResult = 0;

        for(int i=1;i<n;i++){
            if (prices[i] > prices[i-1]){
                finalResult += (prices[i] - prices[i-1]);
            }
        }

        return finalResult;

    }


    public static void main(String[] args) {

        int n = 4;
        int[] array = {3,4,1,5};
        System.out.println(stockBuyAndSell(4,array));


    }
}
