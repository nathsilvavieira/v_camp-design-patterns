package e_commerce.classes.order;

import e_commerce.composite.Cart;
import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.interfaces.IOrderFacade;
import e_commerce.model.Product;

public class Shipped implements IOrderFacade {
    private String status = " Order shipped";

    private Cart cart;
    private ShippingFactory shippingFactory;

    public String getStatus() {
        return status;
    }

    public void OrderShipped(Product product){



    }

    @Override
    public void changeOrderStatus() {
        double shippingPrice = this.cart.calculateShippingCost();
        System.out.println("Your order is Shipped in the model "+ shippingFactory.createShipping(this.cart.getWeight())+" value $ "+shippingPrice); ;

    }
}
