package io.loop.step_definitions;

import io.loop.pages.GoogleSearchPage;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

import static org.openqa.selenium.devtools.v110.console.model.ConsoleMessage.Level.LOG;


public class GoogleSearchStepDefs {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    private static final Logger LOG = LogManager.getLogger();

    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        LOG.info("User is on Google page");
    }
    @When("user types Loop Academy in the google search box and clicks enter")
    public void user_types_loop_academy_in_the_google_search_box_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("Loop Academy" + Keys.ENTER);


    }
    @Then("user should see Loop Academy - Google Search in the google title")
    public void user_should_see_loop_academy_google_search_in_the_google_title() {
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals("expected does not match the actual,", "Loop Academy - Google Search",actualTitle);

    }
    @When("user types {string} in the google search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter(String input) {
        googleSearchPage.searchBox.sendKeys(input+Keys.ENTER);
    }
    @Then("user should see {string} in the google title")
    public void user_should_see_in_the_google_title(String title) {
        Assert.assertEquals("Expect does not match the actual" , title , Driver.getDriver().getTitle());
    }

    @Then("user searches the following item")
    public void user_searches_the_following_item(List<String> items) {
//        items.forEach(p -> {
//            googleSearchPage.searchBox.clear();
//            googleSearchPage.searchBox.sendKeys(p + Keys.ENTER);
//            Assert.assertEquals(p + " - Google Search", Driver.getDriver().getTitle());
//        });

        for (String s : items){
            googleSearchPage.searchBox.clear();
            googleSearchPage.searchBox.sendKeys(s + Keys.ENTER);
            Assert.assertEquals(s + " - Google Search", Driver.getDriver().getTitle());
        }
    }
    @When("user searches for the {string}")
    public void user_searches_for_the(String country) {
        googleSearchPage.searchBox.sendKeys("What is the capital of " + country + Keys.ENTER);

    }
    @Then("user should see the {string} in the result")
    public void user_should_see_the_in_the_result(String capital) {
        Assert.assertEquals(googleSearchPage.capital.getText(), capital);

    }
}