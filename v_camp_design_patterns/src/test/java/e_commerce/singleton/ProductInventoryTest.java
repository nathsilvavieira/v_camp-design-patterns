package e_commerce.singleton;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.classes.stock.Stock;
import e_commerce.director.ProductDiretor;
import e_commerce.model.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductInventoryTest {

    public static Stock beauty = new Stock(10, new BeautyProducts("Beauty Product", "BEU123", 10.0, 1.0, "Beauty", "subcategory - beauty"));
    public static Stock food = new Stock(10,new FoodProducts("Food Product", "FOO123", 5.0, 0.5, "Food", "subcategory - food"));
    public static Stock eletronic = new Stock(10,new EletronicProducts("Eletronic Product", "ELE123", 50.0, 2.0, "Eletronic", "subcategory - eletronic"));
    public static Stock auto = new Stock(10,new AutoProducts("Auto Product", "AUT123", 500.0, 5.0, "Auto", "subcategory - auto"));

    private static ProductInventory productInventory =new ProductInventory(beauty,food,eletronic,auto);

    ProductDiretor productTest = new ProductDiretor(new BeautyProductsBuilder());
    Product product = productTest.constructProduct();

   @Before
    public  void getInstnceProductInventoryTest(){
        productInventory.getInstance();

    }
   @Before
    public void addProductsToStock(){
        productInventory.stockList.add(auto);
        productInventory.stockList.add(beauty);
        productInventory.stockList.add(food);
        productInventory.stockList.add(eletronic);
    }

    @Test
    public void getProductQuantity() {
        System.out.println(productInventory.getProductQuantity(product));
    }

    @Test
    public void c_blockProductsFromStock() {
        productInventory.blockProductsFromStock(product,1);
    }

    @Test
    public void removeProductFromStock() {
        productInventory.removeProductFromStock(product,1);


    }

    @Test
    public void b_addProductFromStock() {

        productInventory.addProductFromStock(product,5);

    }


}