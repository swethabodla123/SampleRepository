package org.training.examples.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.training.examples.automation.base.TestBase;
import org.training.examples.automation.common.Generic;

import java.util.List;

public class HomePage  {

    public WebDriver driver;
    HomePageObjects homePageObjects;
    Generic generic;

    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        generic = new Generic();
        this.driver = driver;
        homePageObjects = new HomePageObjects();
        PageFactory.initElements(this.driver,homePageObjects);
    }

    public void clickDelivary()
    {
        homePageObjects.storeDeatilsList.get(1).click();
    }

    public void clickShopDelivery()
    {
        homePageObjects.btnShopDelivery.click();
    }

    public void clickChangeLink()
    {
        homePageObjects.btnChange.click();
    }

    public Boolean validateTextInChangePopup(String text)
    {
        if(homePageObjects.textChangePopUp.getText().equalsIgnoreCase(text))
            return true;
        else
            return false;
    }

    public void searchZipCode(String zipcode)
    {
        homePageObjects.txtSearchZip.sendKeys(zipcode);
        homePageObjects.btnSearch.click();
    }

   public boolean validateStoreDetails(String[] details)
   {     boolean flag = false;
       for(int i=0;i<homePageObjects.storeDeatilsList.size();i++)
       {

           if(homePageObjects.storeDeatilsList.get(i).getText().equalsIgnoreCase(details[i]))
           {
               flag=true;
           }
       }
       if(flag == true)
           return true;
       else
           return false;
   }

   public  boolean verifyDeliveryAndZipcode(String delivery, String zipcode)
   {
       if(homePageObjects.textDelivery.getText().equalsIgnoreCase(delivery) &&
               homePageObjects.textzipcode.getText().equalsIgnoreCase(zipcode))
           return true;
       else
           return false;
   }




    /*
     ###################################################################################
     ######################                                      #######################
     ######################    Home Page - WebElements           #######################
     ######################                                      #######################
     ###################################################################################
 */
    public class HomePageObjects
    {
        @FindBy(id = "openFulfillmentModalButton")
        @CacheLookup
        private WebElement btnChange;


        @FindBy(xpath = "//div[@class='fulfillment-content__heading-wrapper']")
        @CacheLookup
        private WebElement textChangePopUp;

        @FindBy(xpath = "//div[@class='fulfillment-content__search-wrapper']//input")
        @CacheLookup
        private WebElement txtSearchZip;

        @FindBy(xpath = "//div[@class='fulfillment-content__search-wrapper']//span")
        @CacheLookup
        private WebElement btnSearch;

        @FindBy(className = "modal-tab-delivery nav-link active")
        @CacheLookup
        private WebElement btnDelivery;

        @FindBy(xpath = "//div[@class='delivery-content  card-wrapper']//button")
        @CacheLookup
        private WebElement btnShopDelivery;

        @FindBy(xpath = "//ul[@class='nav nav-tabs tabs-wrapper__tabs-header']//li")
        @CacheLookup
        private List<WebElement> storeDeatilsList;

        @FindBy(className = "reserve-nav__text-for-delivery-edit")
        @CacheLookup
        private WebElement textDelivery;

        @FindBy(className = "reserve-nav__current-zipcode")
        @CacheLookup
        private WebElement textzipcode;

    }


}
