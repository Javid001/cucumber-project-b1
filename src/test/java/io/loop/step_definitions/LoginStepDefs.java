package io.loop.step_definitions;

import io.loop.pages.LoginPage;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.DocuportConstants;
import io.loop.utilities.Driver;
import io.cucumber.java.en.*;

import java.util.Map;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user enters username for client")
    public void user_enters_username_for_client() {
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
    }

    @When("user enters password for client")
    public void user_enters_password_for_client() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {

        loginPage.loginButton.click();
    }

    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
        BrowserUtils.waitForVisibility(loginPage.loginButton, 10);
        loginPage.loginButton.isDisplayed();
    }

    @When("user enters username for employee")
    public void userEntersUsernameForEmployee() {

        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
    }

    @When("user enters password for employee")
    public void userEntersPasswordForEmployee() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @Then("user should see the home page for employee")
    public void userShouldSeeTheHomePageForEmployee() {
        BrowserUtils.waitForVisibility(loginPage.loginButton, 10);
        loginPage.loginButton.isDisplayed();
    }

    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {

        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
    }

    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {

        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        BrowserUtils.waitForVisibility(loginPage.loginButton, 10);
        loginPage.loginButton.isDisplayed();
    }

    @When("user enters username for admin")
    public void user_enters_username_for_admin() {

        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
    }

    @When("user enters password for admin")
    public void user_enters_password_for_admin() {

        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @Then("user should see the home page for admin")
    public void user_should_see_the_home_page_for_admin() {
        BrowserUtils.waitForVisibility(loginPage.loginButton, 10);
        loginPage.loginButton.isDisplayed();
    }

    @When("user enters credentials")
    public void user_enters_credentials(Map<String, String> credentials) {

        loginPage.loginDocuport(credentials.get("username"),credentials.get("password"));
    }

    @When("user types {string} in the google search box and click enter")
    public void user_types_in_the_google_search_box_and_click_enter(String string) {

    }
    @Then("User should see {string} search is in the google title")
    public void user_should_see_search_is_in_the_google_title(String string) {

    }
}
