package com.workshop.featureenvy;

public class StatementGenerator {

    public String statement(Customer customer) {
        return message(customer);
    }

    private String message(Customer customer) {
        return customer.name() + " owes " + String.format("%.2f", customer.calculateBill());
    }
}
