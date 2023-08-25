import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vehicle suvVehicle = new Vehicle(VehicleType.SUV,12);
        Vehicle sedanVehicle = new Vehicle(VehicleType.SEDAN,10);
        Vehicle bikeVehicle = new Vehicle(VehicleType.BIKE,20);
        List <Vehicle> vehiclesList1 = new ArrayList<>();
        vehiclesList1.add(suvVehicle);
        System.out.println("  Adding branch");
        RentalSystem rentalSystem = new RentalSystem("koramangala",vehiclesList1);
        rentalSystem.addVehicle("koramangala",sedanVehicle);
        rentalSystem.addVehicle("koramangala",bikeVehicle);
        Boolean isBookingPossible = rentalSystem.rentVehicle(VehicleType.SEDAN,11,12);
        Boolean isBookingPossible2 = rentalSystem.rentVehicle(VehicleType.SEDAN,11,12);
        rentalSystem.addBranch("jayanagar",null);
        Vehicle suvVehicle2 = new Vehicle(VehicleType.SEDAN,11);
        Vehicle bikeVehicle2 = new Vehicle(VehicleType.BIKE,30);
        Vehicle hatchbackVehicle= new Vehicle(VehicleType.HATCHBACK,8);
        Vehicle hatchbackVehicle2= new Vehicle(VehicleType.HATCHBACK,8);
        rentalSystem.addVehicle("jayanagar",suvVehicle2);
        rentalSystem.addVehicle("jayanagar",bikeVehicle2);
        rentalSystem.addVehicle("jayanagar",hatchbackVehicle);
        rentalSystem.addVehicle("jayanagar",hatchbackVehicle2);
        rentalSystem.rentVehicle(VehicleType.HATCHBACK,11,12);
        rentalSystem.rentVehicle(VehicleType.HATCHBACK,11,12);
        rentalSystem.rentVehicle(VehicleType.HATCHBACK,11,12);
        rentalSystem.viewForTimeSlot(11,12);

//    better customizations
//            1. Add Custom exception
//            2. Better class level strcuture
    }
}