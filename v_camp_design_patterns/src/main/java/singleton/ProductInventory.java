package singleton;

import builder.model.Product;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ProductInventory {
    private ProductInventory productInventory;

    // Map usa Chave Valor
    private Map<String,Integer> stock = new HashMap<>();

    //lista de reservas
    public List<Reserve> reserveList = new ArrayList<>();

    // guardar itens removidos na lista de reserva
    public Map<String, List> reserved = new HashMap<>();



    private ProductInventory() {
        this.productInventory = productInventory;
        stock.put("ProductA",10);
        stock.put("ProductB",10);
        stock.put("ProductC",10);
        stock.put("ProductD",10);

    }

    public ProductInventory getInstance() {
        return productInventory;
    }

    //Usando a chave para pegar o valor stock
    public int getProductQuantity(String product){
        return stock.get(product);
    }

    public void blockProductsFromStock(String product, int quantity) {

        List<Reserve> expired = null;
        if (getProductQuantity(product) < quantity) {
            System.out.println("Sorry, we can't block this itens, because we don't have these quantities in stock." +
                    "Please enter an amount less than " + getProductQuantity(product));
        } else if (getProductQuantity(product) >= quantity) {

            //Falta fazer o Map para percorrer a lista de reserva, verificar se a reserva esta expirada,
            // guardar na lista de expirados, remover os itens espirados e devolver as quantidades no estoque

            expired = new ArrayList<>();
            reserved.remove(expired);

           /* for (Reserve reserve : reserveList) {
                if (reserve.isDateExpired()) {
                    expired.add(reserve);
                }
            }*/

            //atualizando estoque
            int atualStock = getProductQuantity(product);
            int newStock = atualStock - quantity;
            stock.put(product, newStock);

            //list de reservas
            reserveList.add(new Reserve(quantity, product,LocalDateTime.now(),LocalDateTime.now().plusHours(1)));
            reserved.put(product, reserveList);
            System.out.println("Your products are reserved, this reservation expires in 2 days");
        }

    }



    public void removeProductFromStock(String product, int quantity) {
    int atualStock = stock.get(product);

    int newStock = atualStock - quantity;

    stock.put(product, newStock);


    }

    public void addProductFromStock(String product, int quantity) {
        int atualStock = stock.get(product);

        int newStock = atualStock + quantity;

        stock.put(product, newStock);


    }
}
