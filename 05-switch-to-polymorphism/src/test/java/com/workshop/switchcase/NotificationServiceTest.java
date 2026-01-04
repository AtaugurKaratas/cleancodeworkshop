package com.workshop.switchcase;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {
    @ParameterizedTest
    @CsvSource({
            "email,google@gmail.com,hello,EMAIL to google@gmail.com: hello",
            "sms,+905405409090,hello,SMS to +905405409090: hello",
            "push,macbook-1,hello,PUSH to macbook-1: hello",
            "slack,developers,hello,SLACK to developers: hello",
            "WhatsApp,+905405409090,hello,WhatsApp to +905405409090: hello",
            "fax,x,hello,UNKNOWN"
    })
    void shouldVerifySending(String type, String to, String msg, String expected) {
        assertEquals(expected, new NotificationService().send(type, to, msg));
    }
}
