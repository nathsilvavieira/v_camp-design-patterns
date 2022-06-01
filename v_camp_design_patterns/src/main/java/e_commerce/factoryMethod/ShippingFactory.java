package e_commerce.factoryMethod;

import e_commerce.classes.shipping.Aero;
import e_commerce.classes.shipping.Road;
import e_commerce.composite.Cart;
import e_commerce.interfaces.IShipping;


public class ShippingFactory {
    Cart cart;

    double weight =  cart.getWeight();


    public IShipping createShipping(double weigth) {
        if(weight<10)
            return new Aero();
        else if(weight>10)
            return new Road();
        return null;
    }


   }
