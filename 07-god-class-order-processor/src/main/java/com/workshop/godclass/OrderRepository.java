package com.workshop.godclass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class OrderRepository {

    public void saveFile(Order order, double total) {
        try {
            Path p = Paths.get("orders", order.id() + ".txt");
            Files.createDirectories(p.getParent());
            Files.writeString(p, order.id() + "," + total + "," + LocalDateTime.now());
        } catch (IOException e) {
            System.out.println("Could not save order " + order.id() + "," + total);
        }
    }
}
