package com.workshop.featureenvy;

public class Customer {
    private final String name;
    private final int usage; // kWh for example
    private final double rate; // per unit

    public Customer(String name, int usage, double rate){
        this.name = name; this.usage = usage; this.rate = rate;
    }
    public String getName(){ return name; }
    public int getUsage(){ return usage; }
    public double getRate(){ return rate; }
}
