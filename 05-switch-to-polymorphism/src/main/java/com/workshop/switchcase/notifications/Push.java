package com.workshop.switchcase.notifications;

import com.workshop.switchcase.Notifier;

public class Push implements Notifier {
    @Override
    public String send(String to, String message) {
        return "PUSH to %s: %s".formatted(to, message);
    }
}
