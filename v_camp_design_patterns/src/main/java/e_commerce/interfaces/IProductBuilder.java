package e_commerce.interfaces;

import e_commerce.model.Product;

public interface IProductBuilder {

   IProductBuilder buildName(String name);

   IProductBuilder buildSku(String sku);

   IProductBuilder buildPrice(double price);

   IProductBuilder buildWeight(double weight);

   Product build();

//   Product getProduct();
}
