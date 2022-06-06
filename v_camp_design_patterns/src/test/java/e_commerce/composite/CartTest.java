package e_commerce.composite;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.builders.FoodProductsBuilder;
import e_commerce.director.ProductDiretor;
import e_commerce.model.Product;
import e_commerce.singleton.ProductInventory;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartTest {


    ProductDiretor diretor = new ProductDiretor(new BeautyProductsBuilder());
    Product product = diretor.constructProduct();

    ProductDiretor diretor2 = new ProductDiretor(new FoodProductsBuilder());
    Product product2 = diretor.constructProduct();

    Cart cart = new Cart();

    Catalog catalog = new Catalog();

    ProductInventory productInventory = ProductInventory.getInstance();

   @Before
    public  void getInstnceProductInventoryTest(){
        productInventory.getInstance();

    }
    @Test
    public void  a_addToCartTest(){
       cart.addItem(product, 2);


    }

    @Test
    public void b_removeItem() {
        cart.addItem(product, 2);
        System.out.println(cart.cartList.get(product));
        cart.removeItem(product,1);
        System.out.println(cart.cartList.get(product));
    }

    @Test
    public void c_getProducts() {
        cart.addItem(product, 5);
        System.out.println(cart.cartList.get(product));


    }

    @Test
    public void d_getTotal() {
        cart.addItem(product, 5);
        System.out.println(cart.getTotal());
    }

    @Test
    public void e_getWeight() {
        cart.addItem(product, 5);
        System.out.println(cart.getWeight());
    }

    @Test
    public void f_calculateShipping() {
        cart.addItem(product, 5);
        System.out.println(cart.calculateShippingCost(cart));
    }
}