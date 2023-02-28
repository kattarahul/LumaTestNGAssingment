package com.ml.pages;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ml.seleniumactions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;

public class SippingAddress {

    WebDriver driver;
    JsonObject jsonObject;

    SeleniumActions seleniumActions;

    public SippingAddress(WebDriver sippingaddressdriver)
    {
        this.driver=sippingaddressdriver;
        PageFactory.initElements(sippingaddressdriver,this);
        seleniumActions = new SeleniumActions(sippingaddressdriver);

    }

    @FindBy(xpath = "//button[@type='button']/span[contains(text(),'New Address')]")
    WebElement newaddressbutton;


    @FindBy(xpath = "//form/div/table/thead/following-sibling::tbody/tr/td/following-sibling::td/following-sibling::td[(text()='Fixed')]")
    WebElement radiobutton;


    @FindBy(xpath = "//input[@name='company']")
    WebElement companyelement;

    @FindBy(xpath = "//legend[@class='label']/following-sibling::div/div/label/following-sibling::div/input[@name='street[0]']")
    WebElement streetaddress;

    @FindBy(xpath = "//input[@name='city']")
    WebElement city;

    @FindBy(xpath = "//input[@name='postcode']")
    WebElement postalocdeElement;

    @FindBy(xpath = "//input[@name='telephone']")
    WebElement phoneNO;



    @FindBy(xpath = "//button[@type='submit']/span[text()='Next']")
    WebElement nextbuttonElement;







    public  void   DetailsWithJsonFile() throws FileNotFoundException, InterruptedException {

        JsonParser jsonParser= new JsonParser();
        FileReader fileReader = new FileReader(System.getProperty("user.dir")+"/testdata/ShippingAddress.json");
        Object obj =jsonParser.parse(fileReader);
        jsonObject = (JsonObject)obj;


        String company = jsonObject.get("Company").getAsString().toString();
        String streetaddress = String.valueOf(jsonObject.get("StreetAddress").getAsString());
        String cityStr = String.valueOf(jsonObject.get("City").getAsString());
        String postalCode = String.valueOf(jsonObject.get("Zip/Postal").getAsString());
        String phonenumber= String.valueOf(jsonObject.get("PhoneNo").getAsString());


        Thread.sleep(30000);

        seleniumActions.enterTheInputTextField(companyelement,company);
        seleniumActions.enterTheInputTextField(city,cityStr);
        seleniumActions.enterTheInputTextField(postalocdeElement,postalCode);
        seleniumActions.enterTheInputTextField(phoneNO,phonenumber);

        seleniumActions.toClickTheElement(radiobutton);
        seleniumActions.toClickTheElement(nextbuttonElement);



    }


}
