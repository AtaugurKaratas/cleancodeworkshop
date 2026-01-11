package com.workshop.featureenvy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StatementGeneratorTest {
    @Test
    void computes() {
        Customer customer = new Customer("Ada", 100, 1.0, Config.getInstance().getTax());
        String statement = new StatementGenerator().statement(customer);
        // 100 * 1.0 * 1.8 = 118.00
        assertTrue(statement.contains("118.00"));
    }
}
