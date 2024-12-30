public class Main {
    public static void main(String[] args) {
        // 1. Direct string assignment
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("1. String Pool Example:");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("Are str1 and str2 same object? " + (str1 == str2));  // true
        System.out.println("References of str1 and str2 are " 
            + System.identityHashCode(str1) + " " + System.identityHashCode(str2));
        System.out.println();
        
        // 2. String concatenation
        String original = "Hello";
        System.out.println("2. String Concatenation:");
        System.out.println("Original string: " + original);
        original.concat(" World");  // This doesn't modify original string
        System.out.println("After concat() without assignment: " + original);  // Still "Hello"
        
        String modified = original.concat(" World");  // New string object created
        System.out.println("New string after concat(): " + modified);
        System.out.println();
        
        // 3. String methods creating new objects
        String text = "Hello World";
        String uppercaseText = text.toUpperCase();
        String substringText = text.substring(0, 5);
        System.out.println("References of text and uppercaseText are " 
            + System.identityHashCode(text) + " " + System.identityHashCode(uppercaseText));
        System.out.println("References of text and substringText are " 
            + System.identityHashCode(text) + " " + System.identityHashCode(substringText));
        System.out.println("3. String Methods:");
        System.out.println("Original: " + text);
        System.out.println("Uppercase: " + uppercaseText);  // New string object
        System.out.println("Original after uppercase: " + text);  // Unchanged
        System.out.println("Substring: " + substringText);  // New string object
        System.out.println("Original after substring: " + text);  // Unchanged
        System.out.println();
        
        // 4. String object creation with 'new' outside pool
        String str3 = new String("Hello");
        System.out.println("References of str1 and str3 are " 
            + System.identityHashCode(str1) + " " + System.identityHashCode(str3));
        System.out.println("4. String Object Creation:");
        System.out.println("str1: " + str1);
        System.out.println("str3: " + str3);
        System.out.println("str1 equals str3? " + str1.equals(str3));  // true
        System.out.println("Are str1 and str3 same object? " + (str1 == str3));  // false
    }
}
