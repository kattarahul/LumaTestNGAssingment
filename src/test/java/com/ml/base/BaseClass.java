package com.ml.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {

    public WebDriver driver;
    DesiredCapabilities desiredCapabilities;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;



   @BeforeSuite
    public void openBrowser()
   {
       driver = new EdgeDriver();
       driver.get("https://magento.softwaretestingboard.com/customer/account/");
       driver.manage().window().maximize();
   }


}
