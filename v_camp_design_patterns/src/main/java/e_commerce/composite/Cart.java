package e_commerce.composite;

import e_commerce.model.Product;

import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.singleton.ProductInventory;


import java.util.HashMap;

import java.util.Map;

public class Cart {

    private ProductInventory productInventory = ProductInventory.getInstance();


    Map<Product,Integer> cart = new HashMap<>();


    public void addItem(Product product, int quantity) { //no carrinho
        int productsFromInventory = productInventory.getProductQuantity(product);

        if(productsFromInventory>=quantity){
            productInventory.removeProductFromStock(product,quantity);
            cart.put(product,quantity);
            System.out.println("Product added");
        }else {
            System.out.println(" Sorry, we were unable to add to cart. "+
                    "Please enter an amount less than " + productsFromInventory);
        }

    }

    public void removeItem(Product product, int quantity) { //do carrinho
        int cartQuantity = cart.get(product).intValue();

        if(quantity>=cartQuantity){
            quantity = cartQuantity;
            productInventory.addProductFromStock(product,quantity);
            cart.remove(product);
        }else {
            productInventory.addProductFromStock(product,quantity);
            cart.put(product, cartQuantity-quantity);
        }

        System.out.println("Product removed");
    }

    public int getProducts(){ // do carrinho
        int quantity=0;
        for (Map.Entry<Product,Integer> entry : cart.entrySet()){
            quantity+= entry.getValue();
        }
        return quantity;
    }

    public double getTotal(){ //do carrinho
        double total=0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
           total+= (entry.getKey().getPrice())* entry.getValue();
        }
                return total;
    }

    public double getWeight(){ //do carrinho
        double weight = 0;
        for (Map.Entry<Product,Integer> entry: cart.entrySet()) {
            weight += (entry.getKey().getWeight())* entry.getValue();
        }
        return weight;
    }

    public double calculateShippingCost(Cart cart){
        double totalProductQuantityFromCart = getProducts();
        double  shippingPrice = (getTotal()*0.10)+totalProductQuantityFromCart;
        if(shippingPrice>7.99)
            return shippingPrice;
        return 7.99+totalProductQuantityFromCart;
    }

}
