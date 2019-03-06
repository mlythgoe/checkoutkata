package net.mikelythgoe;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckoutProcessor {

    private Map<String, Integer> aggregatedItems = new HashMap<String, Integer>();

//    private List<String> items = new ArrayList<>();



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

        BigDecimal totalCost = BigDecimal.ZERO;

        String code;
        Integer quantity;

        for (Map.Entry<String,Integer> entry : aggregatedItems.entrySet()) {

            code = entry.getKey();
            quantity = entry.getValue();

            ItemSpecialPrice itemSpecialPrice = repository.getItemSpecialPrice(code);

            ItemUnitPrice itemUnitPrice = repository.getItemUnitPrice(code);

            BigDecimal itemTotalCost = BigDecimal.ZERO;

            if (itemSpecialPrice != null && itemSpecialPrice.getNumberOfItems() <= quantity) {

                // Calculate discount price
                // quantity / number of items = discount units (multiple bprice
                // quantity mod number of times = units at full price

                BigDecimal specialPriceTotal = new BigDecimal(
                        quantity / itemSpecialPrice.getNumberOfItems() )
                        .multiply(itemSpecialPrice.getSpecialPrice() );

                BigDecimal normalPriceTotal = new BigDecimal(
                        quantity % itemSpecialPrice.getNumberOfItems() ).multiply(itemUnitPrice.getUnitPrice());

                itemTotalCost = specialPriceTotal.add(normalPriceTotal);

            } else {

                itemTotalCost = new BigDecimal(quantity).multiply(itemUnitPrice.getUnitPrice());

            }

            totalCost = totalCost.add(itemTotalCost);

        }

        return totalCost;

    }
}
