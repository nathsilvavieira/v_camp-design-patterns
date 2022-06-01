package e_commerce.classes.order;

import e_commerce.composite.Cart;
import e_commerce.composite.Catalog;
import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.model.Product;
import e_commerce.singleton.ProductInventory;

public class Shipped {
    private String status = " Order shipped";

    private ProductInventory productInventory;
    private Catalog catalog;
    private ShippingFactory shippingFactory;
    private Cart cart;

    public String getStatus() {
        return status;
    }

    public void OrderShipped(Product product){
        productInventory.reservedFromStock.forEach((key, reserveList)->{
            reserveList.forEach((reserve)->{
                reserveList.remove(reserve);
            });
        });

    }

}
