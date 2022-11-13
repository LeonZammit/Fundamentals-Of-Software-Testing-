package com.marketalertumassignment1;

import com.marketalertumassignment1.managerutilities.MarketUmManager;
import com.marketalertumassignment1.spies.MarketUmManagerSpy;
import com.marketalertumassignment1.stubs.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class TestScraper {

    @Test
    public void testThatSiteLoads() {

        //Setup
        ElectronicScraper scraper = new ElectronicScraper();
        scraper.setLoadManager(new SiteLoaded()); //Will always return true
        //Exercise
        Boolean title = scraper.getSiteLoad();
        //Verify
        Assertions.assertTrue(title);
    }

    @Test
    public void testThatSiteDoesNotLoad(){
        //Setup
        ElectronicScraper scraper = new ElectronicScraper();
        scraper.setLoadManager((new SiteNotLoaded())); //Will always return false
        //Exercise
        Boolean title = scraper.getSiteLoad();
        //Verify
        Assertions.assertFalse(title);
    }

    @Test
    public void testThatSearchIsWorking() {

        //Setup
        ElectronicScraper scraper = new ElectronicScraper();
        scraper.setSearchManager((new SearchIsWorking()));
        //Exercise
        Boolean anySearch = scraper.getSearch();
        //Verify
        Assertions.assertTrue(anySearch);
    }

    @Test
    public void testThatSearchIsNotWorking() {

        //Setup
        ElectronicScraper scraper = new ElectronicScraper();
        scraper.setSearchManager((new SearchIsNotWorking()));
        //Exercise
        Boolean anySearch = scraper.getSearch();
        //Verify
        Assertions.assertFalse(anySearch);
    }

    @Test
    public void testThatResultIsFound() throws InterruptedException {

        //Setup
        ElectronicScraper scraper = new ElectronicScraper();
        scraper.setResultManager ((new ResultIsFound()));
        //Exercise
        Boolean resultFound = scraper.getResult();
        //Verify
        Assertions.assertTrue(resultFound);
    }

    @Test
    public void testThatResultIsNotFound() throws InterruptedException {

        //Setup
        ElectronicScraper scraper = new ElectronicScraper();
        scraper.setResultManager((new ResultIsNotFound()));
        //Exercise
        Boolean resultNotFound  = scraper.getResult();
        //Verify
        Assertions.assertFalse(resultNotFound);

    }

    @Test
    public void testThePostRequest() throws IOException {

        //Setup
        MarketUmManagerSpy marketUmManager = new MarketUmManagerSpy(); //Creating spy
        ElectronicScraper scraper = new ElectronicScraper(); //Creating scraper
        scraper.setMarketUmManager(marketUmManager); //Telling the scraper to use this spy.
        //Exercise
        int postReceived = scraper.postRequest();
        //Verify
        Assertions.assertEquals(1,postReceived);
    }

    @Test
    public void testTheDeleteRequest() throws IOException {

        //Setup
        MarketUmManagerSpy marketUmManager = new MarketUmManagerSpy();
        ElectronicScraper scraper = new ElectronicScraper();
        scraper.setMarketUmManager(marketUmManager);
        //Exercise
        int deleteReceived = scraper.deleteRequest();
        //Verify
        Assertions.assertEquals(1, deleteReceived);
    }
}
