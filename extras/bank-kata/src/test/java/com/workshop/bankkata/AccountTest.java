package com.workshop.bankkata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    @Test
    void deposit_and_withdraw_prints_statement() {
        Account a = new Account();
        a.deposit(100);
        a.withdraw(50);
        assertDoesNotThrow(() -> a.printStatement());
    }
}
