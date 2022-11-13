package com.marketalertumassignment1;

import com.marketalertumassignment1.Interfaces.CheckSearchManager;
import com.marketalertumassignment1.pageobjects.KlikkResultPageObject;
import com.marketalertumassignment1.pageobjects.KlikkStartPageObject;
import org.openqa.selenium.WebDriver;

public class SiteSearch implements CheckSearchManager {

    WebDriver Driver;
    //constructor injection
    public SiteSearch(WebDriver driver) {
        this.Driver = driver;
    }

    //Returns true after the content in the search box is automatically typed and matches with the title of the page, else false.
    @Override
    public Boolean checkSearch() {
        if(Driver.getTitle().equals("Klikk Computers Store Malta - Search results for laptop")) {
            return true;
        }else{
            return false;
        }
    }
}
