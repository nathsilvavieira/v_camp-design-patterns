package e_commerce.composite;

import e_commerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<Product> productList = new ArrayList<Product>();

   /* ProductDiretor director = new  ProductDiretor(new ProductBuilderA());
    ProductDiretor  director2 = new  ProductDiretor(new ProductBuilderB());
    ProductDiretor  director3 = new  ProductDiretor(new ProductBuilderC());
    ProductDiretor  director4 = new  ProductDiretor(new ProductBuilderD());

    Product productA = director.constructProduct();
    Product productB = director2.constructProduct();
    Product productC = director3.constructProduct();
    Product productD = director4.constructProduct();

    public void addProductsCatalog(){
        productList.add(productA);
        productList.add(productB);
        productList.add(productC);
        productList.add(productD);

    }*/


    public List getAllProducts() { //busca todos produtos do catalogo

        return productList;
    }

}
