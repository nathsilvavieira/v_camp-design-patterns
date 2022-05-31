package factoryMethod;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShippingFactoryTest {

    @Test
    public void factoryTest(){
        IShipping iShipping;
        ShippingFactory shippingFactory = new ShippingFactory();

        shippingFactory.createShipping(10).description();

    }

}