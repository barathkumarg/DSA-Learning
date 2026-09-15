package JavaBasics;
/**
 *
 Local Variable: Declared inside methods, constructors, or blocks.
 Instance Variable: Declared inside the class but outside methods, each object gets its own copy.
 Static Variable: Declared with static, shared among all objects of the class.

**/

public class VariableTypes {
    // Instance variable (belongs to each object)
    int instanceVar = 10;

    // Static variable (shared across all objects of the class)
    static String staticVar = "I am static";

    public void showVariables() {
        // Local variable (declared inside a method)
        int localVar = 5;

        System.out.println("Instance Variable: " + instanceVar);
        System.out.println("Static Variable: " + staticVar);
        System.out.println("Local Variable: " + localVar);
    }

    public static void main(String[] args) {
        // Creating object
        VariableTypes obj1 = new VariableTypes();
        obj1.showVariables();

        // Accessing static variable directly using class name
        System.out.println("Accessing Static Variable via class: " + VariableTypes.staticVar);
    }
}
