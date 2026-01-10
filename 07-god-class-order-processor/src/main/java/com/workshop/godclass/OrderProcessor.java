package com.workshop.godclass;

public class OrderProcessor {

    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final PaymentGateway paymentGateway;
    private final Notifier notifier;

    public OrderProcessor(OrderService orderService, OrderRepository orderRepository, PaymentGateway paymentGateway, Notifier notifier) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.paymentGateway = paymentGateway;
        this.notifier = notifier;
    }

    public boolean process(Order order) {
        double total = readLines(order);

        total = calculateTotal(total);

        orderRepository.saveFile(order, total);

        notifier.notifyEmail(order, total);

        paymentGateway.paymentCreditCard(total);

        return true;
    }

    private double readLines(Order order) {
        return order.total();
    }

    private double calculateTotal(double total) {
        double totalPrice = orderService.calculateDiscount(total);
        totalPrice = orderService.calculateShipping(totalPrice);
        totalPrice = orderService.calculateTax(totalPrice);
        return totalPrice;
    }
}
