package com.workshop.godclass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderProcessorTest {

    OrderService orderService;
    OrderRepository orderRepository;
    PaymentGateway paymentGateway;
    Notifier notifier;
    OrderProcessor processor;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
        orderRepository = mock(OrderRepository.class);
        paymentGateway = mock(PaymentGateway.class);
        notifier = mock(Notifier.class);
        processor = new OrderProcessor(orderService, orderRepository, paymentGateway, notifier);
    }

    @Test
    void shouldProcessOrder_whenReturnTrue() {
        Order order = new Order("o1", "a@x", List.of(new Order.OrderLine("sku", 2, 250)
                ,new Order.OrderLine("xyz", 3, 500)));
        boolean result = processor.process(order);

        double expected = 2124.0;

        verify(orderRepository).saveFile(order, expected);
        verify(notifier).notifyEmail(order, expected);
        verify(paymentGateway).paymentCreditCard(expected);

        assertTrue(result);
    }


}
