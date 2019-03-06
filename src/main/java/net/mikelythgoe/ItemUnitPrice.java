package net.mikelythgoe;

import java.math.BigDecimal;

public class ItemUnitPrice {

    private String code;
    private BigDecimal unitPrice;

    public ItemUnitPrice(String code, BigDecimal unitPrice) {
        this.code = code;
        this.unitPrice = unitPrice;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "ItemUnitPrice{" +
                "code='" + code + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
