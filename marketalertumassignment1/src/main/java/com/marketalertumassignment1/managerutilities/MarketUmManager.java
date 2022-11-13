package com.marketalertumassignment1.managerutilities;

import java.io.IOException;
import java.net.MalformedURLException;

public interface MarketUmManager {

    public int postRequest(String itemInputStream) throws IOException;

    public int deleteRequest() throws IOException;
}
