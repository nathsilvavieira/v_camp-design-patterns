package e_commerce.factoryMethod;

import e_commerce.classes.shipping.Aero;
import e_commerce.classes.shipping.Road;
import e_commerce.interfaces.IShipping;

public class ShippingFactory {

    public IShipping createShipping(double weigth) {
        if(weigth<10){
            return new Aero();
        } else {
            return new Road();
        }
    }

   }
