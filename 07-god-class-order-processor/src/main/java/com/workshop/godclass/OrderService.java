package com.workshop.godclass;

import static com.workshop.godclass.Constants.*;

public class OrderService {

    public double calculateDiscount(double total) {
        if (total > MAIN_PRICE_THRESHOLD) return total * MAIN_DISCOUNT_RATE;
        if (total > SECOND_PRICE_THRESHOLD) return total * SECOND_DISCOUNT_RATE;
        return total;
    }

    public double calculateShipping(double total) {
        if (total < MIN_FREE_SHIPPING_THRESHOLD) return total + SHIPPING_COST;
        return total;
    }

    public double calculateTax(double total) {
        return total * TAX_MULTIPLIER;
    }

}
