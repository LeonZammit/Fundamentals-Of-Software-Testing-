package com.marketalertumassignment1;

import com.marketalertumassignment1.managerutilities.MarketUmManager;
import okhttp3.*;
import org.openqa.selenium.json.Json;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WebAPI implements MarketUmManager {

    //Given userID
    String userId = "4c2e5fc8-c27f-4b7a-999f-603b551f1888";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    //Post Method
    @Override
    public int postRequest(String itemInputString) throws IOException {

        String url = "https://api.marketalertum.com/Alert";

        RequestBody body = RequestBody.create(JSON, itemInputString);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        //Executing the response requested. - POST
        Response response = client.newCall(request).execute();
        return response.code();
    }

    //Delete Method
    @Override
    public int deleteRequest() throws IOException {
        URL url = new URL("https://api.marketalertum.com/Alert?userId=" + userId);

        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        //Executing the response requested. - DELETE
        Response response = client.newCall(request).execute();
        return response.code();
    }
}
