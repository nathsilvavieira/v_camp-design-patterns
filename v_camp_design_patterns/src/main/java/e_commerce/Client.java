package e_commerce;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.builders.FoodProductsBuilder;
import e_commerce.builders.EletronicProductsBuilder;
import e_commerce.builders.AutoProductsBuilder;
import e_commerce.composite.Cart;
import e_commerce.composite.Catalog;
import e_commerce.director.ProductDiretor;
import e_commerce.facade.Order;
import e_commerce.facade.OrderFacade;
import e_commerce.factoryMethod.ShippingFactory;
import e_commerce.interator.Orderlist;
import e_commerce.model.Product;
import e_commerce.observer.Backoffice;
import e_commerce.singleton.ProductInventory;

public class Client {
    public static void main(String[] args) {
        ProductDiretor productDiretorAuto = new ProductDiretor(new AutoProductsBuilder());
        Product auto = productDiretorAuto.constructProduct();

        ProductDiretor productDiretorBeauty = new ProductDiretor(new BeautyProductsBuilder());
        Product beauty = productDiretorBeauty.constructProduct();

        ProductDiretor productDiretorFood = new ProductDiretor(new FoodProductsBuilder());
        Product food = productDiretorFood.constructProduct();

        ProductDiretor productDiretorEletronic = new ProductDiretor(new EletronicProductsBuilder());
        Product eletro = productDiretorEletronic.constructProduct();

        Catalog catalog = new Catalog();

        System.out.println("\nWelcome to our e-commerce, here is our catalog, please choose your product and quantities\n");

        System.out.println("\n******************************************************************\n");

        System.out.println(catalog);

        System.out.println("\n******************************************************************\n");

        ProductInventory productInventory = ProductInventory.getInstance();

        //System.out.println(productInventory); apenas para testar

        System.out.println("\nConsulting Beauty Product in stock "+productInventory.getProductQuantity(beauty));


       // productInventory.removeProductFromStock(food,2); apenas para testar
       // productInventory.blockProductsFromStock(food,2); apenas para testar
       // productInventory.addProductFromStock(food,3); apenas para testar


        Cart cart = new Cart();

        System.out.println("\nOpen your cart, please insert your products and quantities" );

        System.out.println("\n----------------------------------------------------------\n");
        cart.addItem(beauty,2);

        cart.addItem(eletro,1);

        cart.removeItem(beauty,1);

        System.out.println("\n----------------------------------------------------------\n");

        System.out.println("Products add quantity "+ cart.getProducts());

        System.out.println("\n");

        System.out.println("Products price total $"+ cart.getTotal());

        System.out.println("\n");

        System.out.println("Products weigth "+ cart.getWeight());


        ShippingFactory shippingFactory = new ShippingFactory();

        System.out.println("\n******************************************************************\n");

        System.out.println("Your products will be shipped by  " + shippingFactory.createShipping(cart.getWeight()).description());

        System.out.println("\n******************************************************************\n");

        Order order = new Order();

        System.out.println("Creating your Order");

        System.out.println("\n******************************************************************\n");

        System.out.println("Order ID "+ order.getOrderID()+"\nOrder Status:");
        order.orderStatus.changeOrderToPending(cart);
        System.out.println("Order shipping "+ order.getShippingFactory().createShipping(cart.getWeight()).description());
        System.out.println("Order price "+ order.cart.calculateShippingCost());

        System.out.println("\n******************************************************************\n");

        System.out.println("Order sent to the backoffice");

        Orderlist orderlist = Orderlist.getInstance();

        OrderFacade orderFacade = new OrderFacade();

        Backoffice backoffice = new Backoffice();

        //backoffice.notifyOrderChange(order);

        backoffice.renderOrderList();



    }
}
