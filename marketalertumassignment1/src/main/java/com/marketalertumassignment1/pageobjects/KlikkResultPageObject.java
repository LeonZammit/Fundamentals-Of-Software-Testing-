package com.marketalertumassignment1.pageobjects;

import com.marketalertumassignment1.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class KlikkResultPageObject {

    WebDriver Driver;

    public KlikkResultPageObject(WebDriver driver){
        Driver = driver;
    }

    //method that extracts the attribute data of each item.
    public Item extractData() throws InterruptedException {

        //Getting the attributes of the items.
        String imageUrl = Driver.findElement(By.className("carousel-inner")).findElement(By.tagName("img")).getAttribute("src");
        String heading  = Driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[1]/div[1]/div/div[1]/div[2]/div[2]/p/b")).getText();

        String description;
            description = Driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[1]/div[1]/div/div[2]/div/div[1]/div")).getText();
            //System.out.println("Description of the item: \n" + description);

        String priceInCents = Driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[1]/div[1]/div/div[1]/div[2]/div[5]/p/b")).getText();

        String newStrg = "";
        //iterating through every character.
        for(int j =0; j<priceInCents.length(); j++)
        {

            //Using the replace method to remove the euro and decimal symbols.
            newStrg = priceInCents.replace("€", "").replace(".", "").trim();

        }

        //parsing the String into an integer.
        int i = Integer.parseInt(newStrg);

        //returning all attributes of item.
        return new Item(6, heading,description,url,imageUrl,i);
    }

    String url;

    //method which returns a list of type Item.
    public List<Item> getResult(int count) throws InterruptedException {

        //List of type WebElement which stores all the items that have the className "product_card_grid"
        List<WebElement> resultItems = Driver.findElements(By.className("product_card_grid"));

        List<Item> data = new LinkedList<Item>();
        List<String> urls = new LinkedList<String>();


        for (int i = 0; i < count; i++) {

            //Getting 5 items.
            WebElement item = resultItems.get(i);

            //Getting the URL of the items to get the data needed from them, example price description etc...
            WebElement clickItem = item.findElement(By.className("product_card_grid_body"));
            url = clickItem.findElement(By.tagName("a")).getAttribute("href");
            urls.add(url);

        }

        //Getting each url of the items, extracting their data and returning it.
        for (int j = 0; j < count; j++) {
            Driver.get(urls.get(j));
            data.add(extractData());
        }
        return data;
    }
}
