package com.workshop.naming;

import java.util.Locale;

/** Dirty: cryptic names, magic numbers, mixed concerns, and formatting mixed in. */
public class InvoiceCalculator {
    // type: 1=regular, 2=vip, 3=employee, 4=partner
    public String calc(int t, double a, String locale){
        double x=a;
        if(t==2){ x=a-(a*0.07); }
        else if(t==3){
            x=a-(a*0.15);
            if(a>1000){ x=x-(a*0.05); }
        } else if(t==4){
            x=a-(a*0.10);
            if(a>800){ x=x-(a*0.02); }
        } else {
            if(a>500){ x=a-(a*0.03); }
        }
        if(a<50){ x=x+4.99; } // shipping
        x=x*1.18; // tax
        double r = Math.round(x*100.0)/100.0;
        if("tr".equalsIgnoreCase(locale)){
            return String.format(new Locale("tr","TR"), "%.2f TL", r);
        } else {
            return String.format(Locale.US, "$%.2f", r);
        }
    }
}
