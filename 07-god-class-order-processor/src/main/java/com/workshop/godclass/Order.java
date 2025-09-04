package com.workshop.godclass;

import java.util.List;

public record Order(String id, String customerEmail, List<OrderLine> lines) {
    public record OrderLine(String sku, int qty, double unitPrice){}
    public double total(){ return lines.stream().mapToDouble(l -> l.qty()*l.unitPrice()).sum(); }
}
