package com.workshop.naming;

import java.math.BigDecimal;

import static com.workshop.naming.CustomerType.*;

/**
 * Dirty: duplicated rules, same calculations scattered in different class
 */
public class PromotionEngine {
    // returns discount percent as a fraction

    public BigDecimal promo(CustomerType customerType, BigDecimal amount) {
        return switch (customerType) {
            case VIP -> VIP.promo(amount);
            case EMPLOYEE -> EMPLOYEE.promo(amount);
            case PARTNER -> PARTNER.promo(amount);
            case GOLD_PARTNER -> GOLD_PARTNER.promo(amount);
            default -> OTHER.promo(amount);
        };
    }
}
