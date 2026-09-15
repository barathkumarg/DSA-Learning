package Stack;

public class CustomStackImplementation {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(1);
        stack.push(2);

        System.out.println(stack.peek());
    }
}
