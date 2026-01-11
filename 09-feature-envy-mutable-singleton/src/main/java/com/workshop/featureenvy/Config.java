package com.workshop.featureenvy;

public class Config {
    private static final Config INSTANCE = new Config();
    private final double tax;

    private Config() {
        this.tax = loadTaxRate();
    }

    public static Config getInstance() {
        return INSTANCE;
    }

    public double getTax() {
        return tax;
    }

    private double loadTaxRate() {
        return 0.18;
    }
}
