package com.workshop.godclass;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderRepositoryTest {

    private final OrderRepository orderRepository = new OrderRepository();

    @Test
    void shouldSaveFile() throws IOException {
        //Given
        Order order = new Order("o1", "a@x", List.of(new Order.OrderLine("sku", 2, 300)
                ,new Order.OrderLine("xyz", 3, 500)));
        double total = 150.0;

        //When
        orderRepository.saveFile(order, total);
        Path ordersPath = Paths.get("orders", order.id() + ".txt");

        //Then
        assertTrue(Files.exists(ordersPath));

        String content = Files.readString(ordersPath);
        assertTrue(content.contains(String.valueOf(order.id())));
        assertTrue(content.contains(String.valueOf(total)));
    }
}