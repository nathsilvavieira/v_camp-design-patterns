package e_commerce.director;

import e_commerce.interfaces.IProductBuilder;
import e_commerce.model.Product;


public class ProductDiretor {

    private IProductBuilder builder;

    public ProductDiretor(IProductBuilder builder) {
        this.builder = builder;
    }

    public Product constructProduct(){
      // builder.buildName("Produto A");
       return builder.build();
    }

}
