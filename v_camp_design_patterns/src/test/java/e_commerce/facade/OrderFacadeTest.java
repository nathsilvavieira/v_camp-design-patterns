package e_commerce.facade;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.director.ProductDiretor;
import e_commerce.model.Product;
import org.junit.Test;

public class OrderFacadeTest {

    OrderFacade orderFacade = new OrderFacade();

    ProductDiretor diretor = new ProductDiretor(new BeautyProductsBuilder());
    Product product = diretor.constructProduct();

    @Test
    public void changeOrderStatus() {




    }



}