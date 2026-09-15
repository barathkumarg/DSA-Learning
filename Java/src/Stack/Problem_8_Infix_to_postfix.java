package Stack;

import java.util.Stack;

/**
 Write a program to Convert Infix expression to Postfix.

 Infix expression: The expression of the form a operator b (a + b). When an operator is in-between every pair of operands.
 Postfix expression: The expression of the form a b operator (ab+). When an operator is followed by every pair of operands.

 Examples:

 Input: A + B * C + D
 Output: ABC*+D+

 Input: ((A + B) - C * (D / E)) + F
 Output: AB+CDE/*-F+

 Time Complexity: O(N), where N is the size of the infix expression
 Auxiliary Space: O(N)
 **/

public class Problem_8_Infix_to_postfix {

    public static int precedence(char operand){
        // Order of precedence calculation
        if (operand == '^') return 3;
        else if(operand == '*' || operand == '/') return 2;
        else if(operand == '+' || operand == '-')return 1;
        else return -1; //edge case for paranthesis

    }
    public static void main(String[] args) {

        String input = "a+b*(c^d-e)^(f+g*h)-i";
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (char character: input.toCharArray()){

            if (character >= 'a' && character <= 'z') result+=character;  //push the characters

            else if (character == '(') stack.push(character);   //push the '(' character

            else if (character == ')') {
                while(stack.peek()!='(') {result+=stack.pop();}
                stack.pop(); //pop the ')' string
            }

            else{
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(character)){ //pop the elements occurding to the precedence rule.
                    result+=stack.pop();
                }
                stack.push(character);
            }
        }

        //If the stack was not empty
        while (!stack.isEmpty()) result+=stack.pop();

        //Final output
        System.out.println("The postfix expression for infix : "+ result);

    }

}
