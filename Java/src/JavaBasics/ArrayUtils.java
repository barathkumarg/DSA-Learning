package JavaBasics;

/**
 * JAVA ARRAY COMPLETE LEARNING GUIDE
 * * Definition: A linear data structure that stores multiple values of the same type.
 * * Key Features:
 * 1. Store Primitives & Objects: Can hold int, char, etc., or class instances.
 * 2. Contiguous Memory: Elements are stored in adjacent locations in memory.
 * 3. Zero-based Indexing: First element is at index 0, last at length - 1.
 * 4. Fixed Length: Size is defined at creation and cannot be changed.
 * 5. Inheritance: Arrays are objects and inherit from java.lang.Object.
 * * Memory:
 * - Memory is always dynamically allocated on the Heap.
 * - Primitives store actual values; Object arrays store references.
 * * Advantages: Fast O(1) access, predictable memory management.
 * Disadvantages: Fixed size, costly insertions/deletions (O(n)).
 */

import java.util.Arrays;

class Student {
    public int roll_no;
    public String name;

    Student(int roll_no, String name) {
        this.roll_no = roll_no;
        this.name = name;
    }
}

public class ArrayUtils {
    public static void main(String[] args) {

        // 1. INITIALIZING & TRAVERSING (Array Literals)
        // Used when elements are known beforehand
        int[] arr = {40, 55, 63, 17, 22};
        int n = arr.length;

        System.out.println("--- 1. Traversal ---");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");


        // 2. DYNAMIC ALLOCATION & UPDATING
        // Elements initialized to default (0 for int, null for objects)
        int[] dynamicArr = new int[5];
        dynamicArr[0] = 2; // Changing an element
        dynamicArr[1] = 4;
        dynamicArr[2] = 8;

        System.out.println("--- 2. Accessing & Updating ---");
        System.out.println("Element at index 0: " + dynamicArr[0]);
        System.out.println();


        // 3. ARRAYS OF OBJECTS
        // Stores references to objects on the heap

        Student[] studentArr = new Student[3];
        studentArr[0] = new Student(1, "Aman");
        studentArr[1] = new Student(2, "Vaibhav");
        studentArr[2] = new Student(3, "Mohit");

        System.out.println("--- 3. Array of Objects ---");
        for (Student s : studentArr) {
            System.out.println("Roll No: " + s.roll_no + ", Name: " + s.name);
        }
        System.out.println();


        // 4. PASSING & RETURNING ARRAYS
        System.out.println("--- 4. Methods ---");
        int[] values = {1, 2, 3, 4, 5};
        sum(values); // Passing array

        int[] returnedArr = m1(); // Returning array
        System.out.println("Array returned from method: " + Arrays.toString(returnedArr));
        System.out.println();


        // 5. EXCEPTION HANDLING
        // Accessing index < 0 or >= length throws ArrayIndexOutOfBoundsException
        System.out.println("--- 5. Exception Handling ---");
        try {
            int[] errorArr = new int[4];
            System.out.println(errorArr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: Attempted to access index outside array size.");
        }
    }

    // Example of passing an array to a method
    public static void sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        System.out.println("Sum of array values: " + sum);
    }

    // Example of returning an array from a method
    public static int[] m1() {
        return new int[] { 1, 2, 3 };
    }
}
