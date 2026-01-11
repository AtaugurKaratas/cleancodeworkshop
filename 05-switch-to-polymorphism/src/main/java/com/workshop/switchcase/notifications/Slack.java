package com.workshop.switchcase.notifications;

import com.workshop.switchcase.Notifier;

public class Slack implements Notifier {
    @Override
    public String send(String to, String message) {
        return "SLACK to %s: %s".formatted(to, message);
    }
}
