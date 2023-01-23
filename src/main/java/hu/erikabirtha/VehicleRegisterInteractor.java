package hu.erikabirtha;

import hu.erikabirtha.entity.Vehicle;
import hu.erikabirtha.parser.ParserResponseModel;
import hu.erikabirtha.parser.VehicleParser;
import hu.erikabirtha.validation.VehicleValidator;


public class VehicleRegisterInteractor implements VehicleRegisterAPI {
    private VehiclePersistence vehiclePersistence;
    private Display presenter;
    VehicleValidator vehicleValidator = new VehicleValidator();


    public VehicleRegisterInteractor(VehiclePersistence vehiclePersistence, Display presenter) {
        this.vehiclePersistence = vehiclePersistence;
        this.presenter = presenter;
    }

    @Override
    public void registerVehicle(String jsonInput) {

        vehicleValidator.validate(jsonInput);
        VehicleParser vehicleParser = new VehicleParser();
        Vehicle vehicle = vehicleParser.parseJsonToVehicle(jsonInput);
        vehiclePersistence.saveVehicle(vehicle);
        presenter.displayOk("OK");

    }

    public void getVehicleByRegisterNumber(String registerNumberJson) {
        VehicleParser vehicleParser = new VehicleParser();
        vehicleValidator.validate(registerNumberJson);
        String registrationNumber = vehicleParser.parseRegistrationNumberJson(registerNumberJson);
        Vehicle vehicle = vehiclePersistence.findVehicleByRegistrationNumber(registrationNumber);
        ParserResponseModel parserResponseModel = new ParserResponseModel();
        String response = parserResponseModel.parseVehicleDataToJson(vehicle);
        presenter.displayVehicle(response);

    }
}
