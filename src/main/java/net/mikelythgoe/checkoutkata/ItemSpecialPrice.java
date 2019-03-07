package net.mikelythgoe.checkoutkata;

import java.math.BigDecimal;

/**
 * Item Special Price is the special price for a number of items that are on a promotional price
 */
public class ItemSpecialPrice {

    private String code;
    private Integer numberOfItems;
    private BigDecimal specialPrice;

    public ItemSpecialPrice(String code, Integer numberOfItems, BigDecimal specialPrice) {

        this.code = code;
        this.numberOfItems = numberOfItems;
        this.specialPrice = specialPrice;

    }

    public String getCode() {

        return code;

    }

    public Integer getNumberOfItems() {

        return numberOfItems;

    }

    public BigDecimal getSpecialPrice() {

        return specialPrice;

    }

    @Override
    public String toString() {

        return "ItemSpecialPrice{" +
                "code='" + code + '\'' +
                ", numberOfItems=" + numberOfItems +
                ", specialPrice=" + specialPrice +
                '}';

    }

}
