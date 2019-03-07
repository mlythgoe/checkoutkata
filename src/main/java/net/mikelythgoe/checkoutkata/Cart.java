package net.mikelythgoe.checkoutkata;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items;

    public Cart() {

        items = new ArrayList<CartItem>();

    }

    public void addItem(CartItem cartItem) {

        items.add(cartItem);

    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
