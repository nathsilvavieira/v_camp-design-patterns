package e_commerce.classes.order;

import e_commerce.composite.Cart;
import e_commerce.composite.Catalog;
import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.model.Product;
import e_commerce.singleton.ProductInventory;

public class Completed {

    private String status = "Completed";

    private ProductInventory productInventory;
    private Catalog catalog;
    private ShippingFactory shippingFactory;
    private Cart cart;

    public String getStatusCompleted() {
        return status;
    }

    public void OrderCompleted(Product product){
        productInventory.reservedFromStock.forEach((key, reserveList)->{
            reserveList.forEach((reserve)->{
                reserveList.remove(reserve);
            });
        });

    }
}
