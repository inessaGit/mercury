package com.example.test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.slf4j.*;
import org.testng.annotations.*;

import java.time.*;

public class MercuryHome {
    private static final Logger LOG = LoggerFactory.getLogger(MercuryHome.class);

    @Test
    public void testHomePage(){
        WebDriver driver = new FirefoxDriver();
        String url = "https://www.mercuryinsurance.com/";
        driver.get(url);
        WebElement zipCodeInput = driver.findElement(By.id("gaq-zip-code"));
        zipCodeInput.sendKeys("94530");

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select-selected']")));
        driver.findElement(By.xpath("//div[@class='select-selected']")).click();

        driver.quit();
    }
    @Test
    public  void logMessages(){
        LOG.trace("log trace");
        LOG.warn("log warn");
        LOG.info("log info");
        LOG.debug("log debug");
        LOG.error("log error");
    }
}
