package e_commerce.classes.order;

import e_commerce.interfaces.IOrderFacade;

public class Pending implements IOrderFacade {

    private String status = "Pending";

    public String getStatusPending() {
        return status;
    }


    @Override
    public void changeOrderStatus() {
        System.out.println(getStatusPending());
    }

    @Override
    public String toString() {
        return "Pending";

    }
}


