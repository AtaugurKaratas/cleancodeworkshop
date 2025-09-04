package com.workshop.switchcase;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {
    @Test void email(){ assertTrue(new NotificationService().send("email","a@x","hi").startsWith("EMAIL")); }
    @Test void slack(){ assertTrue(new NotificationService().send("slack","devs","hi").startsWith("SLACK")); }
    @Test void unknown(){ assertEquals("UNKNOWN", new NotificationService().send("fax","x","hi")); }
}
