package e_commerce.builders;

import e_commerce.interfaces.IProductBuilder;
import e_commerce.model.Product;

import e_commerce.model.EletronicProducts;
import e_commerce.model.AutoProducts;

public class AutoProductsBuilder implements IProductBuilder {

    private AutoProducts product= new AutoProducts("ProdutoD", "SKU123", 0.0, 0.0,"Default", "Default");

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

    public IProductBuilder buildSubCategoryEletronic(String subCategoryEletronic) {
        product.setSubCategoryEletronic(subCategoryEletronic);
        return this;
    }

    public IProductBuilder buildCategoryAuto(String categoryEletronic) {
        product.setCategoryEletronic(categoryEletronic);
        return this;
    }


    @Override
    public Product build() {
        return new EletronicProducts(product.getName(), product.getSku(), product.getPrice(), product.getWeight(), product.getCategoryEletronic(), product.getSubCategoryEletronic());
    }
}
