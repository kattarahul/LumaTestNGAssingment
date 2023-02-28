package com.ml.seleniumwaits;

import com.ml.constants.WaitClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {

    WebDriver driver;
    WaitClass waitClass;
    WebDriverWait wait;

    public SeleniumWaits(WebDriver seleniumwaitdriver)
    {
        waitClass = new WaitClass();
        wait = new WebDriverWait(seleniumwaitdriver, Duration.ofSeconds(waitClass.waitForSeconds));


    }

    public WebElement waitForElementToClick(WebElement element)
    {

         WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
         return element1;

    }




}
