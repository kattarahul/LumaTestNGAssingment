package com.ml.pages;

import com.ml.seleniumactions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyWishListPage {



    WebDriver driver;
    SeleniumActions seleniumActions;


    public MyWishListPage(WebDriver wishlistpagedriver)
    {
        this.driver = wishlistpagedriver;
        PageFactory.initElements(wishlistpagedriver,this);
        seleniumActions =new SeleniumActions(wishlistpagedriver);

    }




    @FindBy(xpath = "//li[@data-row='product-item']")
    WebElement moveToImg;

    @FindBy(xpath = "//fieldset[@class='fieldset']/div/following-sibling::div/div/button[@title='Add to Cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(text(),'You have no items in your wish list.')]")
    WebElement emptyMessage;


    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement cartIconButton;


    @FindBy(xpath = "//div[@class='primary']/button[text()='Proceed to Checkout']")
    WebElement proceedToCheckoutButton;



    public void addProductToAndVerify() throws InterruptedException {
        seleniumActions.moveElementUsingAction(moveToImg);
        seleniumActions.moveElementUsingAction(addToCartButton);
        seleniumActions.toClickTheElement(addToCartButton);

/*
           Getting Text from Web Element and Asserting
 */
        String ExceptedMessage = emptyMessage.getText();
         emptyMessage.isDisplayed();
        String ActualMessage ="You have no items in your wish list.";
        Assert.assertEquals(ExceptedMessage,ActualMessage);
        System.out.println("WishList shows the message : "+ ExceptedMessage +"---and  the Actual --" + ActualMessage);

          Thread.sleep(3000);

          /*
          After Getting text and moving to Checkout Page....
           */

          seleniumActions.WaitandClickElement(cartIconButton);
          seleniumActions.WaitandClickElement(proceedToCheckoutButton);




    }


}
