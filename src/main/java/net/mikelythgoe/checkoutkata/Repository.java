package net.mikelythgoe.checkoutkata;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    private Map<String, ItemUnitPrice> itemPrices = new HashMap<String, ItemUnitPrice>();

    private Map<String, ItemSpecialPrice> itemSpecialPrices = new HashMap<String, ItemSpecialPrice>();

    public Repository() {

        ItemUnitPrice itemA = new ItemUnitPrice("A", new BigDecimal("0.50"));
        itemPrices.put(itemA.getCode(), itemA);

        ItemUnitPrice itemB = new ItemUnitPrice("B", new BigDecimal("0.30"));
        itemPrices.put(itemB.getCode(), itemB);

        ItemUnitPrice itemC = new ItemUnitPrice("C", new BigDecimal("0.20"));
        itemPrices.put(itemC.getCode(), itemC);

        ItemUnitPrice itemD = new ItemUnitPrice("D", new BigDecimal("0.15"));
        itemPrices.put(itemD.getCode(), itemD);


        ItemSpecialPrice itemSpecialPriceA = new ItemSpecialPrice("A", 3, new BigDecimal("1.30"));
        itemSpecialPrices.put(itemSpecialPriceA.getCode(), itemSpecialPriceA);

        ItemSpecialPrice itemSpecialPriceB = new ItemSpecialPrice("B", 2, new BigDecimal("0.45"));
        itemSpecialPrices.put(itemSpecialPriceB.getCode(), itemSpecialPriceB);

    }

    public ItemUnitPrice getItemUnitPrice(String code) {

        return itemPrices.get(code);

    }

    public ItemSpecialPrice getItemSpecialPrice(String code) {

        return itemSpecialPrices.get(code);

    }

}
