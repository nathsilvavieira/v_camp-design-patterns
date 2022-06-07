package e_commerce.singleton;

import e_commerce.classes.stock.Reserve;
import e_commerce.classes.stock.Stock;
import e_commerce.model.*;

import java.time.LocalDateTime;
import java.util.*;


public class ProductInventory {
    private static ProductInventory  productInventory;

    public List<Stock> stockList = new ArrayList<Stock>();

    //Lista de reservas para add no Map
    public List<Reserve> reservedProductsList = new ArrayList<Reserve>();

    // Produtos reservados
    public Map<String, List<Reserve>> reservedFromStock = new HashMap<>();

     public static Product beauty = new BeautyProducts("Beauty Product", "BEU123", 10.0, 1.0, "Beauty", "subcategory - beauty");
     public static Product food = new FoodProducts("Food Product", "FOO123", 5.0, 0.5, "Food", "subcategory - food");
     public static Product eletronic = new EletronicProducts("Eletronic Product", "ELE123", 50.0, 2.0, "Eletronic", "subcategory - eletronic");
     public static Product auto = new AutoProducts("Auto Product", "AUT123", 500.0, 5.0, "Auto", "subcategory - auto");
   private ProductInventory() {

        stockList.add(new Stock(10,beauty));
        stockList.add(new Stock(10,food));
        stockList.add(new Stock(10,eletronic));
        stockList.add(new Stock(10,auto));
    }

    public static ProductInventory getInstance() {
        if(productInventory==null){
            productInventory = new ProductInventory();
            return productInventory;
        }
        return productInventory;
    }

    public int getProductQuantity(Product product) {// do inventario
        int quantityStock=0;
        for (Stock stock: stockList) {
             if (stock.getProduct().getName().equals(product.getName())){
                 quantityStock= stock.getQuantity();
             }
        }
        return quantityStock;
    }

    public void blockProductsFromStock(Product product, int quantity) {

        List<Reserve> expired = null;
        if (getProductQuantity(product) < quantity) {
            System.out.println("Sorry, we can't block this itens, because we don't have these quantities in stock." +
                    "Please enter an amount less than " + getProductQuantity(product));
        } else if (getProductQuantity(product) >= quantity) {

            //Percorrer a lista de reserva, verificar se a reserva esta expirada,
            // guardar na lista de expirados, remover os itens espirados e devolver as quantidades no estoque

            reservedFromStock.forEach((key, reserveList) -> {
                reserveList.forEach((reserve) -> {
                            if (reserve.isDateExpired()) {
                                reserveList.remove(reserve);
                                for (Stock stock:stockList) {
                                    if (stock.getProduct().equals(reserve.getProduct())){
                                        stock.setQuantity(reserve.getQuantity()+getProductQuantity(product));
                                    }
                                }
                                /*List<Stock> list = stockList.stream().filter(stock -> {
                                    return stock.getProduct().getName().equals(reserve.getProduct());
                                }).collect(Collectors.toList());
                                list.get(0).setQuantity(reserve.getQuantity() + getProductQuantity(product));*/
                            }

                        }
                );
            });

            //atualizando estoque
            for (Stock stock:stockList) {
                if(stock.getProduct().getName().equals(product.getName())){
                    stock.setQuantity(getProductQuantity(product)-quantity);
                }
            }

            //lista de reservas
            reservedProductsList.add(new Reserve(quantity, product.getName(), LocalDateTime.now(), LocalDateTime.now().plusHours(1)));
            reservedFromStock.put(product.getName(), reservedProductsList);
            System.out.println("Your products are reserved, this reservation will expires in 1 hour");
        }

    }


    public void removeProductFromStock(Product product, int quantity) {
        for (Stock stock: stockList) {
            if (stock.getProduct().getName().equals(product.getName())){
                stock.setQuantity(getProductQuantity(product)-quantity);
            }
        }
    }

    public void addProductFromStock(Product product, int quantity) {
        for (Stock stock: stockList) {
            if (stock.getProduct().getName().equals(product.getName())){
                stock.setQuantity(getProductQuantity(product)+quantity);
            }
        }
        if(reservedFromStock.containsKey(product)){
            reservedFromStock.forEach((key, reserveList)->{
                reserveList.forEach((reserve)->{
                    reserveList.remove(reserve);
                });
            });
        }
    }

    @Override
    public String toString() {
        return "ProductInventory{" +
                "stockList=" + stockList +
                '}';
    }
}
