package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 Given an array of distinct elements, find previous greater element for every element. If previous greater element does not exist, print -1.

 Examples:

 Input : arr[] = {10, 4, 2, 20, 40, 12, 30}
 Output :         -1, 10, 4, -1, -1, 40, 40

 Input : arr[] = {10, 20, 30, 40}
 Output :        -1, -1, -1, -1

 Input : arr[] = {40, 30, 20, 10}
 Output :        -1, 40, 30, 20

 ========================  Results ==========================
 Time Complexity: O(n). It seems more than O(n) at first look. If we take a closer look, we can observe that every element of array is added and removed from stack at most once. So there are total 2n operations at most. Assuming that a stack operation takes O(1) time, we can say that the time complexity is O(n).
 Auxiliary Space: O(n) in worst case when all elements are sorted in decreasing order.
**/


public class Problem_3_Previous_greater_element {

    public static void findPreviousGreater(int[] inputArray, int[] output){
        //Stack to record the occurrence
        Stack<Integer> stack = new Stack<Integer>();

        //Iterate the input Array
        for (int index=0;index<inputArray.length;index++){

            //pop the highest elements
            while(!stack.isEmpty() && inputArray[index] > stack.peek()) stack.pop();

            //stack empty case
            if (stack.isEmpty()) {
                stack.push(inputArray[index]);
                output[index] = -1;
            }
            // else we found the previous greater element just push to stack and output array
            else{
                output[index] = stack.peek();
                stack.push(inputArray[index]);
            }
        }

    }

    public static void main(String[] args) {

        int[] inputArray = {10, 4, 2, 20, 40, 12, 30};
        int [] output = new int[inputArray.length];
        findPreviousGreater(inputArray,output);
        System.out.println(Arrays.toString(output));
        
    }
}
