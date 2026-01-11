package com.workshop.errors;

import java.time.LocalDateTime;

public record Product(String id, String name, int stock, LocalDateTime atExpired) {
    public Product(String id, String name, int stock) {
        this(id, name, stock, LocalDateTime.now());
    }
}
