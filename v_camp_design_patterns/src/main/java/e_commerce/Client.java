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


        System.out.println("\nConsulting Beauty Product in stock "+productInventory.getProductQuantity(beauty));


        Cart cartClient = new Cart();

        System.out.println("\nOpen your cart, please insert your products and quantities" );

        System.out.println("\n----------------------------------------------------------\n");
        cartClient.addItem(beauty,2);

        cartClient.addItem(eletro,1);

        cartClient.removeItem(beauty,1);

        System.out.println("\n----------------------------------------------------------\n");

        System.out.println("Products add quantity "+ cartClient.getProducts());

        System.out.println("\n");

        System.out.println("Products price total $"+ cartClient.getTotal());

        System.out.println("\n");

        System.out.println("Products weigth "+ cartClient.getWeight());


        ShippingFactory shippingFactory = new ShippingFactory();

        System.out.println("\n******************************************************************\n");

        System.out.println("Your products will be shipped by  " + shippingFactory.createShipping(cartClient.getWeight()).description());

        System.out.println("\n******************************************************************\n");

        Order order = new Order();

        System.out.println("Creating your Order");

        order.setShippingType(String.valueOf(shippingFactory.createShipping(cartClient.getWeight()).description()));
        order.setShippingPrice(cartClient.calculateShippingCost());
        order.cart.cartList.putAll(cartClient.cartList);

        System.out.println("\n******************************************************************\n");

        System.out.println("Order ID "+ order.getOrderID()+"\nOrder Status:");
        order.orderStatus.changeOrderToPaid(cartClient);

        System.out.println("Cart products: "+order.cart.cartList);

        System.out.println("Order shipping price "+order.getShippingPrice());

        System.out.println("\n******************************************************************\n");

        System.out.println("Order sent to the backoffice");

        Orderlist orderlist = Orderlist.getInstance();

        System.out.println("\n----------------------------------------------------------\n");


        OrderFacade orderFacade = new OrderFacade();

        Backoffice backoffice = new Backoffice();


        backoffice.renderOrderList(order.getOrderID());

        System.out.println("\n******************************************************************\n");

        System.out.println("\nOpen new Cart Products\n");

        Cart cartClient2 = new Cart();

        cartClient2.addItem(food,5);
        cartClient2.addItem(eletro,6);
        cartClient2.getProducts();
        cartClient2.getWeight();
        cartClient2.getTotal();



        Order orderClient2 = new Order();

        System.out.println("Creating your Order");

        orderClient2.setShippingType(String.valueOf(shippingFactory.createShipping(cartClient2.getWeight()).description()));
        orderClient2.setShippingPrice(cartClient.calculateShippingCost());
        orderClient2.cart.cartList.putAll(cartClient2.cartList);

        System.out.println("\n******************************************************************\n");

        System.out.println("Order ID "+ orderClient2.getOrderID()+"\nOrder Status:");

        System.out.println("Cart products: "+orderClient2.cart.cartList);

        System.out.println("Order shipping "+ orderClient2.getShippingType());

        System.out.println("Order shipping price "+orderClient2.getShippingPrice());

        System.out.println("\n******************************************************************\n");

        System.out.println("Order sent to the backoffice");


        backoffice.renderOrderList(orderClient2.getOrderID());




    }
}
