package com.marketalertumassignment1.task2webtestautomation;

import com.marketalertumassignment1.Item;
import com.marketalertumassignment1.WebAPI;
import com.marketalertumassignment1.pageobjects.KlikkResultPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MyAlertsPageObject {

    WebAPI api;
    WebDriver driver;

    public MyAlertsPageObject(WebAPI api, WebDriver driver){
        this.driver = driver;
        this.api = api;
        System.out.print(driver);
    }

    public void PostAlerts(List<Item> items) throws InterruptedException, IOException {

        api.deleteRequest();

        for(int i = 0; i < items.size(); i++){
            System.out.println(api.postRequest(items.get(i).serialize()));
        }
    }

    public void PostAlertWithType(int alertType) throws IOException {
        Item item = new Item(alertType, "test", "test", "test", "test", 2200);
        api.postRequest(item.serialize());
    }

    public String getFileName() {

        String iconName = driver.findElement(By.xpath("/html/body/div/main/table/tbody/tr[1]/td/h4/img")).getAttribute("src");
        iconName = iconName.replaceAll("https://www.marketalertum.com/images/", "");
        iconName = iconName.replaceAll(".jpg", ".png");

        return iconName;

    }

    public List<WebElement> GetItems(WebDriver localDriver){
        return localDriver.findElements(By.tagName("table"));
    }

    public boolean VerifyExists(String find, WebDriver driver) {

        List<WebElement> items = GetItems(driver);
        String tagName = "";
        int row = 0;

         switch(find){
            case "icon":
                tagName = "img";
                row = 0;
                break;
            case "heading":
                tagName = "h4";
                row = 0;
                break;
            case "description":
                tagName = "td";
                row = 2;
                break;
            case "image":
                tagName = "img";
                row = 1;
                break;
            case "price":
                tagName = "td";
                row = 3;
                break;
            case "visit item":
                tagName = "td";
                row = 4;
                break;
        }

        int counter = 0;

        for(WebElement item : items){

            List<WebElement> tableRows = item.findElements(By.tagName("tr"));

            WebElement tempElement = tableRows.get(row).findElement(By.tagName(tagName));

            if(tempElement != null)
                counter++;
        }

        System.out.println(find + " " + tagName + " " + row + " Counter: " + counter + " Total Items: " + items.size());
        return (counter == items.size()) ? true : false;
    }
}
