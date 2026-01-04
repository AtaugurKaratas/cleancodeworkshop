package com.workshop.switchcase;

import com.workshop.switchcase.notifications.*;

import java.util.Map;

public class NotificationService {

    private final Map<String, Notifier> notifiers;
    private static final String UNKNOWN = "UNKNOWN";

    public NotificationService() {
        notifiers = Map.of(
                "email", new Email(),
                "sms", new Sms(),
                "push", new Push(),
                "slack", new Slack(),
                "WhatsApp", new WhatsApp()
        );
    }

    public String send(String type, String to, String msg) {
        Notifier notifier = notifiers.get(type);
        if (notifier != null) {
            return notifier.send(to, msg);
        }
        return UNKNOWN;
    }
}
