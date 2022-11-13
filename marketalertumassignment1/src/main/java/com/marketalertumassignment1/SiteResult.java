package com.marketalertumassignment1;

import com.marketalertumassignment1.Interfaces.CheckResultManager;
import com.marketalertumassignment1.pageobjects.KlikkResultPageObject;
import org.openqa.selenium.WebDriver;

public class SiteResult implements CheckResultManager {

    WebDriver Driver;
    KlikkResultPageObject result;
    public SiteResult(WebDriver driver) {
        Driver = driver;
        result = new KlikkResultPageObject(Driver);
    }

    //Returns true if the result is greater than 0. Should be the case as we are extracting the first 5 items, else false.
    @Override
    public Boolean checkResult() throws InterruptedException {
       if(result.getResult(5).size() > 0){
            return true;
       } else {
           return false;
       }
    }
}
