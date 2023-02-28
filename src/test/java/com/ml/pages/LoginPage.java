package com.ml.pages;

import com.ml.seleniumactions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    SeleniumActions seleniumActions;
    public LoginPage(WebDriver loginpagedriver)
    {
        this.driver = loginpagedriver;
        PageFactory.initElements(loginpagedriver,this);
        seleniumActions = new SeleniumActions(loginpagedriver);

    }


    @FindBy(css = "input#email")
    WebElement email;

    @FindBy(css = "input[title='Password']")
    WebElement password;

    @FindBy(xpath = "//fieldset[contains(@class,'fieldset login')]/div/following-sibling::div/following-sibling::div/following-sibling::div/div[@class='primary']/button/span")
    WebElement signButton;





    public void customerLogin( String Email ,String Password )
    {

        seleniumActions.enterTheInputTextField(email,Email);
        seleniumActions.enterTheInputTextField(password,Password);
        seleniumActions.toClickTheElement(signButton);


    }




}
