package com.workshop.naming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PromotionEngineTest {

    @ParameterizedTest
    @CsvSource({
            "VIP, 10, 0.07",
            "EMPLOYEE, 1250, 0.2",
            "EMPLOYEE, 750, 0.15",
            "PARTNER, 825, 0.12",
            "PARTNER, 750, 0.1",
            "OTHER, 600, 0.03",
            "OTHER, 300, 0",
            "GOLD_PARTNER, 2500, 0.01",

    })
    void shouldTaxAmountCorrectly(CustomerType customerType, BigDecimal amount, BigDecimal expected){
        BigDecimal result = new PromotionEngine().promo(customerType, amount);
        assertEquals(expected, result);
    }

}