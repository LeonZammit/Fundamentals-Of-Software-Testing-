package com.marketalertumassignment1.task2webtestautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class AuthenticationPageObject {

    WebDriver driver;

    public AuthenticationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn(String userID) throws InterruptedException {

        WebElement logInButton = driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]/a"));
        Thread thread = new Thread();
        thread.sleep(3);
        logInButton.click();
        WebElement searchField = driver.findElement(By.id("UserId"));
        searchField.sendKeys(userID);
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/main/form/input[2]"));
        submitButton.click();
    }

    public String getUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }
}
