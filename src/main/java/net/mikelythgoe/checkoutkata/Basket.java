package net.mikelythgoe.checkoutkata;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<BasketItem> items;

    public Basket() {

        items = new ArrayList<BasketItem>();

    }

    public void addItem(BasketItem basketItem) {

        items.add(basketItem);

    }

    @Override
    public String toString() {
        return "Basket{" +
                "items=" + items +
                '}';
    }
}
