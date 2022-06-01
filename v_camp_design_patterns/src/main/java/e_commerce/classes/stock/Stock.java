package e_commerce.classes.stock;

import e_commerce.model.Product;

public class Stock {

    public Stock(int quantity, Product product) {
        this.quantity = 10;
        this.product = product;
    }

    private int quantity;

    private Product product;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
