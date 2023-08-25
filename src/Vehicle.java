public class Vehicle {
    private VehicleType vehicleType;
    private int price;
    Bookings booking;
    public Vehicle(VehicleType vehicleType,int price)
    {
        this.price=price;
        this.vehicleType = vehicleType;
        booking = new Bookings();
    }

    public String getVehicleType() {
        return vehicleType.getVehicleType();
    }

    public int getPrice() {
        return price;
    }

    public Boolean checkAvailability(int startTime,int endTime)
    {
        return booking.checkAvailability(startTime,endTime);
    }
    public void addBooking(int startTime,int endTime)
    {
        booking.addTimeSlots(startTime,endTime);
    }
}
