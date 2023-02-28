package com.ml.pages;

import com.ml.seleniumactions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage {

    WebDriver driver ;

    SeleniumActions seleniumActions;

    public  ThankYouPage(WebDriver thankyoupagedriver)
    {
        this.driver = thankyoupagedriver;
        PageFactory.initElements(thankyoupagedriver,this);
        seleniumActions =new SeleniumActions(thankyoupagedriver);
    }

    @FindBy(xpath = "//a[@class='order-number']")
    WebElement orderNO;

    @FindBy(xpath = "//div[@class='order-date']/span/following-sibling::span")
    WebElement dateElement;



    public void verifyOrderNo()
    {

        seleniumActions.toClickTheElement(orderNO);

        WebElement priceInMyOrder = driver.findElement(By.xpath("//table[@summary='Items Ordered']/thead/following-sibling::tbody/tr/td[3]"));
        String price = priceInMyOrder.getText();
        System.out.println(price);
    }


}
