package net.mikelythgoe.checkoutkata;

import java.util.ArrayList;
import java.util.List;

/**
 * Trigger Jenkins Build
 * Actually - this is the line change that should trigger a build
 */

public class Basket {

    private List<BasketItem> basketItems;

    public Basket() {

        basketItems = new ArrayList<>();

    }

    public List<BasketItem> getBasketItems() {

        return basketItems;

    }

    public void addItem(BasketItem basketItem) {

        basketItems.add(basketItem);

    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketItems=" + basketItems +
                '}';
    }
}
