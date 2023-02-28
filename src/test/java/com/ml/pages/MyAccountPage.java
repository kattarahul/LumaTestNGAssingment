package com.ml.pages;

import com.ml.seleniumactions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountPage {

    WebDriver driver;
    SeleniumActions seleniumActions;

    public  MyAccountPage(WebDriver myaccdriver)
    {
        this.driver = myaccdriver;
        PageFactory.initElements(myaccdriver,this);
        seleniumActions = new SeleniumActions(myaccdriver);

    }


    @FindBy(xpath = "//span[text()='Gear']")
    WebElement  gearButton;

    @FindBy(xpath = "//span[text()='Gear']/parent::a/following-sibling::ul/li/a/span[text()='Bags']")
    WebElement bagsButton;

    @FindBy(xpath = "//div[@data-block='minicart']")
    WebElement cartIconButton;

//    @FindBy(xpath = "//div[@data-block='minicart']/a/following-sibling::div/div/div/div/following-sibling::div/button/following-sibling::strong[contains(text(),'You have no items in your shopping cart.')]")
//   public WebElement cartMessage;

    @FindBy(xpath = "//strong[contains(text(),'You have no items in your shopping cart.')]")
    WebElement cartMessage;




    public void moveToGear()
    {
        seleniumActions.moveElementUsingAction(gearButton);
        seleniumActions.moveElementUsingAction(bagsButton);
        seleniumActions.toClickTheElement(bagsButton);
        seleniumActions.toClickTheElement(cartIconButton);
       String message = cartMessage.getText();
        cartMessage.isDisplayed();
        String actualMessage = "You have no items in your shopping cart.";
        Assert.assertEquals(actualMessage,message);
        System.out.println("Verified: Expected is --"+message + " and actual is --"+actualMessage);


    }

}
