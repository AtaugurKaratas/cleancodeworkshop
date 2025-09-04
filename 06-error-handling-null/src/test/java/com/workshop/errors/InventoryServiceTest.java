package com.workshop.errors;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceTest {
    @Test
    void reserves_when_enough(){
        InventoryService s = new InventoryService();
        s.add(new Product("1","Pen", 5));
        assertEquals(0, s.reserve("1", 3));
        assertEquals(0, s.release("1", 2));
    }
    @Test
    void codes_for_missing_and_insufficient(){
        InventoryService s = new InventoryService();
        assertEquals(-1, s.reserve("X", 1));
        s.add(new Product("2","Pencil", 1));
        assertEquals(-2, s.reserve("2", 2));
    }
}
