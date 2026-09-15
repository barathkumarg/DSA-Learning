package Stack;

import java.util.Stack;

/**
 Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars
 whose heights are given in an array. For simplicity, assume that all bars have the same width and the width is 1 unit.

 Example:
 Input: histogram = {6, 2, 5, 4, 5, 1, 6}
 Output: 12

 Input: histogram = {3, 5, 1, 7, 5, 9}
 Output: 15

 =================== Implementation ========================
 Like Previous Greater and Next Greater Element computation, precompute the Previous/ Next smallest number to find the largest area.
 Store the index instead of value in th stack

 intution: https://www.youtube.com/watch?v=Bzat9vgD0fs

 Time complexity: O(n)
 Space complexity : O(n)

 **/



public class Problem_5_Find_Max_Area_Rectangle {

    public static int computeLargestArea(int[] inputArray){
        int max = -1;

        Stack<Integer> stack = new Stack<Integer>();
        for(int index = 0;index<inputArray.length;index++){

            while(!stack.empty() && inputArray[stack.peek()] > inputArray[index]){
                int element = inputArray[stack.peek()];
                stack.pop();
                int nextSmallestElementIndex =  index;
                int nextGreaterElementIndex = stack.empty() ? -1 : stack.peek();

                int result = element * ((nextSmallestElementIndex - nextGreaterElementIndex) - 1);
                max = Math.max(result,max);
            }
            stack.push(index);

        }

        //incase of the element left in the stack
        while(!stack.empty()){
            int element = inputArray[stack.peek()];
            stack.pop();
            int nextSmallestElementIndex = inputArray.length;
            int nextGreaterElementIndex = stack.empty() ? -1 : stack.peek();

            int result = element * ((nextSmallestElementIndex - nextGreaterElementIndex) - 1);
            max = Math.max(result,max);

        }

        return max;

    }

    public static void main(String[] args) {
        int[] inputArray = {3, 5, 1, 7, 5, 9};
        System.out.println(computeLargestArea(inputArray));

    }
}
