package e_commerce.interfaces;

import e_commerce.model.Product;

public interface IOrderFacade {

        void changeOrderStatus(String status, Product product);


}
