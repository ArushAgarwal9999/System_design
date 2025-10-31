package parkingLot;

import vehicle.Vehicle;

import java.util.Date;

public class CarParkingSpot extends ParkingSpot{
        int id;
        int pricePerHour;

    public CarParkingSpot(int id, int pricePerHour) {
        super(id, pricePerHour);
        this.id = id;
        this.pricePerHour = pricePerHour;
    }
}
