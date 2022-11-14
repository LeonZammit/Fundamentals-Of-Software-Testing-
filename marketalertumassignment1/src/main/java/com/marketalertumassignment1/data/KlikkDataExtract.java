package com.marketalertumassignment1.data;

import com.marketalertumassignment1.*;
import com.marketalertumassignment1.pageobjects.KlikkResultPageObject;
import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class KlikkDataExtract {

    public static WebDriver SetupDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/leonz/webtesting/chromedriver.exe");
        return new ChromeDriver();
    }

    public static List<Item> GetItems(int count) throws InterruptedException {

        ElectronicScraper scraper = new ElectronicScraper();

        //Setting the system property to a value.
        WebDriver driver = SetupDriver();

        KlikkResultPageObject extract = new KlikkResultPageObject(driver);

        SiteLoader load = new SiteLoader(driver);
        scraper.setLoadManager(load);
        scraper.getSiteLoad();

        SiteSearch search = new SiteSearch(driver);
        scraper.setSearchManager(search);
        scraper.getSearch();

        SiteResult result = new SiteResult(driver);
        scraper.setResultManager(result);
        return extract.getResult(count);
    }

}
