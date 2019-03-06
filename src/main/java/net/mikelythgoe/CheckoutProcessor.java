package net.mikelythgoe;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CheckoutProcessor {

    private Map<String, Integer> aggregatedItems = new HashMap<String, Integer>();


    public void addCartItemToCheckout(String code) {

        Integer itemCount = aggregatedItems.get(code);

        if ( itemCount == null ) {
            aggregatedItems.put(code, 1);
        } else {
            aggregatedItems.put(code, ++itemCount);
        }

    }

    public BigDecimal calculateCartTotalCost() {


        Repository repository = new Repository();

        String code;
        Integer itemCount;

        BigDecimal totalCost = BigDecimal.ZERO;

        for (Map.Entry<String,Integer> entry : aggregatedItems.entrySet()) {

            BigDecimal itemUnitPrice = repository.getItemUnitPrice(entry.getKey()).getUnitPrice();

            totalCost = totalCost.add(itemUnitPrice.multiply(new BigDecimal(entry.getValue())));

        }

        return totalCost;



    }
}
