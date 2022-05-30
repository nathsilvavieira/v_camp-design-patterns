package builder.model;

import factoryMethod.IShipping;

public class Road implements IShipping {



    @Override
    public String description() {
        return "Road";
    }
}
