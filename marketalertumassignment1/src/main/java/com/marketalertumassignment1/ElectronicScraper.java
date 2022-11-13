package com.marketalertumassignment1;

import com.marketalertumassignment1.Interfaces.CheckResultManager;
import com.marketalertumassignment1.Interfaces.CheckSearchManager;
import com.marketalertumassignment1.Interfaces.CheckLoadManager;
import com.marketalertumassignment1.managerutilities.MarketUmManager;

import java.io.IOException;
import java.net.MalformedURLException;

public class ElectronicScraper {

    protected CheckLoadManager checkLoadManager;
    protected CheckSearchManager checkSearchManager;
    protected CheckResultManager checkResultManager;
    protected MarketUmManager marketUmManager;
    protected int responseCode;


    public Boolean getSiteLoad() {
        if (checkLoadManager != null && !checkLoadManager.checkSiteTitle()) {
        return false;
        } else {
            return true;
        }
    }

    public Boolean getSearch() {
        if (checkSearchManager != null && !checkSearchManager.checkSearch()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean getResult() throws InterruptedException {
        if (checkResultManager != null && !checkResultManager.checkResult()) {
            return false;
        } else {
            return true;
        }
    }

    public int postRequest() throws IOException {
        if (marketUmManager != null) {
            responseCode = marketUmManager.postRequest("");
        }
        return responseCode;
    }

    public int deleteRequest() throws IOException {
        if (marketUmManager != null) {
            responseCode = marketUmManager.deleteRequest();
        }
        return responseCode;
    }

    public void setMarketUmManager(MarketUmManager marketUmManager){
        this.marketUmManager = marketUmManager;
    }

    //Injecting component using a setter method. Setter Injection
    public void setLoadManager(CheckLoadManager checkLoadManager) {
        this.checkLoadManager = checkLoadManager;
    }

    public void setSearchManager(CheckSearchManager checkSearchManager){
        this.checkSearchManager = checkSearchManager;
    }

    public void setResultManager(CheckResultManager checkResultManager) {
        this.checkResultManager = checkResultManager;
    }

}
