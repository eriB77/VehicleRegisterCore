package hu.erikabirtha;

import hu.erikabirtha.entity.Vehicle;
import hu.erikabirtha.parser.VehicleParser;
import hu.erikabirtha.validation.VehicleValidator;

import java.io.IOException;

public class VehicleRegisterInteractor implements VehicleRegisterAPI {
    private VehiclePersistence vehiclePersistence;
    private Display presenter;
    VehicleValidator vehicleValidator;
    VehicleParser vehicleParser;

    public VehicleRegisterInteractor(VehiclePersistence vehiclePersistence, Display presenter, VehicleValidator vehicleValidator, VehicleParser vehicleParser) {
        this.vehiclePersistence = vehiclePersistence;
        this.presenter = presenter;
    }

    @Override
    public void registerVehicle(String jsonParser) {

        //validáció
        //parse a dto ba jsonbol
        //vehicle létrehozása
        // mentés
        //CRUD
        vehicleValidator.validate(jsonParser);
//        try {
//            String registrationNumber = vehicleParser.parseRegistrationNumber(jsonParser);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        Vehicle vehicle = vehicleParser.parseJsonToVehicle(jsonParser);
        vehiclePersistence.saveVehicle(vehicle);
        presenter.displayOk("OK");
        presenter.displayError("NEM jó");

    }

    public void getVehicleByRegisterNumber(String registerNumberJson) {
        vehicleValidator.validate(registerNumberJson);
        String registrationNumber = vehicleParser.parseRegistrationNumberJson(registerNumberJson);
        Vehicle vehicle = vehiclePersistence.findVehicleByRegistrationNumber(registrationNumber);
        String response = vehicleParser.parseVehicleDataToJson(vehicle);
        presenter.displayVehicle(response);


//        if (registerNumber == null)
//            throw new RuntimeException();
    }
}
