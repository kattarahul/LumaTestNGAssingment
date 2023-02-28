package com.ml.testpackage;

import com.ml.base.BaseClass;
import com.ml.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestClass  extends BaseClass {



    LoginPage loginPage;
    MyAccountPage myAccountPage;
    BagsPage bagsPage;
    MyWishListPage wishListPage;
    SippingAddress sippingAddress;
    PaymentPages paymentPages;
    ThankYouPage thankYouPage;





    @BeforeClass
    public void initialization(){
        loginPage = new LoginPage(driver);
        myAccountPage= new MyAccountPage(driver);
        bagsPage = new BagsPage(driver);
        wishListPage = new MyWishListPage(driver);
        sippingAddress = new SippingAddress(driver);
        paymentPages = new PaymentPages(driver);
        thankYouPage =new ThankYouPage(driver);
    }


    @Test
    public void luma() throws InterruptedException, FileNotFoundException {


        /*
        Login with user Credentials...
         */
        loginPage.customerLogin("rahulkatta@gmail.com","Selenium@123");


        /*
        1.Moving to Gear button
        and choosing Bag option....

        2.Verifying cart is empty.
         */
        myAccountPage.moveToGear();

        /*
         Getting Max price Name of thr product....
         */
        bagsPage.getMaxPrice();
        bagsPage.getMaxPriceName();


        /*
        Adding to cart from Wishlist....
         */
        wishListPage.addProductToAndVerify();



        /*
        Verifying the Address from Json File and Address in PaymentPage...
         */
         Thread.sleep(5000);
        sippingAddress.DetailsWithJsonFile();
        System.out.println("The Address is displayed");
        System.out.println(paymentPages.verifyAddress().isDisplayed());


        /*
        Verifying price and date..
         */
        thankYouPage.verifyOrderNo();




    }

    @AfterTest
    public void closeBrowser( )
    {
        driver.quit();
    }

}
