package e_commerce;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.builders.FoodProductsBuilder;
import e_commerce.builders.EletronicProductsBuilder;
import e_commerce.builders.AutoProductsBuilder;
import e_commerce.director.ProductDiretor;
import e_commerce.model.Product;


public class Client {
    public static void main(String[] args) {
        ProductDiretor  director = new  ProductDiretor(new BeautyProductsBuilder());
        ProductDiretor  director2 = new  ProductDiretor(new FoodProductsBuilder());
        ProductDiretor  director3 = new  ProductDiretor(new EletronicProductsBuilder());
        ProductDiretor  director4 = new  ProductDiretor(new AutoProductsBuilder());
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
