public enum VehicleType {
    HATCHBACK("HATCHBACK"),SEDAN("SEDAN"),SUV("SUV"),BIKE("BIKE");

    private String vehicleType;

     VehicleType(String vehicleType)
    {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType()
    {
        return this.vehicleType;
    }
}
