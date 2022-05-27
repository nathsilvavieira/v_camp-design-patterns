package builder.builders;


import builder.model.Product;
import builder.model.ProdutoA;

public class ProductBuilderA implements IProductBuilder {

    //private String name;
    private ProdutoA product;


    @Override
    public IProductBuilder buildName(String name) {
         product.setName(name);
        return this;
    }

    @Override
    public Product build() {
        product = new ProdutoA(product.getName());
        return product;
    }

    @Override
    public Product getProduct() {
        return product;
    }


}


