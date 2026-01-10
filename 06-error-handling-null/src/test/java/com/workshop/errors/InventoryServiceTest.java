package com.workshop.errors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        inventoryService = new InventoryService();
    }

    @Test
    void shouldReturnInsufficientStock_whenQuantityBiggerThanProductStock() {
        inventoryService.addProduct(new Product("1", "Pencil", 1));
        assertEquals("INSUFFICIENT_STOCK", inventoryService.reserver("1", 2));
    }

    @Test
    void shouldReturnExpiredReservation_whenReservationOlderThan15Minutes() {
        inventoryService.addProduct(new Product("1", "Pencil", 1, LocalDateTime.now().minusMinutes(16)));
        assertEquals("EXPIRED_RESERVATION", inventoryService.reserver("1", 1));
    }

    @Test
    void shouldReturnSuccess_whenProductExistsInStock() {
        inventoryService.addProduct(new Product("1", "Pencil", 1));
        assertEquals("SUCCESS", inventoryService.reserver("1", 1));
    }

    @Test
    void shouldReturnNotFound_whenProductDoesNotExistInStock() {
        assertEquals("NOT_FOUND", inventoryService.reserver("2", 1));
    }

    @Test
    void shouldAddProductQuantity_whenProductExistsInStock() {
        inventoryService.addProduct(new Product("1", "Pencil", 1));
        assertEquals("SUCCESS", inventoryService.release("1", 1));
    }

    @Test
    void shouldReturnExpiredReservation_whenReservationOlderThan15MinutesOnRelease() {
        inventoryService.addProduct(new Product("1", "Pencil", 1, LocalDateTime.now().minusMinutes(16)));
        assertEquals("EXPIRED_RESERVATION", inventoryService.release("1", 1));
    }
}
