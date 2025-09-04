package com.workshop.errors;

import java.util.*;

public class InventoryService {
    private final Map<String, Product> map = new HashMap<>();

    public void add(Product p){ map.put(p.id(), p); }

    // Dirty: return codes + nulls
    public Product find(String id){
        if(map.containsKey(id)) return map.get(id);
        return null;
    }

    public int reserve(String id, int qty){
        Product p = map.get(id);
        if(p==null) return -1; // not found
        if(p.stock() < qty) return -2; // insufficient
        map.put(id, new Product(p.id(), p.name(), p.stock()-qty));
        return 0;
    }

    public int release(String id, int qty){
        Product p = map.get(id);
        if(p==null) return -1;
        map.put(id, new Product(p.id(), p.name(), p.stock()+qty));
        return 0;
    }
}
