package composite;

import factoryMethod.ShippingFactory;
import singleton.ProductInventory;

public class Cart {

    private ProductInventory productInventory;
    private Catalog catalog;
    private ShippingFactory shippingFactory;


    private double purchasePrice=0;
    private double weight=0;
    private int quantityOfProducts=0;


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


    public double  calculateShipping(Cart cart){
        double  shippingPrice = (purchasePrice*1.10)*quantityOfProducts;
        if(shippingPrice>7.99)
            return shippingPrice;
        return 7.99+quantityOfProducts;
    }


}
