package e_commerce.singleton;

import e_commerce.classes.stock.Reserve;
import e_commerce.classes.stock.Stock;
import e_commerce.model.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ProductInventory {
    private ProductInventory productInventory;

    public List<Stock> stockList = new ArrayList<Stock>();

    //Lista de reservas para add no Map
    public List<Reserve> reservedProductsList = new ArrayList<Reserve>();

    // Produtos reservados
    public Map<String, List<Reserve>> reservedFromStock = new HashMap<>();


    private ProductInventory() {
        this.productInventory = productInventory;
        Product beautyProduct = new BeautyProducts("Beauty Product", "BEU123", 10.0, 1.0, "Beauty", "subcategory - beauty");
        Product foodProduct = new FoodProducts("Food Product", "FOO123", 5.0, 0.5, "Food", "subcategory - food");
        Product eletronicProducts = new EletronicProducts("Eletronic Product", "ELE123", 50.0, 2.0, "Eletronic", "subcategory - eletronic");
        Product autoProducts = new AutoProducts("Auto Product", "AUT123", 500.0, 5.0, "Auto", "subcategory - auto");
    }

    public ProductInventory getInstance() {
        return productInventory;
    }

    //Usando a chave para pegar o valor stock
    public int getProductQuantity(String productName) { // do inventario
        List<Stock> list = stockList.stream().filter(stock -> {
                    return stock.getProduct().getName().equals(productName);
                }
        ).collect(Collectors.toList());
        return list.get(0).getQuantity();
    }

    public void blockProductsFromStock(String product, int quantity) {

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
                                List<Stock> list = stockList.stream().filter(stock -> {
                                    return stock.getProduct().getName().equals(reserve.getProduct());
                                }).collect(Collectors.toList());
                                list.get(0).setQuantity(reserve.getQuantity() + getProductQuantity(reserve.getProduct()));
                            }

                        }
                );
            });

            //atualizando estoque
            List<Stock> list = stockList.stream().filter(stock -> {
                return stock.getProduct().getName().equals(product);
            }).collect(Collectors.toList());
            list.get(0).setQuantity(quantity-getProductQuantity(product));

            //lista de reservas
            reservedProductsList.add(new Reserve(quantity, product, LocalDateTime.now(), LocalDateTime.now().plusHours(1)));
            reservedFromStock.put(product, reservedProductsList);
            System.out.println("Your products are reserved, this reservation will expires in 1 hour");
        }

    }


    public void removeProductFromStock(String product, int quantity) {
        List<Stock> list = stockList.stream().filter(stock -> {
            return stock.getProduct().getName().equals(product);
        }).collect(Collectors.toList());
        list.get(0).setQuantity(quantity-getProductQuantity(product));
    }

    public void addProductFromStock(String product, int quantity) {
        List<Stock> list = stockList.stream().filter(stock -> {
            return stock.getProduct().getName().equals(product);
        }).collect(Collectors.toList());
        list.get(0).setQuantity(quantity+getProductQuantity(product));

        if(reservedFromStock.containsKey(product)){
            reservedFromStock.forEach((key, reserveList)->{
                reserveList.forEach((reserve)->{
                    reserveList.remove(reserve);
                });
            });
        }
    }
}
