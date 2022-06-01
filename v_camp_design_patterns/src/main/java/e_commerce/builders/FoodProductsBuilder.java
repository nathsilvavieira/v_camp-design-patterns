package e_commerce.builders;

import e_commerce.interfaces.IProductBuilder;
import e_commerce.model.FoodProducts;
import e_commerce.model.Product;

public class FoodProductsBuilder implements IProductBuilder {

    private FoodProducts product= new FoodProducts("ProdutoB", "SKU123", 0.0, 0.0,"Default", "Default");

    @Override
    public IProductBuilder buildName(String name) {
        product.setName(name);
        return this;
    }

    @Override
    public IProductBuilder buildSku(String sku) {
        product.setSku(sku);
        return this;
    }

    @Override
    public IProductBuilder buildPrice(double price) {
        product.setPrice(price);
        return this;
    }

    @Override
    public IProductBuilder buildWeight(double weight) {
        product.setWeight(weight);
        return this;
    }

    public IProductBuilder buildSubCategoryFood(String subCategoryFood) {
        product.setSubCategoryFood(subCategoryFood);
        return this;
    }

    public IProductBuilder buildCategoryFood(String categoryFood) {
        product.setCategoryFood(categoryFood);
        return this;
    }


    @Override
    public Product build() {
        return new FoodProducts(product.getName(), product.getSku(), product.getPrice(), product.getWeight(), product.getCategoryFood(), product.getSubCategoryFood());
    }

}
