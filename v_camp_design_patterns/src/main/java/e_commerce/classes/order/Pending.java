package e_commerce.classes.order;

import e_commerce.interfaces.IOrderFacade;

public class Pending implements IOrderFacade {

    private String status = "Pending";
   // private Orderlist orderlist = Orderlist.getInstance();

    public String getStatusPending() {
        return status;
    }


    @Override
    public void changeOrderStatus() {
        System.out.println(getStatusPending());
    }
}
