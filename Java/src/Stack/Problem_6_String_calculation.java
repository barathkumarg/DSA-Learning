package Stack;

import java.util.Objects;
import java.util.Stack;

/**
Stack calculation: 3(ab)2(b) -> abababbb

 Time complexity = 0(mn)  => 0(n^2)
 Space complexity = 0(n) stack
 **/
public class Problem_6_String_calculation {


    public static String combineString(Stack<Integer> numericStack, Stack<String> expressionStack){
        int topNumber = numericStack.pop();
        String output = "";
        String returnOutput = "";

        while (!(Objects.equals(expressionStack.peek(), "("))){
            output = expressionStack.pop().concat(output);
        }
        expressionStack.pop(); //pop the '(' bracket

        // String multiplication
        while (topNumber > 0){
            returnOutput = returnOutput.concat(output);
            topNumber --;
        }

        return returnOutput;
    }


    public static void main(String[] args) {

        String input = "3(a2(b))";
        char[] charArray = input.toCharArray();
        int numeric = 0;
        int charLength = 0;

        //Stack
        Stack<Integer> numericStack = new Stack<>();
        Stack<String> expressionStack = new Stack<>();

        while (charLength < charArray.length){

            //if the character was numeric input
            char character = charArray[charLength];
            if(character == ')'){
                String stackString = combineString(numericStack,expressionStack);
                expressionStack.push(stackString);
                charLength++;
                continue;
            }
            else if (!(charArray[charLength] >= '0' && charArray[charLength] <= '9')) {
                String string = String.valueOf(character);
                expressionStack.push(string);
                charLength++;
                continue;
            }
            while (charArray[charLength] >= '0' && charArray[charLength] <= '9'){
                numeric = numeric * 10 + (charArray[charLength] - '0');
                charLength++;
            }
            // Push to numeric stack
            numericStack.push(numeric);
            numeric = 0;

        }

        //Iterate the stack
        String finalOutput = "";
        while(!expressionStack.isEmpty()){
            finalOutput =  expressionStack.pop().concat(finalOutput);
        }

        System.out.println(finalOutput);
    }

}
