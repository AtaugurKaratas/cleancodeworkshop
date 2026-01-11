package com.workshop.featureenvy;

public record Customer(String name, int usage, double rate, double tax) {

    public double calculateBill() {
        double subtotal = calculateSubtotal();
        return calculateTotal(subtotal);
    }

    private double calculateSubtotal() {
        return rate() * usage();
    }

    private double calculateTotal(double subtotal) {
        return subtotal + (subtotal * tax());
    }
}
