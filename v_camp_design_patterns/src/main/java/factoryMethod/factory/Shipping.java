package factoryMethod.factory;

import composite.Cart;

import java.time.LocalDateTime;

public abstract class Shipping {

    Cart cart;
    double shippingPrice=0;

    double weight =  cart.getWeight();
    double purchasePrice = cart.getTotal();
    int quantityOfProducts = cart.getProducts("");

    public double  calculateShipping(Cart cart){
        shippingPrice = (purchasePrice*1.10)*quantityOfProducts;
        if(shippingPrice>7.99)
            return shippingPrice;
        return 7.99+quantityOfProducts;
    }

    public Shipping factoryShipping(double weight){ //instancia os frates de acordo com a regra
        if(weight<10)
            return new AeroShipping(shippingPrice, weight, purchasePrice,quantityOfProducts, LocalDateTime.now().plusDays(2));
        else if(weight>10)
            return new RoadShipping(shippingPrice, weight, purchasePrice,quantityOfProducts, LocalDateTime.now().plusDays(5));
        return null;
    }

}
