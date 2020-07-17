package com.JUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank bank = new Bank(10, BankType.LHV);
    @BeforeEach
    void setUp() {
        bank.deposit(20);
    }

    @Test
    void getBalance() {
        assertEquals(30, bank.getBalance());
        System.out.println("GetBalance passed");
    }

    @Test
    void getBank() {
        assertEquals(BankType.LHV, bank.getBank());
        System.out.println("Getbank passed");
    }

    @Test
    void maxValue() {
        assertEquals(10, bank.maxValue(10, 5));
        System.out.println("MaxValue passed");
    }

    @Test
    void equalObjects() {
        Bank bank2 = new Bank(10, BankType.LHV);
        bank2.deposit(20);
        assertEquals(bank, bank2);
        System.out.println("EqualObjects passed");
    }
}