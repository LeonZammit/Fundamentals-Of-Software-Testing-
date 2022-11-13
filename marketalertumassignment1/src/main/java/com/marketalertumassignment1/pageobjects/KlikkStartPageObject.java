package com.marketalertumassignment1.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KlikkStartPageObject {

    WebDriver driver;

    public KlikkStartPageObject(WebDriver driver) {
        this.driver = driver;
        //Launches the given url
        driver.get("https://www.klikk.com.mt/");
        //Maximises the window after loading the url given
        driver.manage().window().maximize();
    }

    public String getSiteTitle() {
        getSearch();
        return driver.getTitle();
    }

    public void getSearch() {

        //Identifying the search box of klikk by using a web locator i.e., id.
        WebElement searchField = driver.findElement(By.id("header-search-text"));
        //Types "Laptops" automatically by using the sendkeys() method.
        searchField.sendKeys("Laptops");
        //Helps us to interact with the search button to search for Laptops
        WebElement searchButton = driver.findElement(By.className("header-search-submit"));
        searchButton.click();
    }
}
