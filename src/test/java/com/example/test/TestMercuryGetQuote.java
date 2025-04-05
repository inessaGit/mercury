package com.example.test;

import com.example.*;
import com.example.pages.*;
import com.example.webdriver.*;
import com.fasterxml.jackson.databind.ser.*;
import org.testng.annotations.*;

public class TestMercuryGetQuote extends BaseTest {

    @Test
    public void testMercuryGetQuote() {
        MercuryGetQuotePage quotePage = new MercuryGetQuotePage(DriverManager.getWebDriver()).get();
        quotePage.fillOutForm();
    }
}
