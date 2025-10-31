package Entry;

import parkingLot.ParkingManager;
import parkingLot.ParkingSpot;
import vehicle.Vehicle;

import java.time.LocalDateTime;

public class EntryManager {

    ParkingManager parkingManager;
    public EntryManager(ParkingManager parkingManager)
    {
        this.parkingManager = parkingManager;
    }

    public Ticket entryVehicle(Vehicle vehicle, int floor)
    {
        ParkingSpot parkingSpot = parkingManager.getParkingSpot(floor, vehicle.vehicleType);
        System.out.println("vehicle park at parking spot -->>"+parkingSpot.id);
        parkingManager.bookParkingSpot(parkingSpot, vehicle);
        return generateTicket(vehicle, parkingSpot);

    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot)
    {
        Ticket ticket = new Ticket();
        ticket.localDateTime = LocalDateTime.now();
        ticket.parkingSpot = parkingSpot;
        ticket.vehicle = vehicle;
        return ticket;
    }

}
