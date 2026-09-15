package Stack;

public class CustomStack {

    //LIMITING THE STACK SIZE TO 1000
    static final int LIMIT = 1000;
    int top;
    int[] stack = new int[LIMIT];

    CustomStack(){
        top = -1;
    }

    //insert operation
    void push(int data){
        if (top >= 1000) System.out.println("Stack Overflow");
        else {
            stack[++top] = data;
            System.out.println("Data pushed");
        }
    }

    //delete operation
    int pop(){
        if(top <= -1) System.out.println("Stack Underflow");
        else {
            int data = stack[top];
            top--;
            return data;
        }
        return -1;
    }

    //view operation
    int peek(){
        if(top <= -1) System.out.println("Stack underflow");
        else return stack[top];
        return -1;
    }

    //is empty function
    boolean isEmpty(){
        return top <=-1;
    }
}
