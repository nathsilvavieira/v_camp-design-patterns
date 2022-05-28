import builder.builders.ProductBuilderA;
import builder.director.ProductDiretor;
import builder.model.Product;


public class Client {
    public static void main(String[] args) {
        ProductDiretor  director = new  ProductDiretor(new ProductBuilderA());
        Product product = director.constructProduct();
        System.out.println(product);
    }
}
