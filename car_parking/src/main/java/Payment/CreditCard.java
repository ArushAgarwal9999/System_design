package Payment;

public class CreditCard implements Payment{
    @Override
    public void getPayment(double price) {
        System.out.println("payment received");
    }
}
