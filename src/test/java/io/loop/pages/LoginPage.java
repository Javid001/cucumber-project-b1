package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageForDocuport {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='input-14']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='input-15']")
    public WebElement passwordInput;

    @FindBy(className = "v-btn__content")
    public WebElement loginButton;

    /**
     * logins to docuport
     *
     * @param username
     * @param password
     * @author nsh
     */
    public void loginDocuport(String username, String password) {
        BrowserUtils.waitForVisibility(usernameInput, 5);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        BrowserUtils.waitForClickable(loginButton, 5);
//        BrowserUtils.clickWithJS(loginButton);
    }
}