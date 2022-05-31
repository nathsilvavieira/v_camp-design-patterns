package composite;

import builder.model.Product;
import builder.model.Stock;
import factoryMethod.ShippingFactory;
import singleton.ProductInventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private ProductInventory productInventory;
    private Catalog catalog;
    private ShippingFactory shippingFactory;
    Map<Product,Integer> cart = new HashMap<>();

    public void addItem(Product product, int quantity) {
        int productsFromInventory = productInventory.getProductQuantity(product.getName());

        if(productsFromInventory>=quantity){
            productInventory.removeProductFromStock(product.getName(),quantity);
            cart.put(product,quantity);
            System.out.println(" Adicionou  ");
        }else {
            System.out.println(" Falhou  "+ productsFromInventory);
        }

    }

    public void removeItem(Product product, int quantity) {
        int cartQuantity = cart.get(product);

        if(quantity>=cartQuantity){
            quantity = cartQuantity;
            productInventory.addProductFromStock(product.getName(),quantity);
            cart.remove(product);
        }else {
            productInventory.addProductFromStock(product.getName(),quantity);
            cart.put(product, cartQuantity-quantity);
        }

    }

    public int getProducts(){ // do carrinho
        int quantity=0;
        for (Map.Entry<Product,Integer> entry : cart.entrySet()){
            quantity+= entry.getValue();
        }
        return quantity;
    }

    public double getTotal(){
        double total=0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
           total+= (entry.getKey().getPrice())* entry.getValue();
        }
                return total;
    }

    public double getWeight(){
        double weight = 0;
        for (Map.Entry<Product,Integer> entry: cart.entrySet()) {
            weight += (entry.getKey().getWeight())* entry.getValue();
        }
        return weight;
    }

    public double  calculateShipping(Cart cart){
        double totalProductQuantityFromCart = getTotal();
        double  shippingPrice = (getTotal()*1.10)*totalProductQuantityFromCart;
        if(shippingPrice>7.99)
            return shippingPrice;
        return 7.99+totalProductQuantityFromCart;
    }

}
