package Payment;

public class PaymentFactory {

    public Payment getPayment(PaymentMode paymentMode)
    {
        if(paymentMode.equals(PaymentMode.Cash))
            return new Cash();
        return new CreditCard();
    }

}
