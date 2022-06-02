package e_commerce.builders;


import e_commerce.interfaces.IProductBuilder;
import e_commerce.model.Product;
import e_commerce.model.BeautyProducts;

public class BeautyProductsBuilder implements IProductBuilder {
    private BeautyProducts product= new BeautyProducts("Beauty Product", "BEU123", 10.0, 1.0, "Beauty", "subcategory - beauty");

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

    public IProductBuilder buildSubCategorybeauty(String subCategoryBeauty) {
        product.setSubCategoryBeauty(subCategoryBeauty);
        return this;
    }

    public IProductBuilder buildCategoryBeauty(String categoryBeauty) {
        product.setCategoryBeauty(categoryBeauty);
        return this;
    }


    @Override
    public Product build() {
        return new BeautyProducts(product.getName(), product.getSku(), product.getPrice(), product.getWeight(), product.getCategoryBeauty(), product.getSubCategoryBeauty());
    }

}


