package hu.erikabirtha.parser;

import hu.erikabirtha.entity.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;


public class VehicleParser {
    JsonParser jsonParser = new JsonParser();

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
    public Vehicle parseJsonToVehicle(String json) {
        String registrationNumber = parseRegistrationNumberJson(json);
        String make = parseMake(json);
        String model = parseModel(json);
        int numberOfSeats = parseNumberOfSeats(json);
        String type = parseType(json);

        Vehicle vehicle = new Vehicle("","","", 0, "");
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setNumberOfSeats(numberOfSeats);
        vehicle.setVehicleType(type);

        return vehicle;
    }
    public String parseRegistrationNumberJson(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson ,"registrationNumber");
    }

    private String parseType(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "type");
    }

    private int parseNumberOfSeats(String vehicleJson) {
        return jsonParser.parseIntValueFromJsonStringByKey(vehicleJson, "numberOfSeats");
    }

    private String parseModel(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "model");
    }

    private String parseMake(String vehicleJson) {
        return jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "make");
    }

}
//    static String json = "...";
//        public String parseRegistrationNumber(String json) throws IOException {
//            JSONObject jsonObject = new JSONObject(json);
//            jsonObject.put("registrationNumber", "ABC-123");
//            jsonObject.put("make", "Ford");
//            try {
//                FileWriter jsonFile = new FileWriter("src/main/java/vehicleFile.json");
//                jsonFile.write(jsonObject.toString());
//                jsonFile.close();
//                } catch (IOException exception) {
//                    exception.printStackTrace();
//                }
//                System.out.println("Json File created: " +jsonObject);
//            return json;
//        }

//    public String parseRegisterNumber(String json) {
//        return parseStringValueFromJsonStingByKey(json, "registerNumber");
//    }
//    private String parseStringValueFromJsonStingByKey(String jsonString, String key) {
//        String result;
//        JSONObject jsonObject = tryParse(jsonString);
//        result = getStringValue(jsonObject, key);
//        return result;
//    }
//
//    private String getStringValue(JSONObject jsonString, String key) {
//        String result = null;
//        try {
//            result = jsonString.getString(key);
//        } catch (JSONException jsonException) {
//            System.out.println("Jsonkey is invalid");
//        }
//        return result;
//    }
//
//    private String JSONObject tryParse(String fileNameFromJson) {
//        JSONObject result;
//        try {
//            result = new JSONObject(fileNameFromJson);
//        } catch (JSONException exception) {
//            throw new InvalidJsonExeption();
//        }
//        return result;
//    }
//
//    public Integer parseIntegerValueFromJsonByKey(String jsonString, String key) {
//        String stringValue = parseStringValueFromJsonStingByKey(jsonString, key);
//        return Integer.valueOf(stringValue);
//    }
