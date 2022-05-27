package builder.director;

import builder.builders.*;
import builder.model.Product;


public class ProductDiretor {

    private IProductBuilder builder;




    public ProductDiretor(IProductBuilder builder) {

        this.builder= builder;
    }


      public void constructProductA(){
       builder.buildName("Produto A");
       builder.build();

    }

    public Product getProductCreated() {
        return builder.getProduct();
    }


}
