package com.marketalertumassignment1;

import org.json.JSONObject;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Item {

    private int AlertType;
    private String Heading;
    private String Description;
    private String Url;
    private String ImageURL;
    private int PriceInCents;
    private String id = "4c2e5fc8-c27f-4b7a-999f-603b551f1888";


    //scaffolding of Item
    public Item(int alertType, String heading, String description, String url, String imageURL, int priceInCents) {
        this.AlertType = alertType;
        this.Heading = heading;
        this.Description = description;
        this.Url = url;
        this.ImageURL = imageURL;
        this.PriceInCents = priceInCents;
    }

    public String serialize() {

        JSONObject temp = new JSONObject();
        //key + value. put() - adding fields to the JSONObject.
        temp.put("alertType", AlertType);
        temp.put("heading", Heading);
        temp.put("description", Description);
        temp.put("url", Url);
        temp.put("imageUrl", ImageURL);
        temp.put("postedBy", id);
        temp.put("priceInCents", PriceInCents);

        //JSONObject has toString() built in it but when using return, we have to explicitly type it.
        return temp.toString();
    }
}
