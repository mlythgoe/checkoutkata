package net.mikelythgoe.checkoutkata;

public class BasketItem {

    private String code;

    public BasketItem(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BasketItem{" +
                "code='" + code + '\'' +
                '}';
    }

}
