package factoryMethod.factory;


import java.time.LocalDateTime;

public class AeroShipping extends Shipping{

    private double shippingPrice=0;
    private double weight =  0;
    private double purchasePrice = 0;
    private int quantityOfProducts = 0;
    LocalDateTime deliveryDate = LocalDateTime.now().plusDays(2);

    public AeroShipping(double shippingPrice, double weight, double purchasePrice, int quantityOfProducts, LocalDateTime deliveryDate) {
        this.shippingPrice = shippingPrice;
        this.weight = weight;
        this.purchasePrice = purchasePrice;
        this.quantityOfProducts = quantityOfProducts;
        this.deliveryDate = deliveryDate;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQuantityOfProducts() {
        return quantityOfProducts;
    }

    public void setQuantityOfProducts(int quantityOfProducts) {
        this.quantityOfProducts = quantityOfProducts;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
