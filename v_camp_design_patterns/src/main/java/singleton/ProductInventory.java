package singleton;

import builder.model.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ProductInventory {
    private ProductInventory productInventory;


    public List<Stock> stockList = new ArrayList<Stock>();

    //Lista de reservas para add no Map
    public List<Reserve> reserveList = new ArrayList<Reserve>();

    // Produtos reservados
    public Map<String, List<Reserve>> reserved = new HashMap<>();


    private ProductInventory() {
        this.productInventory = productInventory;
        Product productA = new ProductA("Name", "SKU", 0.0, 0.0, "Beauty", "subcategory");
        Product productB = new ProductB("Name", "SKU", 0.0, 0.0, "Food", "subcategory");
        Product productC = new ProductC("Name", "SKU", 0.0, 0.0, "Auto", "subcategory");
        Product productD = new ProductD("Name", "SKU", 0.0, 0.0, "Eletronic", "subcategory");
    }

    public ProductInventory getInstance() {
        return productInventory;
    }

    //Usando a chave para pegar o valor stock
    public int getProductQuantity(String productName) {
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

            //Falta fazer o Map para percorrer a lista de reserva, verificar se a reserva esta expirada,
            // guardar na lista de expirados, remover os itens espirados e devolver as quantidades no estoque

            reserved.forEach((key, reserveList) -> {
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

            //list de reservas
            reserveList.add(new Reserve(quantity, product, LocalDateTime.now(), LocalDateTime.now().plusHours(1)));
            reserved.put(product, reserveList);
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
    }
}
