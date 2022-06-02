package e_commerce.singleton;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.builders.FoodProductsBuilder;
import e_commerce.classes.stock.Stock;
import e_commerce.director.ProductDiretor;
import e_commerce.model.*;
import e_commerce.singleton.ProductInventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.is;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductInventoryTest {

   /* public static Stock beauty = new Stock(10, new BeautyProducts("Beauty Product", "BEU123", 10.0, 1.0, "Beauty", "subcategory - beauty"));
    public static Stock food = new Stock(10,new FoodProducts("Food Product", "FOO123", 5.0, 0.5, "Food", "subcategory - food"));
    public static Stock eletronic = new Stock(10,new EletronicProducts("Eletronic Product", "ELE123", 50.0, 2.0, "Eletronic", "subcategory - eletronic"));
    public static Stock auto = new Stock(10,new AutoProducts("Auto Product", "AUT123", 500.0, 5.0, "Auto", "subcategory - auto"));*/

    private static ProductInventory productInventory =ProductInventory.getInstance();

    ProductDiretor diretor = new ProductDiretor(new BeautyProductsBuilder());
    Product product = diretor.constructProduct();

    ProductDiretor diretor2 = new ProductDiretor(new FoodProductsBuilder());
    Product product2 = diretor.constructProduct();

    @Before
    public  void getInstnceProductInventoryTest(){
        productInventory.getInstance();

    }
    /*
  @Before
    public void addProductsToStock(){
        productInventory.stockList.add(auto);
        productInventory.stockList.add(beauty);
        productInventory.stockList.add(food);
        productInventory.stockList.add(eletronic);
    }*/

    @Test
    public void verificaStock(){
        System.out.println(productInventory.stockList.get(1));
    }

    @Test
    public void a_getProductQuantityBeauty() {
        Assert.assertThat(productInventory.getProductQuantity(product), is(10));
    }

    @Test
    public void b_getProductQuantityFood() {
        Assert.assertThat(productInventory.getProductQuantity(product2), is(10));

    }

    @Test
    public void c_blockProductsFromStockNegative() {
        productInventory.blockProductsFromStock(product,110);
    }

    @Test
    public void d_blockProductsFromStockPositive() {
        productInventory.blockProductsFromStock(product,5);
    }

    @Test
    public void e_removeProductFromStockBeauty() {
        productInventory.removeProductFromStock(product,1);
        int estoqueBeauty= productInventory.getProductQuantity(product);
        Assert.assertEquals(4,estoqueBeauty);
    }
    @Test
    public void f_removeProductFromStockFood() {
        productInventory.removeProductFromStock(product2,2);
        int estoqueFood=productInventory.getProductQuantity(product);
        Assert.assertEquals(2, estoqueFood);
    }

    @Test
    public void g_addProductFromStockBeauty() {

        productInventory.addProductFromStock(product,5);
        int estoqueBeauty = productInventory.getProductQuantity(product);
        Assert.assertEquals(7,estoqueBeauty);

    }

    @Test
    public void h_addProductFromStockFood() {
        productInventory.addProductFromStock(product2,2);
        int estoqueFood = productInventory.getProductQuantity(product2);
        Assert.assertEquals(9,estoqueFood);

    }

}