package builder.model;

import java.time.LocalDateTime;

public class Reserve {

    private int quantity = 0;
    private String product = "";
    LocalDateTime nowDate = LocalDateTime.now();
    LocalDateTime expiredDate = LocalDateTime.now().plusHours(1);

    public Reserve(int quantity, String product, LocalDateTime nowDate, LocalDateTime expiredDate) {
        this.quantity = quantity;
        this.product = product;
        this.nowDate = nowDate;
        this.expiredDate = expiredDate;
    }

    public Reserve() {

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public LocalDateTime getNowDate() {
        return nowDate;
    }

    public void setNowDate(LocalDateTime nowDate) {
        this.nowDate = nowDate;
    }

    public LocalDateTime getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDateTime expiredDate) {
        this.expiredDate = expiredDate;
    }

    public boolean isDateExpired(){
        LocalDateTime nowDate = LocalDateTime.now();
        return getExpiredDate().isAfter(nowDate);
    }
}
