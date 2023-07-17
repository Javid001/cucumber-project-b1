package io.loop.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.ClientPage;
import io.loop.pages.LoginPage;
import io.loop.utilities.BrowserUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


import static org.junit.Assert.assertTrue;

public class DocuStepDefs {

    private final Logger LOG = LogManager.getLogger();

    LoginPage loginPage = new LoginPage();
    ClientPage clientPage = new ClientPage();
    String login;

    @When("user clicks on {string}")
    public void user_clicks_on(String button) {
        loginPage.clickButton(button);
        LOG.info("CLICKED "+ button.toUpperCase());
    }
    @When("user sees {string} is displayed")
    public void user_sees_is_displayed(String validation) {
        switch (validation){

            case "Search":
                assertTrue(loginPage.searchButton.isDisplayed());
                LOG.info("Search is displayed");
                break;
            case "Download":
                assertTrue(loginPage.downloadButton.isDisplayed());
                LOG.info("Download is displayed");
                break;
            case "Received docs":
                assertTrue(loginPage.receivedDocsText.isDisplayed());
                LOG.info("Received docs is displayed");
                break;
            case "My uploads":
                assertTrue(loginPage.myUploadsText.isDisplayed());
                LOG.info("My uploads is displayed");
                break;
        }
    }
    @When("user enters {string} and {string}")
    public void user_enters_and(String login, String password) {
      loginPage.usernameInput.sendKeys(login);
      loginPage.passwordInput.sendKeys(password);
      loginPage.loginButton.click();
      if(login.contains("client")){
          loginPage.clickButton("Continue");

      }
    }
}

