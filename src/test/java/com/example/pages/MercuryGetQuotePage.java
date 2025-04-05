package com.example.pages;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;

import java.time.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.testng.Assert.assertTrue;

public class MercuryGetQuotePage extends AbstractBasePage<MercuryGetQuotePage>{

    private static final String tempURL="https://buy.mercuryinsurance.com/auto/create?zip=94530&state=CA";
    private static final String URL = "https://buy.mercuryinsurance.com/auto/aboutYou";

    public MercuryGetQuotePage(WebDriver driver) {
        super(driver, "search-results.properties");
    }
    @Override
    protected void isLoaded() throws Error {
        driver.get(tempURL);
        //super.isLoaded();
        String expectedTitle= "Mercury Insurance | About You";
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.titleContains(expectedTitle));
        String actualTitle= driver.getTitle();
        assertTrue(expectedTitle.equals(actualTitle));
    }

    @Step
    public MercuryGetQuotePage fillOutForm() {
        LOG.info("Get Auto Quote page:entering first name");
        driver.findElement(getLocator("quote_page_first_name.id")).sendKeys("FirsName Test");
        driver.findElement(getLocator("quote_page_last_name.id")).sendKeys("LastName Test");
        driver.findElement(getLocator("quote_page_birth.id")).sendKeys("09/01/2010");
        driver.findElement(getLocator("quote_page_phone.id")).sendKeys("9255554433t");
        driver.findElement(getLocator("quote_page_email.id")).sendKeys("testemail@gmail.com");
        driver.findElement(getLocator("quote_page_address1.id")).sendKeys("120 montgomerry st");
        driver.findElement(getLocator("quote_page_address2.id")).sendKeys("");

        driver.findElement(getLocator("quote_page_address_city.id")).sendKeys("t");
        driver.findElement(getLocator("quote_page_address_state.id")).sendKeys("");
        driver.findElement(getLocator("quote_page_address_zip.id")).sendKeys("t");

        return this;
    }
}
