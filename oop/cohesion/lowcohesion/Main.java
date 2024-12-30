public class Main{
    public static void main(String[]args){
        Calculator c = new Calculator();
        System.out.println(c.add(5, 3));
        System.out.println(c.subtract(5, 3));
        System.out.println(c.multiply(5, 3));
        System.out.println(c.divide(5, 3));
    }
}


//low cohesion here one Utility class is serving multiple purposes
class Utility {

    public void sendEmail(String email){
        System.out.println("Email sent to "+email);
    }
    // focus mulitple operatons
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
