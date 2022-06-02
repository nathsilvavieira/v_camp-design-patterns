package e_commerce.composite;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.builders.FoodProductsBuilder;
import e_commerce.builders.EletronicProductsBuilder;
import e_commerce.builders.AutoProductsBuilder;
import e_commerce.director.ProductDiretor;
import e_commerce.composite.Catalog;
import e_commerce.model.Product;
import org.junit.Before;
import org.junit.Test;

public class CatalogTest {

    Catalog catalog = new Catalog();

    @Test
    public void getAllProdutsTest(){

        System.out.println(catalog.getAllProducts());

    }

}