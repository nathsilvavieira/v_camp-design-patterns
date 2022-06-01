package composite;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.builders.FoodProductsBuilder;
import e_commerce.builders.EletronicProductsBuilder;
import e_commerce.builders.AutoProductsBuilder;
import e_commerce.director.ProductDiretor;
import e_commerce.composite.Cart;
import e_commerce.composite.Catalog;
import e_commerce.model.Product;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

    Cart cart = new Cart();

    Catalog catalog = new Catalog();

    ProductDiretor director = new  ProductDiretor(new BeautyProductsBuilder());
    ProductDiretor  director2 = new  ProductDiretor(new FoodProductsBuilder());
    ProductDiretor  director3 = new  ProductDiretor(new EletronicProductsBuilder());
    ProductDiretor  director4 = new  ProductDiretor(new AutoProductsBuilder());

    Product productA = director.constructProduct();
    Product productB = director2.constructProduct();
    Product productC = director3.constructProduct();
    Product productD = director4.constructProduct();

    @Before
    public void addToCatalogTest(){
        //catalog.productList.add(new Product("Teste", "Sku", 0.0, 0.0));

        catalog.productList.add(productA);
        catalog.productList.add(productB);
        catalog.productList.add(productC);
        catalog.productList.add(productD);

    }




    @Test
    public void addToCartTest(){

       Product product = catalog.productList.get(0);


       cart.addItem(product, 2);

    }



    @Test
    public void removeItem() {
    }

    @Test
    public void getProducts() {
    }

    @Test
    public void getTotal() {
    }

    @Test
    public void getWeight() {
    }

    @Test
    public void calculateShipping() {

    }
}