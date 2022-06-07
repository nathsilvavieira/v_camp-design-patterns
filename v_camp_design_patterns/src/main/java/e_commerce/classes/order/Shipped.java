package e_commerce.classes.order;

import e_commerce.composite.Cart;
import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.interfaces.IOrderFacade;
import e_commerce.model.Product;

public class Shipped implements IOrderFacade {
    private String status = "Order shipped";




    public String getStatus() {
        return status;
    }

    public void OrderShipped(Product product){



    }

    @Override
    public void changeOrderStatus() {
        System.out.println(getStatus());
    }

    @Override
    public String toString() {
        return "Shipped";

    }
}
