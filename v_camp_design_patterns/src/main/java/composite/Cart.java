package composite;

import builder.catalog.Catalog;
import factoryMethod.factory.Shipping;
import singleton.ProductInventory;

public class Cart {

    private ProductInventory productInventory;
    private Catalog catalog;
    private Shipping shipping;


    public void addItem(String product, int quantity) {
        productInventory.removeProductFromStock(product,quantity);
    }

    public void removeItem(String product, int quantity) {
        productInventory.addProductFromStock(product,quantity);
    }

    public int getProducts(String product){
        int quantity= productInventory.getProductQuantity(product);
        return quantity;
    }

    public double getTotal(){

        return 0;
    }

    public double getWeight(){

        return 0;
    }


}
