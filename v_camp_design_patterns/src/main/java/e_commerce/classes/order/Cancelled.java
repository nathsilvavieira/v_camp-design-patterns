package e_commerce.classes.order;

import e_commerce.composite.Cart;
import e_commerce.composite.Catalog;
import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.model.Product;
import e_commerce.singleton.ProductInventory;

public class Cancelled {

    private String status = "Order cancelled";

    private ProductInventory productInventory = ProductInventory.getInstance();

    private Cart cart;



    public String getStatusCancelled() {
        return status;
    }

    public void OrderCancelled(Product product){
        int quantityOrder =cart.getProducts();
        cart.removeItem(product,quantityOrder);
    }


}
