package parkingLot;

import vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.Date;

public class ParkingSpot {

    public ParkingSpot(int id, int pricePerHour) {
        this.id = id;
        this.pricePerHour = pricePerHour;
    }

    public  Vehicle vehicle;

    public boolean isAvailable = true;
   public  int id;

   public int pricePerHour = 20;




}
