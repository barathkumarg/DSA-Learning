package Stack;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

/**
 Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in the given expression.

 Example:

 Input: exp = “[()]{}{[()()]()}”
 Output: Balanced
 Explanation: all the brackets are well-formed

 Input: exp = “[(])”
 Output: Not Balanced
 Explanation: 1 and 4 brackets are not balanced because
 there is a closing ‘]’ before the closing ‘(‘

 <================================= Results =========================>
 Expected Time Complexity: O(n)
 Expected Auxiliary Space: O(n)
 **/


public class Problem_1_Balancing_Paranthesis {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();

        //getting the input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the paranthesis sequence: ");
        char[] str = input.next().toCharArray();

        //iterate
        for(Character character : str){

            //opening bracket cases
            if(character == '{' || character == '[' || character == '('){
                stack.push(character);
            } else if (character == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (character == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (character == ')' && stack.peek() == '(') {
                stack.pop();
            }

        }
        if (stack.isEmpty()) System.out.println("Paranthesis matched and balanced");
        else System.out.println("Not a balanced and matched one");

    }
}
