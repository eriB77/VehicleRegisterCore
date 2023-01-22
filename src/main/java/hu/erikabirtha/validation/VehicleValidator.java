package hu.erikabirtha.validation;

import hu.erikabirtha.exeption.InvalidRegisterNumberExeption;

public class VehicleValidator {

    public void validate(String Json) {
        if (Json == null)
            throw new InvalidRegisterNumberExeption();
    }
}
