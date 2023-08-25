import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalSystem {
    private Map<String, List<Vehicle>> vehicleBranchMapping;
    public RentalSystem(String branchName,List<Vehicle> vehicles)
    {
        vehicleBranchMapping = new HashMap<>();
        if(vehicles == null)
        {
            vehicles = new ArrayList<>();
        }
        vehicleBranchMapping.put(branchName,vehicles);
    }

    public void addBranch (String branchName,List<Vehicle> vehicleList)
    {
        if(vehicleBranchMapping.containsKey(branchName))
            System.out.println("Branch allready Addeds");
        else {
            if(vehicleList==null)
                vehicleList = new ArrayList<>();
            vehicleBranchMapping.put(branchName, vehicleList);
            System.out.println("Branch added successfully");
        }
    }
    public void addVehicle(String branchName,Vehicle vehicle){

        vehicleBranchMapping.get(branchName).add(vehicle);
    }

    public Boolean rentVehicle(VehicleType vehicleType,int startTime,int endTime)
    {
       String vehicleType1 =vehicleType.getVehicleType();
       Boolean isAnyVehicleAvailable= false;
        Vehicle currentVehicle= null;
       for (Map.Entry<String,List<Vehicle>> entry : vehicleBranchMapping.entrySet())
       {
           String branchName = entry.getKey();
           List<Vehicle> vehicleList = entry.getValue();
           for(Vehicle vehicle:vehicleList)
           {
//               String currVehicleType = vehicle.getVehicleType();
               if(vehicleType.getVehicleType().equals(vehicle.getVehicleType()) && checkVehicleAvailability(vehicle, startTime, endTime))
               {
                   currentVehicle = vehicle;
                   break;

               }
           }
           if(currentVehicle!=null){
           isAnyVehicleAvailable = true;
           currentVehicle.addBooking(startTime, endTime);
           break;
        }
       }
        if(isAnyVehicleAvailable == false) {
            System.out.println("NO Booking got created");
            return false;
        }
        System.out.println("Booking created for " + currentVehicle.getVehicleType());
        return true;
    }

    private Boolean checkVehicleAvailability(Vehicle currVehicle,int startTime,int endTime)
    {
        return currVehicle.checkAvailability(startTime,endTime);
    }

    public void viewForTimeSlot(int startTime,int endTime)
    {
        for(Map.Entry<String ,List<Vehicle>>entry : vehicleBranchMapping.entrySet())
        {
            String branchName = entry.getKey();
            List <Vehicle> vehicles = entry.getValue();
            Boolean bikeAvailable = false;
            Boolean suvAvailable = false;
            Boolean hatchAvailable = false;
            Boolean sedanAvailable = false;
            for(Vehicle vehicle:vehicles)
            {
                if(vehicle.booking.checkAvailability(startTime,endTime))
                {
                    if(vehicle.getVehicleType().equals("BIKE"))
                    {
                        bikeAvailable = true;
                    }
                    else if(vehicle.getVehicleType().equals("SUV"))
                    {
                        suvAvailable = true;
                    }
                    else if(vehicle.getVehicleType().equals("HATCHBACK"))
                    {
                        hatchAvailable = true;
                    }
                    else if(vehicle.getVehicleType().equals("SEDAN"))
                    {
                        sedanAvailable = true;
                    }
                }
                if(bikeAvailable && suvAvailable && hatchAvailable && sedanAvailable)
                    break;
            }
            System.out.println("*   " + branchName);
            System.out.println("     *Is Bike available for time slot "+bikeAvailable);
            System.out.println("     *Is SUV available for time slot "+suvAvailable);
            System.out.println("     *Is HatchBack available for time slot "+hatchAvailable);
            System.out.println("     *Is Sedan available for time slot "+sedanAvailable);
        }
    }
}
