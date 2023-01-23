package hu.erikabirtha;

import hu.erikabirtha.entity.Vehicle;

public interface VehiclePersistence {
    void saveVehicle(Vehicle vehicle);
    Vehicle findVehicleByRegistrationNumber(String registerNumber);

}
