package net.mikelythgoe.checkoutkata;

import java.math.BigDecimal;
import java.util.*;

public class CheckoutProcessor {

    private Map<String, Integer> aggregatedItems = new HashMap<String, Integer>();

    public void addCartItemToCheckout(String code) {

        Integer itemCount = aggregatedItems.get(code);

        if ( itemCount == null ) {
            aggregatedItems.put(code, 1);
        } else {
            aggregatedItems.put(code, ++itemCount);
        }

        //items.add(code);

    }

    public BigDecimal calculateCartTotalCost() {


//        List<Person> people = Arrays.asList(new Person("Steve", "wine"), new Person("Steve", "cola"),
//                new Person("Ben", "cola"), new Person("Ben", "cola"), new Person("Steve", "wine"),
//                new Person("Steve", "wine"));
//
//        Map<Person, Long> map = people.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        Map<String, Integer> map = items.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Repository repository = new Repository();

        BigDecimal totalCost = new BigDecimal("0.00");

        String code;
        Integer quantity;

        for (Map.Entry<String,Integer> entry : aggregatedItems.entrySet()) {

            code = entry.getKey();
            quantity = entry.getValue();

            ItemSpecialPrice itemSpecialPrice = repository.getItemSpecialPrice(code);

            ItemUnitPrice itemUnitPrice = repository.getItemUnitPrice(code);

            BigDecimal itemTotalCost;

            // Calculate special price if item has sufficient quantity to qualify
            // Calculate normal price for any of those items that didn't qualify for the special price
            // If the item quantity does not qualify for a special price calculate the normal price
            if (itemSpecialPrice != null && itemSpecialPrice.getNumberOfItems() <= quantity) {

                BigDecimal specialPriceTotal = new BigDecimal(
                        quantity / itemSpecialPrice.getNumberOfItems() )
                        .multiply(itemSpecialPrice.getSpecialPrice() );

                BigDecimal normalPriceTotal = new BigDecimal(
                        quantity % itemSpecialPrice.getNumberOfItems() ).multiply(itemUnitPrice.getUnitPrice());

                itemTotalCost = specialPriceTotal.add(normalPriceTotal);

            } else {

                // Item didn't qualify for special price
                itemTotalCost = new BigDecimal(quantity).multiply(itemUnitPrice.getUnitPrice());

            }

            totalCost = totalCost.add(itemTotalCost);

        }

        return totalCost;

    }
}
