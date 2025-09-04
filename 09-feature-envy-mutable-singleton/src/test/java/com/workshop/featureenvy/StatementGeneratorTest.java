package com.workshop.featureenvy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatementGeneratorTest {
    @Test void computes(){
        Config.get().tax = 0.18;
        String s = new StatementGenerator().statement(new Customer("Ada", 100, 1.0));
        assertTrue(s.contains("118.00"));
    }
}
