package com.workshop.featureenvy;

public class StatementGenerator {
    // Dirty: feature envy + global state
    public String statement(Customer c){
        double subtotal = c.getUsage() * c.getRate();
        double total = subtotal + (subtotal * Config.get().tax);
        return c.getName()+" owes "+String.format("%.2f", total);
    }
}
