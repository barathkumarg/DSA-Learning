package JavaBasics;

/**
 * JAVA STRING COMPLETE LEARNING GUIDE
 * * Definition: An object representing a sequence of characters.
 * * Key Features:
 * 1. Immutability: Once created, the value cannot be changed. Modification creates a new String.
 * 2. String Pool: A special memory area in the Heap that stores unique string literals for reuse.
 * 3. Thread Safe: Because they are immutable, strings can be shared across threads safely.
 * 4. Compact Strings (Java 9+): Uses byte[] instead of char[] for Latin-1 text to save space.
 * 5. Text Blocks (Java 13+): Supports multi-line literals using triple quotes (""").
 * * Memory:
 * - Literals (e.g., "Hello") go to the String Constant Pool.
 * - Objects (e.g., new String("Hello")) go to the general Heap.
 * * Performance:
 * - Concatenation with '+' in loops is slow (use StringBuilder instead).
 * - Fast comparison with equals() and constant-time access via charAt().
 */

import java.nio.charset.Charset;
import java.util.Arrays;

public class StringUtils {

    public static void main(String[] args) {

        // 1. Creating Strings
        String str1 = new String("Hello World"); // Forced new object
        String str2 = "Hello World";            // String literal (points to pool)

        // 2. Text Blocks (Java 13+) - Useful for HTML, SQL, or JSON
        String textBlock = """
                <html>
                    <body>
                        <p>Hello, World</p>
                    </body>
                </html>
                """;

        // 3. String Concatenation
        String one = "Hello";
        String two = "World";
        String combined = one + " " + two;

        // 4. Searching and Indexing
        String searchStr = "This is a good day to code";
        int index = searchStr.indexOf("good");     // 10
        char character = searchStr.charAt(5);       // 'i'
        boolean contains = searchStr.contains("day"); // true

        // 5. Comparison
        boolean isEqual = "abc".equals("ABC");           // false
        boolean isEqualIgnore = "abc".equalsIgnoreCase("ABC"); // true
        int comparison = "abc".compareTo("def");         // Returns negative integer

        // 6. Substrings and Transformation
        String sub = searchStr.substring(10, 14); // "good"
        String upper = "hello".toUpperCase();     // "HELLO"
        String lower = "HELLO".toLowerCase();     // "hello"

        // 7. Modifying (Returns new Strings)
        String source = "A man drove a car";
        String replaced = source.replace("a", "the");
        String trimmed = "  spaced string  ".trim();

        // 8. Splitting and Joining
        String toSplit = "apple,banana,cherry";
        String[] fruits = toSplit.split(",");

        // 9. Converting to/from other types
        String intStr = String.valueOf(100); // "100"
        byte[] bytes = "Hello".getBytes(Charset.forName("UTF-8"));

        // 10. Java 13+ Features
        String template = "Hello %s";
        String formatted = template.formatted("User"); // "Hello User"
        String stripped = "   Indented text".stripIndent();

        // Display results
        System.out.println("Combined: " + combined);
        System.out.println("Is Equal (ignore case): " + isEqualIgnore);
        System.out.println("Split array: " + Arrays.toString(fruits));
    }
}
