package com.example.pages;

import com.example.webdriver.*;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.*;

public class MercuryHomePage extends AbstractBasePage<MercuryHomePage>{
    private static final String URL = "https://www.mercuryinsurance.com/";

    public MercuryHomePage(WebDriver driver) {
        super(driver, "search-home.properties");
    }

    @Override
    protected void isLoaded() throws Error {
        driver.get(URL);
        super.isLoaded();
    }

    @Step
    public void testHomePage() {
        WebElement zipCodeInput = driver.findElement(getLocator("zip_field.id"));
        zipCodeInput.sendKeys("94530");
        driver.findElement(getLocator("get_quote_button.id")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("create?zip=94530&state=CA"));
        wait.until(ExpectedConditions.urlContains("/auto/aboutYou"));
    }
}
