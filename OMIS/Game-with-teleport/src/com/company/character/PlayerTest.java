package com.company.character;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {



    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Player Player = new Player("Tester", CharacterType.WIZARD);
    }

    @org.junit.jupiter.api.Test
    void takeHealth() {
        System.out.println("Testing take 1 from player health via takeHealth().");
        com.company.character.Player.takeHealth();
        assertEquals(2, com.company.character.Player.getHealth());
    }

    @org.junit.jupiter.api.Test
    void getHealth() {
        System.out.println("Testing retrieval of player health via getHealth().");
        assertEquals(3, com.company.character.Player.getHealth());
    }

    @org.junit.jupiter.api.Test
    void setHealth() {
        System.out.println("Testing set player health to 100 via setHealth().");
        com.company.character.Player.setHealth(100);
        assertEquals(100, com.company.character.Player.getHealth());
    }

    @org.junit.jupiter.api.Test
    void setFullHealth() {
        System.out.println("Testing set player health to 10 via setFullHealth().");
        com.company.character.Player.setFullHealth();
        assertEquals(10, com.company.character.Player.getHealth());
    }
}