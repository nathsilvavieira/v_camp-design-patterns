package singleton;

import builder.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductInventory {
    private ProductInventory productInventory;
   // private List<Product,Integer>
    //Chave valor
    private Map<String,Integer> estoque = new HashMap<>();


    private ProductInventory() {
        this.productInventory = productInventory;
        estoque.put("ProductA",10);
        estoque.put("ProductB",10);
        estoque.put("ProductC",10);
        estoque.put("ProductD",10);

    }

    public ProductInventory getInstance() {
        return productInventory;
    }


    public int getProductQuantity(String product){
        return estoque.get(product);
    }

    public void blockProductsFromStock(){

    }

    public void removeProductFromStock(int quantity) {


    }
}
