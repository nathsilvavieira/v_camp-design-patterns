package builder.builders;

import builder.model.Product;

public interface IProductBuilder {

   IProductBuilder buildName(String name);

   Product build();

//   Product getProduct();
}
