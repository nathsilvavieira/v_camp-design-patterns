import builder.builders.ProductBuilderA;
import builder.builders.ProductBuilderB;
import builder.builders.ProductBuilderC;
import builder.builders.ProductBuilderD;
import builder.director.ProductDiretor;
import builder.model.Product;
import composite.Catalog;


public class Client {
    public static void main(String[] args) {
        ProductDiretor  director = new  ProductDiretor(new ProductBuilderA());
        ProductDiretor  director2 = new  ProductDiretor(new ProductBuilderB());
        ProductDiretor  director3 = new  ProductDiretor(new ProductBuilderC());
        ProductDiretor  director4 = new  ProductDiretor(new ProductBuilderD());
        Product product = director.constructProduct();
        Product product1 = director2.constructProduct();
        Product product2 = director3.constructProduct();
        Product product3 = director4.constructProduct();
        System.out.println(product);
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);






    }


}
