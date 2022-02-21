package ru.netology.service;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CashbackHackServiceTest {
    CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldBelowLimit() {
        int amount = 950;

        int actual = service.remain(amount);
        int expected = 50;

        assertEquals(actual, expected);
    }

    @Test
    public void shouldLimit() {
        int amount = 1_000;

        int actual = service.remain(amount);
        int expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void shouldMarginalBellowLimit() {
        int amount = 999;

        int actual = service.remain(amount);
        int expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    public void shouldMarginalAboveLimit() {
        int amount = 1001;

        int actual = service.remain(amount);
        int expected = 999;

        assertEquals(actual, expected);
    }

    @Test
    public void shouldAboveLimit() {
        int amount = 1_720;

        int actual = service.remain(amount);
        int expected = 280;

        assertEquals(actual, expected);
    }

}