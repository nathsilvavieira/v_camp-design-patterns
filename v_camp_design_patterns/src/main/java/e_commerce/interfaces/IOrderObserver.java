package e_commerce.interfaces;

import e_commerce.facade.Order;

public interface IOrderObserver {

     void notifyOrderChange(Order order);
}
