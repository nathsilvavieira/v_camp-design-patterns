package e_commerce.builders;

import e_commerce.interfaces.IProductBuilder;
import e_commerce.model.Product;
import e_commerce.model.EletronicProducts;

public class EletronicProductsBuilder implements IProductBuilder {


    private EletronicProducts product= new EletronicProducts("Eletronic Product", "ELE123", 100.0, 2.0,"Eletronics", "Home");

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
        product.setSubCategoryEletronic(subCategoryAuto);
        return this;
    }

    public IProductBuilder buildCategoryAuto(String categoryAuto) {
        product.setCategoryEletronic(categoryAuto);
        return this;
    }


    @Override
    public Product build() {
        return new EletronicProducts(product.getName(), product.getSku(), product.getPrice(), product.getWeight(), product.getCategoryEletronic(), product.getSubCategoryEletronic());
    }

}
