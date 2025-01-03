// Template Method Pattern
abstract class OnlineMobilePayment {
    protected abstract void login();
    protected abstract void pay();
    protected abstract void logout();


    //template method or we can say series of steps
    public final void makePayment(){
        login();
        pay();
        logout();
    }
}

//concrete classes that implement the template method
class Bkash extends OnlineMobilePayment{
    @Override
    protected void login(){
        System.out.println("Login to Bkash");
    }
    @Override
    protected void pay(){
        System.out.println("Payment done using Bkash");
    }
    @Override
    protected void logout(){
        System.out.println("Logout from Bkash");
    }
}

class Nagad extends OnlineMobilePayment{
    @Override
    protected void login(){
        System.out.println("Login to Nagad");
    }
    @Override
    protected void pay(){
        System.out.println("Payment done using Nagad");
    }
    @Override
    protected void logout(){
        System.out.println("Logout from Nagad");
    }
}

//factory class that returns the concrete class object based on given information
class OnlinePaymentHandlerFactory{
    public OnlineMobilePayment getPaymentHandler(String paymentType){
        if(paymentType == null){
            return null;
        }
        if(paymentType.equalsIgnoreCase("Bkash")){
            return new Bkash();
        }else if(paymentType.equalsIgnoreCase("Nagad")){
            return new Nagad();
        }
        return null;
    }
}

public class Main{
    public static void main(String[]args){
        OnlinePaymentHandlerFactory opf = new OnlinePaymentHandlerFactory();
        OnlineMobilePayment op = opf.getPaymentHandler("Bkash");
        op.makePayment();
        OnlineMobilePayment op2 = opf.getPaymentHandler("Nagad");
        op2.makePayment();
    }
}