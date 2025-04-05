package com.example.test;

import com.example.*;
import com.example.pages.*;
import com.example.webdriver.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

import java.time.*;

public class TestMercuryHome extends BaseTest {
    @Test
    public void testMercuryHome() {
        MercuryHomePage homePage = new MercuryHomePage(DriverManager.getWebDriver()).get();
        homePage.testHomePage();
    }


    //@Test
    public void testMercuryGetQuotePage() {
        // MercuryGetQuotePage quote = new MercuryGetQuotePage(DriverManager.getWebDriver()).get();
        // search.search("educative");
        // Assert.fail("failing the test to take screenshot");
    }
}
