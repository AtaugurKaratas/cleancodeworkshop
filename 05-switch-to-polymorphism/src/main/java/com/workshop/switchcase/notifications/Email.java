package com.workshop.switchcase.notifications;

import com.workshop.switchcase.Notifier;

public class Email implements Notifier {
    @Override
    public String send(String to, String message) {
        return "EMAIL to %s: %s".formatted(to, message);
    }
}
