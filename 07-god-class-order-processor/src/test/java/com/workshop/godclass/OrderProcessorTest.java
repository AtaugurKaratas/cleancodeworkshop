package com.workshop.godclass;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class OrderProcessorTest {
    @Test
    void processes_order_happypath(){
        Order o = new Order("o1", "a@x", List.of(new Order.OrderLine("sku", 2, 300)));
        assertTrue(new OrderProcessor().process(o));
    }
}
