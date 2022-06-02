package e_commerce.director;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.builders.FoodProductsBuilder;
import e_commerce.builders.EletronicProductsBuilder;
import e_commerce.builders.AutoProductsBuilder;
import e_commerce.director.ProductDiretor;
import e_commerce.model.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ProductDiretorTest {
    @Test
    public void constructProductATest(){
        ProductDiretor director = new ProductDiretor(new BeautyProductsBuilder());
       // ProductA ProductA = new ProductA("ProdutoA", "SKU123", 0.0, 0.0,"Default", "Default");
        Product product = director.constructProduct();
        System.out.println(product);
    }

    @Test
    public void constructProductBTest(){
        ProductDiretor director = new ProductDiretor(new FoodProductsBuilder());
        Product product = director.constructProduct();
        System.out.println(product);

    }

    @Test
    public void constructProductCTest(){
        ProductDiretor director = new ProductDiretor(new EletronicProductsBuilder());
        Product product = director.constructProduct();
        System.out.println(product);

    }

    @Test
    public void constructProductDTest(){
        ProductDiretor director = new ProductDiretor(new AutoProductsBuilder());
        Product product = director.constructProduct();
        System.out.println(product);

        Assert.assertNotNull("Objeto criado", product);

    }




}