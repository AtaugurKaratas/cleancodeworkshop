package com.workshop.switchcase.notifications;

import com.workshop.switchcase.Notifier;

public class WhatsApp implements Notifier {
    @Override
    public String send(String to, String message) {
        return "WhatsApp to %s: %s".formatted(to, message);
    }
}
