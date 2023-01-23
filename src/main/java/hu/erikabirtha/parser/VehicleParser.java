package hu.erikabirtha.parser;

import hu.erikabirtha.entity.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;


public class VehicleParser {

    public Vehicle parseJsonToVehicle(String json) {
        Vehicle vehicle = new Vehicle();
        try {
            JSONObject jsonObject = new JSONObject(json);
            vehicle.setRegistrationNumber(jsonObject.getString("registrationNumber"));
            vehicle.setMake(jsonObject.getString("make"));
            vehicle.setModel(jsonObject.getString("model"));
            vehicle.setNumberOfSeats(jsonObject.getInt("numberOfSeats"));
            vehicle.setVehicleType(jsonObject.getString("vehicleType"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return vehicle;
    }

    public String parseRegistrationNumberJson(String registerNumberJson) {
        JSONObject jsonObject = null;
        String registrationNumber = "";
        try {
            jsonObject = new JSONObject(registerNumberJson);
            registrationNumber = jsonObject.getString("registrationNumber");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return registrationNumber;
    }
}