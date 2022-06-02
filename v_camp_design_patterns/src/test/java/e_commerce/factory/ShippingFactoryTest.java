package e_commerce.factory;

import e_commerce.factoryMethod.ShippingFactory;
import org.junit.Test;

public class ShippingFactoryTest {


    ShippingFactory shippingFactory = new ShippingFactory();


    @Test
    public void factoryTestRoad(){

        System.out.println(shippingFactory.createShipping(10).description());

    }

    @Test
    public void factoryTest(){

        System.out.println(shippingFactory.createShipping(5).description());

    }

}