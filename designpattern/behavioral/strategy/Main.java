//interface that define payment method
interface OnlinePayment{
    void pay();
}

//concrete classes that implement the interface on their own
class Bkash implements OnlinePayment{
    @Override
    public void pay(){
        System.out.println("Payment done using Bkash");
    }
}

//concrete classes that implement the interface on their own
class BracBank implements OnlinePayment{
    @Override
    public void pay(){
        System.out.println("Payment done using BracBank");
    }
}

class OnlinePaymentHandlerFactory{
    public OnlinePayment getPaymentHandler(String paymentType){
        if(paymentType == null){
            return null;
        }
        if(paymentType.equalsIgnoreCase("Bkash")){
            return new Bkash();
        }else if(paymentType.equalsIgnoreCase("BracBank")){
            return new BracBank();
        }
        return null;
    }
}

public class Main{
    public static void main(String[]args){
        OnlinePaymentHandlerFactory opf = new OnlinePaymentHandlerFactory();
        OnlinePayment op = opf.getPaymentHandler("Bkash");
        op.pay();
        OnlinePayment op2 = opf.getPaymentHandler("BracBank");
        op2.pay();
    }
}