package net.mikelythgoe.checkoutkata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CheckoutTest {


    private static Repository repository = new Repository();

    @Test
    public void testItemUnitPriceRetrieval() {

        BigDecimal expectedUnitPriceForItemA = new BigDecimal("0.50");
        String codeA = "A";

        assertEquals(expectedUnitPriceForItemA, repository.getItemUnitPrice(codeA).getUnitPrice());

    }

    @Test
    public void testItemSpecialPriceRetrieval() {

        Integer expectedNumberOfItemsForSpecialPriceForItemA = new Integer(3);
        BigDecimal expectedSpecialPriceForItemA = new BigDecimal("1.30");
        String codeA = "A";

        assertEquals(expectedNumberOfItemsForSpecialPriceForItemA,
                repository.getItemSpecialPrice(codeA).getNumberOfItems());

        assertEquals(expectedSpecialPriceForItemA, repository.getItemSpecialPrice(codeA).getSpecialPrice());

    }

    @Test
    public void testItemUnitPriceRetrievalForNonExistentCode() {

        String nonExistentCode = "NonExistent";

        assertNull(repository.getItemUnitPrice(nonExistentCode));

    }

    @Test
    public void testItemSpecialPriceRetrievalForNonExistentCode() {

        String nonExistentCode = "NonExistent";

        assertNull(repository.getItemSpecialPrice(nonExistentCode));

    }

    @Test
    public void testTotalCostForNoItems() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        assertEquals(new BigDecimal("0.00"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    public void testTotalCostForOneNormalPriceItemCodeA() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addCartItemToCheckout("A");

        assertEquals(new BigDecimal("0.50"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    public void testTotalCostForOneNormalPriceItemCodeB() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addCartItemToCheckout("B");

        assertEquals(new BigDecimal("0.30"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    public void testTotalCostForTwoNormalPriceItemsCodeAAndCodeB() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addCartItemToCheckout("A");

        checkoutProcessor.addCartItemToCheckout("B");

        assertEquals(new BigDecimal("0.80"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    public void testTotalCostForSpecialPriceItemsCodeA() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addCartItemToCheckout("A");

        checkoutProcessor.addCartItemToCheckout("A");

        checkoutProcessor.addCartItemToCheckout("A");

        assertEquals(new BigDecimal("1.30"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    public void testTotalCostForSpecialPriceCodeBAndNormalPriceCodeA() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addCartItemToCheckout("A");

        checkoutProcessor.addCartItemToCheckout("A");

        checkoutProcessor.addCartItemToCheckout("B");

        checkoutProcessor.addCartItemToCheckout("B");

        checkoutProcessor.addCartItemToCheckout("B");

        checkoutProcessor.addCartItemToCheckout("B");

        checkoutProcessor.addCartItemToCheckout("B");

        assertEquals(new BigDecimal("2.20"), checkoutProcessor.calculateCartTotalCost());


    }
}
