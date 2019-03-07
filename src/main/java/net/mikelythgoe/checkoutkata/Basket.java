package net.mikelythgoe.checkoutkata;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<BasketItem> basketItems;

    public Basket() {

        basketItems = new ArrayList<BasketItem>();

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
