package com.ml.grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumGrid {

    WebDriver driver;
    DesiredCapabilities desiredCapabilities;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;





    @Parameters({"browserName"})
    @BeforeTest
    public void seleniumGrid( String browserName) throws MalformedURLException {

        switch(browserName.toLowerCase()) {
            case "chrome":
                // driver = new ChromeDriver();
                desiredCapabilities = new DesiredCapabilities();
                chromeOptions = new ChromeOptions();
                desiredCapabilities.setCapability("browser","chrome");
                desiredCapabilities.merge(chromeOptions);
                driver = new RemoteWebDriver(new URL("https://127.0,0.4444"),chromeOptions);
                // driver.manage().window().setSize(new Dimension(0,500));
                break;
            case "edge":
                //driver = new EdgeDriver();
                desiredCapabilities = new DesiredCapabilities();
                edgeOptions = new EdgeOptions();
                desiredCapabilities.setCapability("browser","MicrosoftEdge");
                desiredCapabilities.merge(edgeOptions);
                driver = new RemoteWebDriver(new URL("https://127.0,0.4444"),edgeOptions);
                break;
            default	:
                System.out.println("Browser name is invalid");
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/customer/account/");

    }
}
