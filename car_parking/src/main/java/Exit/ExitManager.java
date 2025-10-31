package Exit;

import Entry.Ticket;
import Payment.PaymentFactory;
import Payment.PaymentMode;
import parkingLot.ParkingManager;
import priceCalculation.PriceCalculation;

public class ExitManager {

    ParkingManager parkingManager;
    PriceCalculation priceCalculation = new PriceCalculation();

    PaymentFactory paymentFactory = new PaymentFactory();

    public ExitManager(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }


    public void exit(Ticket ticket, PaymentMode paymentMode)
    {
        parkingManager.freeParkingSpot(ticket.parkingSpot, ticket.vehicle);
        double price = priceCalculation.calculatePrice(ticket);
        paymentFactory.getPayment(paymentMode).getPayment(price);

    }
}
