package com.ml.pages;

import com.ml.seleniumactions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPages {


    WebDriver driver ;
    SeleniumActions seleniumActions;

    public PaymentPages(WebDriver paymentdriver)
    {
        this.driver = paymentdriver;
        PageFactory.initElements(paymentdriver,this);
        seleniumActions =new SeleniumActions(paymentdriver);


    }
    @FindBy(xpath = "//div[contains(@class,'billing-address-details')]")
    WebElement addressfetch;

    @FindBy(xpath = "//span[text()='Place Order']")
    WebElement placeOrderName;


    public WebElement verifyAddress()
    {
        seleniumActions.toClickTheElement(placeOrderName);
        return addressfetch;

    }


}

