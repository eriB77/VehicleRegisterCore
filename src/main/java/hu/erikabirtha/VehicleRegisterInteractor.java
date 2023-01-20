package hu.erikabirtha;

import hu.erikabirtha.entity.Vehicle;

public class VehicleRegisterInteractor implements VehicleRegisterAPI {
    private VehiclePersistence vehiclePersistence;
    private Display presenter;

    public VehicleRegisterInteractor(VehiclePersistence vehiclePersistence, Display presenter) {
        this.vehiclePersistence = vehiclePersistence;
        this.presenter = presenter;
    }
    @Override
    public void registerVehicle(String json) {
        //validáció
        //parse a dto ba jsonbol
        //vehicle létrehozása
        // mentés
        Vehicle vechicle = new Vehicle("","","", "", 0, "");
        vehiclePersistence.saveVehicle(vechicle);
        presenter.displayOk("OK");
        presenter.displayError("NEM jó");

    }
}
