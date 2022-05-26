import builder.builders.ProductBuilderA;
import builder.director.ProductDiretor;


public class Client {
    public static void main(String[] args) {
        ProductDiretor  director = new  ProductDiretor(new ProductBuilderA());
        director.constructProductA();



    }
}
