package e_commerce.classes.shipping;

import e_commerce.interfaces.IShipping;

public class Road implements IShipping {

    String road = "Road";

    @Override
    public String description() {
        return road;
    }


}
