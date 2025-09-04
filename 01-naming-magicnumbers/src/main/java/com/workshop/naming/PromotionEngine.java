package com.workshop.naming;

/** Dirty: duplicated rules, same calculations scattered in different class */
public class PromotionEngine {
    // returns discount percent as a fraction
    public double promo(int customerType, double amount){
        if(customerType==2){ return 0.07; }
        if(customerType==3){
            double d=0.15;
            if(amount>1000){ d += 0.05; }
            return d;
        }
        if(customerType==4){
            double d=0.10;
            if(amount>800){ d += 0.02; }
            return d;
        }
        if(amount>500){ return 0.03; }
        return 0.0;
    }
}
