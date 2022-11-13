package com.marketalertumassignment1;

import com.marketalertumassignment1.Interfaces.CheckLoadManager;
import com.marketalertumassignment1.pageobjects.KlikkStartPageObject;
import org.openqa.selenium.WebDriver;

public class SiteLoader implements CheckLoadManager {

    WebDriver Driver;
    KlikkStartPageObject startPage;

    public SiteLoader(WebDriver driver) {
        Driver = driver;
        startPage = new KlikkStartPageObject(Driver);
    }

    //checking the site title of the start page. If it matches, it will return true, else false.
    @Override
    public Boolean checkSiteTitle() {
        if(startPage.getSiteTitle().equals("Klikk Computers Store Malta")) {
            return true;
        } else {
            return false;
        }
    }
}
