package com.workshop.naming;

import java.math.BigDecimal;

public enum CustomerType {
    VIP {
        @Override
        public BigDecimal promo(BigDecimal amount) {
            return Constants.VIP_BASE_TAX;
        }
        @Override
        public BigDecimal calculation(BigDecimal amount) {
            return amount.subtract(amount.multiply(Constants.VIP_BASE_TAX));
        }
    },
    EMPLOYEE {
        @Override
        public BigDecimal promo(BigDecimal amount) {
            return amount.compareTo(Constants.EMPLOYEE_BASE_AMOUNT_CONTROL) > 0 ? Constants.EMPLOYEE_EXTRA_TAX : Constants.EMPLOYEE_BASE_TAX;
        }
        @Override
        public BigDecimal calculation(BigDecimal amount) {
            return amount.compareTo(Constants.EMPLOYEE_BASE_AMOUNT_CONTROL) > 0
                    ? amount.subtract(amount.multiply(Constants.EMPLOYEE_EXTRA_TAX))
                    : amount.subtract(amount.multiply(Constants.EMPLOYEE_BASE_TAX));
        }
    },
    PARTNER {
        @Override
        public BigDecimal promo(BigDecimal amount) {
            return amount.compareTo(Constants.PARTNER_BASE_AMOUNT_CONTROL) > 0 ? Constants.PARTNER_EXTRA_TAX : Constants.PARTNER_BASE_TAX;
        }
        @Override
        public BigDecimal calculation(BigDecimal amount) {
            return amount.compareTo(Constants.PARTNER_BASE_AMOUNT_CONTROL) > 0
                    ? amount.subtract(amount.multiply(Constants.PARTNER_EXTRA_TAX))
                    : amount.subtract(amount.multiply(Constants.PARTNER_BASE_TAX));
        }
    },
    OTHER {
        @Override
        public BigDecimal promo(BigDecimal amount) {
            return amount.compareTo(Constants.OTHER_BASE_AMOUNT_CONTROL) > 0 ? Constants.OTHER_BASE_TAX : BigDecimal.ZERO;
        }
        @Override
        public BigDecimal calculation(BigDecimal amount) {
            return amount.compareTo(Constants.OTHER_BASE_AMOUNT_CONTROL) > 0
                    ? amount.subtract(amount.multiply(Constants.OTHER_BASE_TAX))
                    : amount;
        }
    },
    GOLD_PARTNER {
        @Override
        public BigDecimal promo(BigDecimal amount) {
            return Constants.GOLD_PARTNER_BASE_TAX;
        }
        @Override
        public BigDecimal calculation(BigDecimal amount) {
            return amount.subtract(amount.multiply(Constants.GOLD_PARTNER_BASE_TAX));
        }
    };

    public abstract BigDecimal promo(BigDecimal amount);
    public abstract BigDecimal calculation(BigDecimal amount);
}
