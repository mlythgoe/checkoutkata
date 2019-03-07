package net.mikelythgoe.checkoutkata;

import net.mikelythgoe.checkoutkata.CheckoutProcessor;
import net.mikelythgoe.checkoutkata.Repository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * Unit test for simple App.
 */
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
    public void testTotalCostforOneNormalPriceItemCodeA() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addCartItemToCheckout("A");

        assertEquals(new BigDecimal("0.50"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    public void testTotalCostforOneNormalPriceItemCodeB() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addCartItemToCheckout("B");

        assertEquals(new BigDecimal("0.30"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    public void testTotalCostforTwoNormalPriceItemsCodeAAndCodeB() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addCartItemToCheckout("A");

        checkoutProcessor.addCartItemToCheckout("B");

        assertEquals(new BigDecimal("0.80"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    public void testTotalCostforSpecialPriceItemsCodeA() {

        CheckoutProcessor checkoutProcessor = new CheckoutProcessor();

        checkoutProcessor.addCartItemToCheckout("A");

        checkoutProcessor.addCartItemToCheckout("A");

        checkoutProcessor.addCartItemToCheckout("A");

        assertEquals(new BigDecimal("1.30"), checkoutProcessor.calculateCartTotalCost());

    }

    @Test
    public void testTotalCostforSpecialPriceCodeBAndsNormalPriceCodeA() {

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
