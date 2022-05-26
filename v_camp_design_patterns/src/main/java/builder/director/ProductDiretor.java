package builder.director;

import builder.builders.*;


public class ProductDiretor {
    private IProductBuilder builder;


    public ProductDiretor(IProductBuilder builder) {
        this.builder = builder;
    }


      public void constructProductA(){
        ProductBuilderA builder = new ProductBuilderA();
        builder.buildname();
        builder.buildsku();
        builder.buildprice();
        builder.buildweight();
          System.out.println("Produto gerado "+ builder.getProductA());
    }


}
