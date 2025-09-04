package com.workshop.godclass;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;

public class OrderProcessor {
    // Dirty: God method, hidden I/O, static config, mixed concerns
    public boolean process(Order order){
        double total = 0;
        for(Order.OrderLine l: order.lines()){
            total += l.qty() * l.unitPrice();
        }
        // discounts
        if(total > 500) total = total * 0.95;
        if(total > 1000) total = total * 0.90;
        // shipping
        if(total < 100) total += 9.99;
        // tax
        total = total * 1.18;

        // persist
        try {
            Path p = Paths.get("orders", order.id()+".txt");
            Files.createDirectories(p.getParent());
            Files.writeString(p, order.id()+","+total+","+ LocalDateTime.now());
        } catch (IOException e) {
            return false;
        }

        // notify
        System.out.println("Email to "+order.customerEmail()+": your total is "+total);

        // payment (fake)
        System.out.println("Charging credit card for "+total);

        return true;
    }
}
