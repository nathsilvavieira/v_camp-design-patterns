package builder.builders;


import builder.model.Product;
import builder.model.ProductA;

public class ProductBuilderA implements IProductBuilder {
    private ProductA product= new ProductA("ProdutoA", "SKU123", 0.0, 0.0,"Default", "Default");

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
        return new ProductA(product.getName(), product.getSku(), product.getPrice(), product.getWeight(), product.getCategoryBeauty(), product.getSubCategoryBeauty());
    }

}


