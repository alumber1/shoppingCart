package com.hl.shoppingcart.selenium.test;

import org.junit.jupiter.api.AfterAll;

import com.hl.shoppingcart.selenium.util.DriverSingleton;

public abstract class BaseTest {
	
    @AfterAll
    static void tearDown() {
        DriverSingleton.quitDriver();
    }
}
