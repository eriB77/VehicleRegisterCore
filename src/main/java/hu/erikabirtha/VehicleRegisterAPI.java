package hu.erikabirtha;

public interface VehicleRegisterAPI {
    void registerVehicle(String json);

    void findByRegistrationNumber(String jsonObject);
}
