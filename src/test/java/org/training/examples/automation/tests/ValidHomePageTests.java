package org.training.examples.automation.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.training.examples.automation.base.TestBase;
import org.training.examples.automation.pages.HomePage;

public class ValidHomePageTests extends TestBase {


    HomePage homePage;

    @BeforeMethod
    public void init()
    {
        homePage = new HomePage(getDriver());
    }

    @Test
    public void changeClick()
    {
        //click on change
        homePage.clickChangeLink();
        //Validate storeModelPopUp
        Assert.assertTrue(homePage.validateTextInChangePopup("Find a Store near you, or shop for Delivery or Pickup."));
        //search zipcode
        String zipcode = "94568";
        homePage.searchZipCode(zipcode);
        //validate store details
        String[] details = {"In Store","Delivery","Pickup"};
        Assert.assertTrue(homePage.validateStoreDetails(details));
        //click delivery and shopdelivery
        homePage.clickDelivary();
        homePage.clickShopDelivery();
        //verify delivery and zipcode
        Assert.assertTrue(homePage.verifyDeliveryAndZipcode("Delivery at",zipcode));

       }


}
