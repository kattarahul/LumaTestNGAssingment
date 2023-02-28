package com.ml.seleniumactions;

import com.ml.seleniumwaits.SeleniumWaits;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumActions {

    WebDriver driver;
    SeleniumWaits seleniumWaits;

    public SeleniumActions(WebDriver seleniumactionsdriver)
    {
        this.driver =seleniumactionsdriver;
        PageFactory.initElements(seleniumactionsdriver,this);
        seleniumWaits= new SeleniumWaits(seleniumactionsdriver);


    }


    public boolean moveElementUsingAction(WebElement element)
    {
        Actions act = new Actions(driver);
            boolean flag = false;

            try{
                act.moveToElement(element).build().perform();
//                act.click().build().perform();

                flag =true;
            }
            catch (NoSuchElementException nse)
            {
                 flag =false;

            }
            catch (StaleElementReferenceException ste )
            {
                  flag= false;

            }
            catch (ElementNotInteractableException eni)
            {
                 flag=false;
            }
            return flag;
        }





    public  boolean enterTheInputTextField(WebElement element,String key)
    {
        boolean flag = false;

        try{

            element.sendKeys(key);
            flag =true;
        }
        catch (NoSuchElementException nse)
        {
           flag =false;

        }
        catch (StaleElementReferenceException ste )
        {
              flag= false;

        }
        return flag;
    }




    public  boolean toClickTheElement(WebElement element)
    {
        boolean flag = false;

        try{

            element.click();
           flag =true;
        }
        catch (NoSuchElementException nse)
        {
            flag =false;

        }
        catch (StaleElementReferenceException ste )
        {
             flag= false;

        }
        return flag;

    }



    public boolean WaitandClickElement(WebElement element) {
        boolean flag = false;
        try {
            seleniumWaits.waitForElementToClick(element).click();
             flag= true;
        }
        catch (NoSuchElementException nse)
        {
            flag =false;

        }
        catch (StaleElementReferenceException ste )
        {
           flag= false;

        }
        return flag;

    }



    public boolean selectValueFromDropDown(WebElement element, String data, String typeSelect) {
        try {
            Select select = new Select(element);
            switch (typeSelect) {
                case "index":
                    select.selectByIndex(Integer.parseInt(data));
                    break;
                case "value":
                    select.selectByValue(data);
                    break;
                case "text":
                    select.selectByVisibleText(data);
                    break;
            }
            return true;
        } catch (Exception e) {

            return false;
        }
    }
    public void javaScriptExcecutorClick(WebElement element, WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("argument[0].click();", element);
    }



}
