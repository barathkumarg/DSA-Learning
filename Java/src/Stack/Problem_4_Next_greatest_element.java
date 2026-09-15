package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 Given an array, print the Next Greater Element (NGE) for every element.

 The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements
 for which no greater element exist, consider the next greater element as -1.

 Example:
 Input: arr[] = [ 4 , 5 , 2 , 25 ]
 Output:  4      -->   5
 5      -->   25
 2      -->   25
 25     -->   -1
 Explanation: except 25 every element has an element greater than them present on the right side

 ========== Results =======================

 **/

public class Problem_4_Next_greatest_element {

    public static void findNextGreater(int[] inputArray, int[] output){
        Stack<Integer> stack = new Stack<Integer>();

        //Iterate the input Array
        for (int index=inputArray.length -1 ;index>=0;index--){

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
        findNextGreater(inputArray,output);
        System.out.println(Arrays.toString(output));

    }
}
