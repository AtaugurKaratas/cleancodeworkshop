package com.workshop.naming;

import java.math.BigDecimal;

public class Constants {

    private Constants() {}

    public static final BigDecimal VIP_BASE_TAX = BigDecimal.valueOf(0.07);
    public static final BigDecimal EMPLOYEE_BASE_TAX = BigDecimal.valueOf(0.15);
    public static final BigDecimal PARTNER_BASE_TAX = BigDecimal.valueOf(0.10);
    public static final BigDecimal GOLD_PARTNER_BASE_TAX = BigDecimal.valueOf(0.01);
    public static final BigDecimal OTHER_BASE_TAX = BigDecimal.valueOf(0.03);
    public static final BigDecimal BASE_TAX = BigDecimal.valueOf(1.18);

    public static final BigDecimal EMPLOYEE_BASE_AMOUNT_CONTROL = BigDecimal.valueOf(1000);
    public static final BigDecimal PARTNER_BASE_AMOUNT_CONTROL = BigDecimal.valueOf(800);
    public static final BigDecimal OTHER_BASE_AMOUNT_CONTROL = BigDecimal.valueOf(500);

    public static final BigDecimal EMPLOYEE_EXTRA_TAX = BigDecimal.valueOf(0.20);
    public static final BigDecimal PARTNER_EXTRA_TAX = BigDecimal.valueOf(0.12);

    public static final BigDecimal BASE_SHIPPING_CONTROL = BigDecimal.valueOf(50);
    public static final BigDecimal BASE_SHIPPING_CONTROL_AMOUNT = BigDecimal.valueOf(4.99);

    public static final String TURKIYE_LANGUAGE_CODE = "tr";
    public static final String TURKIYE_CURRENCY_CODE = "TL";
}
