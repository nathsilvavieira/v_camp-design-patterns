package e_commerce.factory;

import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.interfaces.IShipping;
import org.junit.Test;

public class ShippingFactoryTest {

    @Test
    public void factoryTest(){
        IShipping iShipping;
        ShippingFactory shippingFactory = new ShippingFactory();

        shippingFactory.createShipping(10).description();

    }

}