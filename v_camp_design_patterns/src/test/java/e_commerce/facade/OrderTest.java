package e_commerce.facade;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.composite.Cart;
import e_commerce.director.ProductDiretor;
import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.model.Product;
import e_commerce.singleton.ProductInventory;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class OrderTest {


    ProductInventory productInventory = ProductInventory.getInstance();

    Cart cart = new Cart();

    ShippingFactory shippingFactory = new ShippingFactory();

    OrderFacade orderFacade = new OrderFacade();

    Order order = new Order();

    ProductDiretor diretor = new ProductDiretor(new BeautyProductsBuilder());

    Product product = diretor.constructProduct();



    @Before
    public  void getInstnceProductInventoryTest(){
        productInventory.getInstance();

    }


    @Test
    public void addItensToCartTest(){
        cart.addItem(product,8);
    }


    @Test
    public void getOrderIDTest() {
        order.getOrderID();
    }


}