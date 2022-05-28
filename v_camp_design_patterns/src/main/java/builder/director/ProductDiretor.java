package builder.director;

import builder.builders.*;
import builder.model.Product;


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
