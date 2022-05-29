package builder.builders;

import builder.model.Product;
import builder.model.ProductB;
import builder.model.ProductC;

public class ProductBuilderC implements IProductBuilder{


    private ProductC product= new ProductC("ProdutoC", "SKU123", 0.0, 0.0,"Default", "Default");

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

    public IProductBuilder buildSubCategoryAuto(String subCategoryAuto) {
        product.setSubCategoryAuto(subCategoryAuto);
        return this;
    }

    public IProductBuilder buildCategoryAuto(String categoryAuto) {
        product.setCategoryAuto(categoryAuto);
        return this;
    }


    @Override
    public Product build() {
        return new ProductC(product.getName(), product.getSku(), product.getPrice(), product.getWeight(), product.getCategoryAuto(), product.getSubCategoryAuto());
    }

}
