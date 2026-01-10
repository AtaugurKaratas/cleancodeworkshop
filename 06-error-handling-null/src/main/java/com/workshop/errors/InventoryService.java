package com.workshop.errors;

import java.time.LocalDateTime;
import java.util.*;

public class InventoryService {
    private final Map<String, Product> productById = new HashMap<>();
    private static final long EXPIRED_MINUTES = 15;

    enum ResponseCode {
        SUCCESS, NOT_FOUND, INSUFFICIENT_STOCK, EXPIRED_RESERVATION
    }

    public void addProduct(Product p) {
        productById.put(p.id(), p);
    }

    public Optional<Product> findProduct(String id) {
        return Optional.ofNullable(productById.get(id));
    }

    public String reserver(String productId, int quantity) {
        return findProduct(productId)
                .map(product -> {
                    if (isProductExpired(product)) return ResponseCode.EXPIRED_RESERVATION.toString();
                    if (product.stock() < quantity) return ResponseCode.INSUFFICIENT_STOCK.toString();
                    productById.put(productId, new Product(product.id(), product.name(), product.stock() - quantity));
                    return ResponseCode.SUCCESS.toString();
                }).orElse(ResponseCode.NOT_FOUND.toString());
    }

    public String release(String productId, int quantity) {
        return findProduct(productId)
                .map(product -> {
                    if (isProductExpired(product)) return ResponseCode.EXPIRED_RESERVATION.toString();
                    productById.put(productId, new Product(product.id(), product.name(), product.stock() + quantity));
                    return ResponseCode.SUCCESS.toString();
                }).orElse(ResponseCode.NOT_FOUND.toString());
    }

    private boolean isProductExpired(Product product) {
        return LocalDateTime.now().isAfter(product.atExpired().plusMinutes(EXPIRED_MINUTES));
    }
}
