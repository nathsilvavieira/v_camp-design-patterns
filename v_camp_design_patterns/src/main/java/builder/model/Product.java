package builder.model;

public class Product {

   private double weight ;

   private double price ;

   private String sku ;

   private String name ;


    public Product(String name) {
        this.weight = weight;
        this.price = price;
        this.sku = sku;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "weight=" + weight +
                ", price=" + price +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
