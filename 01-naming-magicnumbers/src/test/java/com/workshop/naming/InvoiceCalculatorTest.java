package com.workshop.naming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "VIP, 40, tr, TL",
            "VIP, 55, tr, TL",
            "EMPLOYEE, 850, tr, TL",
            "EMPLOYEE, 1250, tr, TL",
            "PARTNER, 650 , tr, TL",
            "PARTNER, 900, tr, TL",
            "OTHER, 40, tr, TL",
            "OTHER, 60, tr, TL",
            "OTHER, 400, tr, TL",
            "OTHER, 600, tr, TL",
            "GOLD_PARTNER, 3000, tr, TL",

    })
    void shouldFormatAmountCurrencyCorrectly(CustomerType customerType, BigDecimal amount, String locale, String expected){
        String s = new InvoiceCalculator().calc(customerType, amount, locale);
        assertTrue(s.contains(expected));
    }

    @ParameterizedTest
    @CsvSource({
            "VIP, 40, us, TL",
            "VIP, 55, us, TL",
            "EMPLOYEE, 850, us, TL",
            "EMPLOYEE, 1250, us, TL",
            "PARTNER, 650 , us, TL",
            "PARTNER, 900, us, TL",
            "OTHER, 40, us, TL",
            "OTHER, 60, us, TL",
            "OTHER, 400, us, TL",
            "OTHER, 600, us, TL",
            "GOLD_PARTNER, 3000, us, TL",

    })
    void shouldFormatAmountCurrencyIncorrectly(CustomerType customerType, BigDecimal amount, String locale, String expected){
        String s = new InvoiceCalculator().calc(customerType, amount, locale);
        assertFalse(s.contains(expected));
    }
}
