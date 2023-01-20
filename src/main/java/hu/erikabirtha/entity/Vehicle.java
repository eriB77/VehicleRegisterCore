package hu.erikabirtha.entity;
public class Vehicle {

    String registrationNumber;
    String make;
    String model;
    Integer numberOfSeats;
    String vehicleType;

    public Vehicle(String vehicle, String registrationNumber, String make, String model, Integer numberOfSeats, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
