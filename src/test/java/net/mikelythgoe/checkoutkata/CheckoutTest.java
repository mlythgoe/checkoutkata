package net.mikelythgoe.checkoutkata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CheckoutTest {

    private static Repository repository = new Repository();

    @Test
    void testItemUnitPriceRetrieval() {

        BigDecimal expectedUnitPriceForItemA = new BigDecimal("0.50");
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

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        assertEquals(new BigDecimal("0.00"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    void testTotalCostForOneNormalPriceItemCodeA() {

        Basket basket = new Basket();

        BasketItem basketItem = new BasketItem("A");

        basket.addItem(basketItem);

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addBasketItemToCheckout(basketItem);

        assertEquals(new BigDecimal("0.50"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    void testTotalCostForOneNormalPriceItemCodeB() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("B"));

        assertEquals(new BigDecimal("0.30"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    void testTotalCostForTwoNormalPriceItemsCodeAAndCodeB() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("A"));

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("B"));

        assertEquals(new BigDecimal("0.80"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    void testTotalCostForSpecialPriceItemsCodeA() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("A"));

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("A"));

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("A"));

        assertEquals(new BigDecimal("1.30"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    void testTotalCostForSpecialPriceCodeBAndNormalPriceCodeA() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("A"));

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("A"));

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("B"));

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("B"));

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("B"));

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("B"));

        checkoutProcessor.addBasketItemToCheckout(new BasketItem("B"));

        assertEquals(new BigDecimal("2.20"), checkoutProcessor.calculateCartTotalCost());


    }
}
