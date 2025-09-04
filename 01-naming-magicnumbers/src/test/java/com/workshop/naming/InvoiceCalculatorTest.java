package com.workshop.naming;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceCalculatorTest {
    @Test void regular_small_tr(){
        String s = new InvoiceCalculator().calc(1, 40, "tr");
        assertTrue(s.contains("TL"));
    }
    @Test void vip_medium_us(){
        String s = new InvoiceCalculator().calc(2, 600, "en");
        assertTrue(s.startsWith("$"));
    }
    @Test void employee_large(){
        String s = new InvoiceCalculator().calc(3, 1200, "tr");
        assertTrue(s.contains("TL"));
    }
}
