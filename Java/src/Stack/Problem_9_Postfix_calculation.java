package Stack;

import java.util.Stack;

/**
 The Postfix notation is used to represent algebraic expressions. The expressions written in postfix
 form are evaluated faster compared to infix notation as parenthesis is not required in postfix. We have discussed infix to postfix conversion. In this post, the evaluation of postfix expressions is discussed.

 Example:

 Input: str = "2 3 1 * + 9 -"
 Output: -4

 ===================================  Results ==============================
 Time Complexity: O(N)
 Auxiliary Space: O(N)


 **/

public class Problem_9_Postfix_calculation {

    public static void main(String[] args) {

        String input = "100 200 + 2 / 5 * 7 +";
        Stack<Integer> stack = new Stack<>();

        for(int index = 0;index<input.length(); index++) {

            if (input.charAt(index) == ' ') continue; //skip the empty space

            //If number as an input
            if (Character.isDigit(input.charAt(index))){
                int number = 0;
                while (Character.isDigit(input.charAt(index))) {
                    number = number * 10 + (input.charAt(index) - '0');
                    index++;
                }
            index--; //go back one iteration back
            stack.push(number);
        }

            //If the operand as the input
            else {
                int value2 = stack.pop();
                int value1 = stack.pop();
                switch (input.charAt(index)) {
                    case '*':
                        stack.push(value1 * value2);
                        break;
                    case '/':
                        stack.push(value1 / value2);
                        break;
                    case '+':
                        stack.push(value1 + value2);
                        break;
                    case '-':
                        stack.push(value1 - value2);
                        break;

                }
            }
        }
        System.out.println("Output of postfix expression: "+ stack.pop());
    }
}
