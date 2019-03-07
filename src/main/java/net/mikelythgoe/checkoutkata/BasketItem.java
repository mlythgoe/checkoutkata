package net.mikelythgoe.checkoutkata;

public class BasketItem {

    private String code;

    public BasketItem(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "BasketItem{" +
                "code='" + code + '\'' +
                '}';
    }

}
