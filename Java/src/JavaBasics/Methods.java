package JavaBasics;

/**
 * ================================================================
 *        Java Method Call Stack & Method Basics – Demo Program
 * ================================================================
 *
 * This program demonstrates:
 *
 * 1. What is the Call Stack (LIFO behavior)
 * 2. How methods are executed in Java
 * 3. Static methods vs Instance methods
 * 4. User-defined methods
 * 5. Predefined (built-in) methods
 * 6. Method signature concept
 * 7. Method naming conventions
 *
 * ------------------------------------------------
 * Call Stack Behavior:
 *
 * main()
 *  └── methodA()
 *       └── methodB()
 *            └── methodC()
 *
 * Execution order:
 * methodC → methodB → methodA → main
 *
 * JVM automatically creates and removes stack frames.
 * ================================================================
 */

class MethodTypes {

    /* ============================
     * INSTANCE METHOD
     * ============================
     * Requires object to call
     */
    void sayHello() {
        System.out.println("Hello from Instance Method");
    }

    /* ============================
     * USER-DEFINED INSTANCE METHOD
     * ============================
     */
    void greetUser(String name) {
        System.out.println("Hello, " + name);
    }

    /* ============================
     * STATIC METHOD
     * ============================
     * Can be called using class name
     */
    static void staticMessage() {
        System.out.println("Static Method Called");
    }
}

public class Methods {

    /* ============================
     * CALL STACK METHODS
     * ============================
     */

    static void methodC() {
        double c = 30.5;
        System.out.println("In Method C | c = " + c);
    }

    static void methodB() {
        int b = 20;
        methodC();   // methodC pushed to stack
        System.out.println("In Method B | b = " + b);
    }

    static void methodA() {
        int a = 10;
        methodB();   // methodB pushed to stack
        System.out.println("In Method A | a = " + a);
    }

    static void methodD() {
        float d = 40.5f;
        System.out.println("In Method D | d = " + d);
    }

    /* ============================
     * MAIN METHOD
     * ============================
     */
    public static void main(String[] args) {

        System.out.println("----- CALL STACK DEMO -----");
        methodA();   // Start call stack
        methodD();   // New call after stack clears

        System.out.println("\n----- METHOD TYPES DEMO -----");

        // Instance method calls
        MethodTypes obj = new MethodTypes();
        obj.sayHello();
        obj.greetUser("Java Learner");

        // Static method call
        MethodTypes.staticMessage();

        System.out.println("\n----- PREDEFINED METHODS DEMO -----");

        // Predefined methods from Java library
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Random Value = " + Math.random());

        // Predefined method from Object class
        System.out.println("hashCode = " + obj.hashCode());
    }
}

