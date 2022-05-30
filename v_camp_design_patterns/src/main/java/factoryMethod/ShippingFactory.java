package factoryMethod;

import builder.model.Aero;
import builder.model.Road;
import composite.Cart;



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
