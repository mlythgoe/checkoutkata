package net.mikelythgoe;

public class CartItem {

    private String code;

    public CartItem(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "code='" + code + '\'' +
                '}';
    }
}
