package builder.builders;


import builder.model.Product;
import builder.model.ProdutoA;

public class ProductBuilderA implements IProductBuilder {
    private ProdutoA product= new ProdutoA("");

    @Override
    public IProductBuilder buildName(String name) {
        product.setName(name);
        return this;
    }

    @Override
    public Product build() {
        return new ProdutoA(product.getName());
    }

}


