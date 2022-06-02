package e_commerce.composite;

import e_commerce.builders.AutoProductsBuilder;
import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.builders.EletronicProductsBuilder;
import e_commerce.builders.FoodProductsBuilder;
import e_commerce.director.ProductDiretor;
import e_commerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    public List<Product> productList = new ArrayList<Product>();

    ProductDiretor director = new  ProductDiretor(new BeautyProductsBuilder());
    ProductDiretor  director2 = new  ProductDiretor(new FoodProductsBuilder());
    ProductDiretor  director3 = new  ProductDiretor(new AutoProductsBuilder());
    ProductDiretor  director4 = new  ProductDiretor(new EletronicProductsBuilder());

    Product beauty = director.constructProduct();
    Product food = director2.constructProduct();
    Product auto = director3.constructProduct();
    Product eletronic = director4.constructProduct();

    public Catalog() {
        this.productList = productList;
        productList.add(beauty);
        productList.add(food);
        productList.add(auto);
        productList.add(eletronic);
    }

    public List getAllProducts() { //busca todos produtos do catalogo

        return productList;
    }

}
