package singleton;

import builder.model.Product;

import java.util.*;

public class ProductInventory {
    private ProductInventory productInventory;

    // Map usa Chave Valor
    private Map<String,Integer> stock = new HashMap<>();


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

    public void blockProductsFromStock(String product, int quantity){



        if(getProductQuantity(product)<quantity){
            System.out.println("Sorry, we can't block this itens, because we don't have these quantities in stock." +
                    "Please enter an amount less than "+ getProductQuantity(product));
        }else if(getProductQuantity(product)>=quantity){
            int atualStock = getProductQuantity(product);

            int newStock = atualStock - quantity;

            stock.put(product, newStock);

           // guardar itens removidos na lista de reserva
            Map<Integer, Integer> reserved = new HashMap<>();
            Calendar calendar = Calendar.getInstance();
            int expiredDate = calendar.get(Calendar.DATE);
                reserved.put(quantity,expiredDate);


            System.out.println("Your products are reserved, this reservation expires in 2 days");

        }

    }

    public void removeProductFromStock(String product, int quantity) {
    int atualStock = stock.get(product);

    int newStock = atualStock - quantity;

    stock.put(product, newStock);


    }
}
