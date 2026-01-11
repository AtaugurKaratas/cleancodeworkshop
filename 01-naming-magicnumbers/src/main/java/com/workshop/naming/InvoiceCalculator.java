package com.workshop.naming;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import static com.workshop.naming.Constants.*;
import static com.workshop.naming.CustomerType.*;

/**
 * Dirty: cryptic names, magic numbers, mixed concerns, and formatting mixed in.
 */
public class InvoiceCalculator {
    // type: 1=regular, 2=vip, 3=employee, 4=partner
    public String calc(CustomerType customerType, BigDecimal amount, String locale) {
        BigDecimal customerTypeResult = switch (customerType) {
            case VIP -> VIP.calculation(amount);
            case EMPLOYEE -> EMPLOYEE.calculation(amount);
            case PARTNER -> PARTNER.calculation(amount);
            case GOLD_PARTNER -> GOLD_PARTNER.calculation(amount);
            default -> OTHER.calculation(amount);
        };

        BigDecimal baseAmount = amount.add(customerTypeResult);

        BigDecimal withShipping = applyShipping(amount, baseAmount);

        BigDecimal withTax = applyTax(withShipping);

        BigDecimal result = withTax.setScale(2, RoundingMode.HALF_UP);

        return getLocaleFormat(result, locale);
    }

    private BigDecimal applyShipping(BigDecimal amount, BigDecimal result) {
        if (amount.compareTo(BASE_SHIPPING_CONTROL) < 0) {
            result = result.add(BASE_SHIPPING_CONTROL_AMOUNT);
        }
        return result;
    }

    private BigDecimal applyTax(BigDecimal result) {
        return result.multiply(BASE_TAX);
    }

    private String getLocaleFormat(BigDecimal amount, String locale) {
        if (TURKIYE_LANGUAGE_CODE.equalsIgnoreCase(locale)) {
            return String.format(Locale.of(TURKIYE_LANGUAGE_CODE, TURKIYE_CURRENCY_CODE), "%.2f TL", amount);
        } else {
            return String.format(Locale.US, "$%.2f", amount);
        }
    }
}