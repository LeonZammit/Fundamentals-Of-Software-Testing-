package com.marketalertumassignment1.spies;

import com.marketalertumassignment1.managerutilities.MarketUmManager;

public class MarketUmManagerSpy implements MarketUmManager {

    private int numCallsPostRequest = 0;
    private int numCallsDeleteRequest = 0;

    //if the method is called, numCallsPostRequest gets incremented.
    //To check if the methods are called.
    @Override
    public int postRequest(String itemInputString) {
        return ++numCallsPostRequest;
    }

    @Override
    public int deleteRequest() {
        return ++numCallsDeleteRequest;
    }
}
