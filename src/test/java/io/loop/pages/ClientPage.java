package io.loop.pages;

import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage {
    public static final String ChooseAccount = "//h3[.='Choose account']";
    public ClientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = ChooseAccount)
    public WebElement chooseAccountText;

    @FindBy(xpath = "//span[.=' Continue ']")
    public WebElement continueButton;

}
