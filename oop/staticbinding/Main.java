// Java Program to Illustrate Static Binding


// Method of main class
// Main driver method
public class Main {
    
    public static void main(String[] args)
    {

        // Creating objects of static inner classes
        // inside main() method
        SuperClass A = new SuperClass();
        SuperClass B = new SubClass();

        // Calling method over above objects
        A.print();
        B.print();
    }
}

// Main class
class SuperClass {

	// Static nested inner class
	// Class 1
	

	// Method of inner class
	static void print()
	{

		// Print statement
		System.out.println(
			"print() in superclass is called");
	}
}

// Static nested inner class
// Class 2
class SubClass extends SuperClass {

    // Method of inner class
    static void print()
    {

        // print statement
        System.out.println(
            "print() in subclass is called");
    }
}


