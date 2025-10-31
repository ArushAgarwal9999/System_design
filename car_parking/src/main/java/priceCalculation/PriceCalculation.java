package priceCalculation;

import Entry.Ticket;
import parkingLot.ParkingSpot;

import java.time.Duration;
import java.time.LocalDateTime;

public class PriceCalculation {



    public double calculatePrice(Ticket ticket)
    {
        double result = 0;
       long hours =  Duration.between(ticket.localDateTime, LocalDateTime.now()).toHours();
       result = hours* ticket.parkingSpot.pricePerHour;
        return result;
    }
}
