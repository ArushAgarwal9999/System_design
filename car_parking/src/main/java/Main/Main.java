package Main;

import Entry.EntryManager;
import Entry.Ticket;
import Exit.ExitManager;
import Payment.PaymentMode;
import parkingLot.CarParkingSpot;
import parkingLot.ParkingLot;
import parkingLot.ParkingManager;
import parkingLot.ParkingSpot;
import vehicle.Vehicle;
import vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("", VehicleType.car);
        Vehicle vehicle1 = new Vehicle("", VehicleType.car);
        CarParkingSpot parkingSpot1 = new CarParkingSpot(1, 10);
        CarParkingSpot parkingSpot2 = new CarParkingSpot(2, 10);
        List<CarParkingSpot> carParkingSpots = new ArrayList<>();
        carParkingSpots.add(parkingSpot1);
        carParkingSpots.add(parkingSpot2);
        ParkingLot parkingLot = new ParkingLot(carParkingSpots, new ArrayList<>());

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingManager parkingManager = new ParkingManager(parkingLots);

        EntryManager entryManager = new EntryManager(parkingManager);

        Ticket ticket = entryManager.entryVehicle(vehicle, 0);

        ExitManager exitManager = new ExitManager(parkingManager);
        exitManager.exit(ticket, PaymentMode.Cash);
    }
}
