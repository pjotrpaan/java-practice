package com.company.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getName() {
        Hammer hammer = new Hammer();
        assertEquals("Hammer", hammer.getName());
        Sword sword = new Sword();
        assertEquals("Sword", sword.getName());
        Boot boot = new Boot();
        assertEquals("Boot", boot.getName());
        Teleporter teleporter = new Teleporter();
        assertEquals("Teleporter", teleporter.getName());
    }

    @Test
    void getEndurance() {
    }

    @Test
    void setEndurance() {
    }

    @Test
    void getStrength() {
    }
}