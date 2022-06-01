package e_commerce.builders;

import e_commerce.interfaces.IProductBuilder;
import e_commerce.model.Product;
import e_commerce.model.EletronicProducts;

public class EletronicProductsBuilder implements IProductBuilder {


    private EletronicProducts product= new EletronicProducts("ProdutoC", "SKU123", 0.0, 0.0,"Default", "Default");

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
        return new EletronicProducts(product.getName(), product.getSku(), product.getPrice(), product.getWeight(), product.getCategoryAuto(), product.getSubCategoryAuto());
    }

}
