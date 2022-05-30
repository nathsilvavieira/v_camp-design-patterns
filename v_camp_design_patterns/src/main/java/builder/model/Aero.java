package builder.model;


import factoryMethod.IShipping;

public class Aero implements IShipping {

    @Override
    public String description() {
        return "Aero";
    }
}
