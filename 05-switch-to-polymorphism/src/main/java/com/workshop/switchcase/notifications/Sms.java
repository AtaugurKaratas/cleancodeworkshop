package com.workshop.switchcase.notifications;

import com.workshop.switchcase.Notifier;

public class Sms implements Notifier {
    @Override
    public String send(String to, String message) {
        return "SMS to %s: %s".formatted(to, message);
    }
}
