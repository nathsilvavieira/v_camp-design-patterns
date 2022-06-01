package e_commerce.classes.shipping;


import e_commerce.interfaces.IShipping;

public class Aero implements IShipping {

    @Override
    public String description() {
        return "Aero";
    }
}
