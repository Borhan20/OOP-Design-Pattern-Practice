public class Main {
    
    // Question 1: Will finally block execute if there's a return statement in try block?
    public static int question1() {
        try {
            System.out.println("In try block");
            return 1;  // Even with return, finally will execute
        } finally {
            System.out.println("In finally block - Question 1");
        }
    }
    
    // Question 2: What happens if there's an exception in both try and finally?
    public static void question2() {
        try {
            System.out.println("In try block");
            throw new IllegalArgumentException("Exception from try");
        } finally {
            // Finally exception will override try exception
            throw new RuntimeException("Exception from finally");
        }
    }
    
    // Question 3: Will finally execute if there's System.exit(0) in try?
    public static void question3() {
        try {
            System.out.println("In try block");
            System.exit(0);  // Finally won't execute
        } finally {
            System.out.println("This won't be printed");
        }
    }
    
    // Question 4: Can we modify the value in finally that was set in try?
    public static int question4() {
        int result = 0;
        try {
            result = 1;
            return result;
        } finally {
            result = 2;  // This modifies the local variable but not the returned value
            // return result;  // This would override the try's return value
        }
    }
    
    // Question 5: Multiple catch blocks with finally
    public static void question5(int value) {
        try {
            if (value == 1) {
                throw new NumberFormatException();
            } else if (value == 2) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
        } finally {
            System.out.println("In finally block - Question 5");
        }
    }
    
    // Question 6: Try-with-resources and finally
    public static void question6() {
        try (CustomResource resource = new CustomResource()) {
            System.out.println("Using resource");
            throw new RuntimeException("Error while using resource");
        } finally {
            System.out.println("Finally after try-with-resources");
        }
    }
    
    // Helper class for Question 6
    static class CustomResource implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Resource closed");
        }
    }

    // Question 7: check statment execution in the middle of try block with catch and finally
    public static void question7(){
        try{
            System.out.println("In try block");
            throw new IllegalArgumentException("Exception from try");
        }catch (IllegalArgumentException e){
            System.out.println("Caught exception: " + e.getMessage());
        }
        System.out.println("After catch block");
        finally{
            System.out.println("In finally block - Question 7");
        }
    }
    
    public static void main(String[] args) {
        // Test Question 1
        System.out.println("\nQuestion 1: Finally with return in try");
        int result1 = question1();
        System.out.println("Returned value: " + result1);
        
        // Test Question 2
        System.out.println("\nQuestion 2: Exception in try and finally");
        try {
            question2();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        // Test Question 4
        System.out.println("\nQuestion 4: Modifying value in finally");
        int result4 = question4();
        System.out.println("Returned value: " + result4);
        
        // Test Question 5
        System.out.println("\nQuestion 5: Multiple catch blocks");
        question5(1);
        question5(2);
        
        // Test Question 6
        System.out.println("\nQuestion 6: Try-with-resources");
        try {
            question6();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test Question 7
        try{
            question7();
        }catch (Exception e){         
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}