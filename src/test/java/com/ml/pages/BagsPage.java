package com.ml.pages;

import com.ml.seleniumactions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BagsPage {


    WebDriver driver;
    SeleniumActions seleniumActions;

    public Double maxPrice;


    public BagsPage(WebDriver bagspagedriver) {
        this.driver = bagspagedriver;
        PageFactory.initElements(bagspagedriver, this);
        seleniumActions = new SeleniumActions(bagspagedriver);

    }





    /*

    Method: use to find MaxPrice.
    After That Name Of MaxPrice
    Adding to Wishlist that Product.

     */
    public  void getMaxPrice() {

        // storing all the prices in list..

        List<WebElement> listofprice = driver.findElements(By.xpath("//span[@data-price-type='finalPrice']/span[@class='price']"));
        ArrayList<Double> prices = new ArrayList<>();

        for (int i = 0; i < listofprice.size(); i++) {
            String allprices = listofprice.get(i).getText();
            String removedollar = allprices.replace("$", "");
            Double priceValue = Double.parseDouble(removedollar);
            prices.add(priceValue);
        }

 //       sorting the list and finding the max price....
        System.out.println("Prices " + prices);
        maxPrice = Collections.max(prices);
        System.out.println("max price is : " + maxPrice);


    }


    public void getMaxPriceName()
    {

//        Finding the Name Of Maximum Price

        WebElement maxPriceName = driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'"+maxPrice+"')]/parent::span/parent::span/parent::div/preceding-sibling::div/preceding-sibling::strong/a"));
        String PriceName = maxPriceName.getText();
        System.out.println(PriceName);
        seleniumActions.moveElementUsingAction(maxPriceName);




//        Adding to WishList to Product

        WebElement addToWishListButton = driver.findElement(By.xpath("//span[contains(text(),'"+maxPrice+"')]/../../../following-sibling::div/div/div[contains(@data-role,'add-to-links')]/a[@data-action='add-to-wishlist']"));
        seleniumActions.moveElementUsingAction(addToWishListButton);
        seleniumActions.toClickTheElement(addToWishListButton);







    }

}
