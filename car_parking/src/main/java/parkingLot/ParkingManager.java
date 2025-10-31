package parkingLot;

import vehicle.Vehicle;
import vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    List<ParkingLot> parkingSpotList;

    public ParkingManager(List<ParkingLot> parkingLots) {
        this.parkingSpotList = parkingLots;
    }




    public ParkingSpot getParkingSpot(int floor, VehicleType vehicleType){
        IdentifyParking identifyParking = new IdentifyParking(parkingSpotList.get(floor));
        if(vehicleType.equals(VehicleType.car)){
           return  identifyParking.getCarParking();
        }
        else{
           return  identifyParking.getBikeParking();
        }

    }

    public void bookParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle)
    {
        parkingSpot.isAvailable = false;
        parkingSpot.vehicle = vehicle;
    }

    public void freeParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle)
    {
        parkingSpot.isAvailable = true;
        parkingSpot.vehicle = null;
    }




}
