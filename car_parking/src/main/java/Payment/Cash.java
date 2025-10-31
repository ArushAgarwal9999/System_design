package Payment;

public class Cash implements Payment{
    @Override
    public void getPayment(double price) {
        System.out.println("payment recives -->>"+price);

    }
}
