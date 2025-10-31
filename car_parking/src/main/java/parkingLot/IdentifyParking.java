package parkingLot;

public class IdentifyParking {

    ParkingLot parkingLot;

    public IdentifyParking(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }


    public CarParkingSpot getCarParking(){
        for(CarParkingSpot carParkingSpot: parkingLot.carParkingSpots)
        {
            if(carParkingSpot.isAvailable)
                return carParkingSpot;
        }
        return null;
    }

    public BikeParkingSpot getBikeParking(){
        for(BikeParkingSpot bikeParkingSpot: parkingLot.bikeParkingSpots)
        {
            if(bikeParkingSpot.isAvailable)
                return bikeParkingSpot;
        }
        return null;
    }


}
