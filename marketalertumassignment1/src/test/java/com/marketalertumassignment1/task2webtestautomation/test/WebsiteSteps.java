package com.marketalertumassignment1.task2webtestautomation.test;

import com.marketalertumassignment1.Item;
import com.marketalertumassignment1.SiteLoader;
import com.marketalertumassignment1.WebAPI;
import com.marketalertumassignment1.data.KlikkDataExtract;
import com.marketalertumassignment1.task2webtestautomation.AuthenticationPageObject;
import com.marketalertumassignment1.task2webtestautomation.MyAlertsPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class WebsiteSteps {

    AuthenticationPageObject authenticate = null;
    MyAlertsPageObject myAlerts = null;
    WebDriver driver;
    WebAPI api = new WebAPI();
    SiteLoader load;

    public void setUpMarketAlert(){
        if(driver == null)
        {
            System.setProperty("webdriver.chrome.driver", "/Users/leonz/webtesting/chromedriver.exe");
            driver = new ChromeDriver();

            driver.get("https://www.marketalertum.com/");
            driver.manage().window().maximize();
        }

        if(authenticate == null)
            authenticate = new AuthenticationPageObject(driver);
    }

    public void setupMarketAdmin()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/leonz/webtesting/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.marketalertum.com/");
        driver.manage().window().maximize();

        myAlerts = new MyAlertsPageObject(driver);
    }

    @Given("I am a user of marketalertum")
    public void iAmAUserOfMarketalertum() throws IOException, InterruptedException {
        setUpMarketAlert();
    }

    @Given("I am an administrator of the website and I upload 3 alerts")
    public void iAmAnAdministratorOfTheWebsiteAndIUpload3Alerts() throws InterruptedException, IOException {

        api.deleteRequest();
        List<Item> items = KlikkDataExtract.GetItems(3);
        setupMarketAdmin();
        myAlerts.PostAlerts(items);
    }

    @Given("I am an administrator of the website and I upload more than 5 alerts")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadMoreThan5Alerts() throws InterruptedException, IOException {
        api.deleteRequest();
        List<Item> items = KlikkDataExtract.GetItems(6);

        setupMarketAdmin();
        myAlerts.PostAlerts(items);
    }

    @Given("I am an administrator of the website and I upload an alert of type {int}")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadAnAlertOfType(int arg0) throws IOException {
        setupMarketAdmin();
        api.deleteRequest();
        myAlerts.PostAlertWithType(arg0);
    }

    @When("I login using valid credentials")
    public void iLoginUsingValidCredentials() throws InterruptedException {
        authenticate.logIn("4c2e5fc8-c27f-4b7a-999f-603b551f1888");
    }

    @When("I login using invalid credentials")
    public void iLoginUsingInValidCredentials() throws InterruptedException {
        authenticate.logIn("12313123");
    }

    @Then("I should see my alerts")
    public void iShouldSeeMyAlerts() {
        Assertions.assertEquals("https://www.marketalertum.com/Alerts/List", authenticate.getUrl());
    }

    @Then("I should see the login screen again")
    public void iShouldSeeTheLoginScreenAgain() {
        Assert.assertEquals("https://www.marketalertum.com/Alerts/Login", authenticate.getUrl());
    }

    @When("I view a list of alerts")
    public void iViewAListOfAlerts() throws InterruptedException {
        authenticate.logIn("4c2e5fc8-c27f-4b7a-999f-603b551f1888");
    }

    @Then("each alert should contain an icon")
    public void eachAlertShouldContainAnIcon() {
        Assert.assertTrue(myAlerts.VerifyExists("icon", driver));
    }

    @Then("each alert should contain a heading")
    public void eachAlertShouldContainAHeading() {
        Assert.assertTrue(myAlerts.VerifyExists("heading", driver));
    }

    @Then("each alert should contain a description")
    public void eachAlertShouldContainADescription() {
        Assert.assertTrue(myAlerts.VerifyExists("description", driver));
    }

    @Then("each alert should contain an image")
    public void eachAlertShouldContainAnImage() {
        Assert.assertTrue(myAlerts.VerifyExists("image", driver));
    }

    @Then("each alert should contain a price")
    public void eachAlertShouldContainAPrice() {
        Assert.assertTrue(myAlerts.VerifyExists("price", driver));
    }

    @Then("each alert should contain a link to the original product website")
    public void eachAlertShouldContainALinkToTheOriginalProductWebsite() {
        Assert.assertTrue(myAlerts.VerifyExists("visit item", driver));
    }

    @Then("I should see {int} alerts")
    public void iShouldSee5Alerts(int arg0) {
        Assert.assertEquals(arg0, myAlerts.GetItems(driver).size());
    }

    @Then("the icon displayed should be {string}")
    public void theIconDisplayedShouldBe(String fileName) {
        Assert.assertEquals(fileName, myAlerts.getFileName());
    }
}
