package hu.erikabirtha.parser;

import hu.erikabirtha.entity.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;

public class ParserResponseModel {
    public String parseVehicleDataToJson(Vehicle vehicle) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("registrationNumber", vehicle.getRegistrationNumber());
            jsonObject.put("make", vehicle.getMake());
            jsonObject.put("model", vehicle.getModel());
            jsonObject.put("numberOfSeats", vehicle.getNumberOfSeats());
            jsonObject.put("vehicleType", vehicle.getVehicleType());
        } catch (JSONException exception) {
            throw new RuntimeException(exception);
        }
        return jsonObject.toString();
    }
}
