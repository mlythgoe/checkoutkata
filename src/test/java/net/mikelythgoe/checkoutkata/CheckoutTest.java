package net.mikelythgoe.checkoutkata;



import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CheckoutTest {

    private static Repository repository = new Repository();

    @Test
    void testItemUnitPriceRetrieval() {

        BigDecimal expectedUnitPriceForItemA = new BigDecimal("0.99");
        String codeA = "A";

        assertEquals(expectedUnitPriceForItemA, repository.getItemUnitPrice(codeA).getUnitPrice());

    }

    @Test
    void testItemSpecialPriceRetrieval() {

        Integer expectedNumberOfItemsForSpecialPriceForItemA = 3;
        BigDecimal expectedSpecialPriceForItemA = new BigDecimal("1.30");
        String codeA = "A";

        assertEquals(expectedNumberOfItemsForSpecialPriceForItemA,
                repository.getItemSpecialPrice(codeA).getNumberOfItems());

        assertEquals(expectedSpecialPriceForItemA, repository.getItemSpecialPrice(codeA).getSpecialPrice());

    }

    @Test
    void testItemUnitPriceRetrievalForNonExistentCode() {

        String nonExistentCode = "NonExistent";

        assertNull(repository.getItemUnitPrice(nonExistentCode));

    }

    @Test
    void testItemSpecialPriceRetrievalForNonExistentCode() {

        String nonExistentCode = "NonExistent";

        assertNull(repository.getItemSpecialPrice(nonExistentCode));

    }

    @Test
    void testTotalCostForNoItems() {

        Basket basket = new Basket();

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        assertEquals(new BigDecimal("0.00"), checkoutProcessor.calculateBasketTotalCost(basket));

    }

    @Test
    void testTotalCostForOneNormalPriceItemCodeA() {

        Basket basket = new Basket();

        BasketItem basketItem = new BasketItem("A");

        basket.addItem(basketItem);

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        assertEquals(new BigDecimal("0.99"), checkoutProcessor.calculateBasketTotalCost(basket));

    }

    @Test
    void testTotalCostForOneNormalPriceItemCodeB() {

        Basket basket = new Basket();

        BasketItem basketItem = new BasketItem("B");

        basket.addItem(basketItem);

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        assertEquals(new BigDecimal("0.30"), checkoutProcessor.calculateBasketTotalCost(basket));

    }

    @Test
    void testTotalCostForTwoNormalPriceItemsCodeAAndCodeB() {

        Basket basket = new Basket();

        BasketItem basketItem = new BasketItem("A");

        basket.addItem(basketItem);

        basketItem = new BasketItem("B");

        basket.addItem(basketItem);

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        assertEquals(new BigDecimal("1.29"), checkoutProcessor.calculateBasketTotalCost(basket));

    }

    @Test
    void testTotalCostForSpecialPriceItemsCodeA() {

        Basket basket = new Basket();

        basket.addItem(new BasketItem("A"));

        basket.addItem(new BasketItem("A"));

        basket.addItem(new BasketItem("A"));

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        assertEquals(new BigDecimal("1.30"), checkoutProcessor.calculateBasketTotalCost(basket));

    }

    @Test
    void testTotalCostForSpecialPriceCodeBAndNormalPriceCodeA() {

        Basket basket = new Basket();

        basket.addItem(new BasketItem("A"));

        basket.addItem(new BasketItem("A"));

        basket.addItem(new BasketItem("B"));

        basket.addItem(new BasketItem("B"));

        basket.addItem(new BasketItem("B"));

        basket.addItem(new BasketItem("B"));

        basket.addItem(new BasketItem("B"));

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        assertEquals(new BigDecimal("3.18"), checkoutProcessor.calculateBasketTotalCost(basket));


    }
}
