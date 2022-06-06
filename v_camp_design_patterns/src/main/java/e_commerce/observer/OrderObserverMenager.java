package e_commerce.observer;

import e_commerce.facade.Order;
import e_commerce.interfaces.IOrderObserver;

import java.util.ArrayList;
import java.util.List;

public class OrderObserverMenager {



    public List<IOrderObserver> listeners = new ArrayList<>();

    public void subscribe(IOrderObserver iOrderObserver){
        listeners.add(iOrderObserver);
    }
    public void unsubscribe(IOrderObserver iOrderObserver){
        listeners.remove(iOrderObserver);
    }


    public void notifyChange(Order order){
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).notifyOrderChange(order);
        }
    }
}
