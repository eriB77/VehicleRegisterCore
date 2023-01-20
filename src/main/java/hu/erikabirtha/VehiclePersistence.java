package hu.erikabirtha;

import hu.erikabirtha.entity.Vehicle;

public interface VehicleRegister {
    void saveVehicle(Vehicle vehicle);
    Vehicle loadVehicle(String registerNumber);


}
