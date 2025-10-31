package parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
        List<CarParkingSpot> carParkingSpots;
        List<BikeParkingSpot> bikeParkingSpots;

    public ParkingLot(List<CarParkingSpot> carParkingSpots, List<BikeParkingSpot> bikeParkingSpots)
    {
       this.carParkingSpots = carParkingSpots;
       this.bikeParkingSpots = bikeParkingSpots;
    }
}
