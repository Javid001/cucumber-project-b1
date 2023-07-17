package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePageForDocuport {



    private final Logger LOG = LogManager.getLogger();


    public BasePageForDocuport(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void clickButton(String button){
        switch (button.toLowerCase()){
            case "home":
                home_button.click();
                break;
            case "received docs":
                receivedDocs_button.click();
                break;
            case "my uploads":
                myUploads_button.click();
                break;
            case "clients":
                clients_button.click();
                break;
            case "invitations":
                invitations_button.click();
                break;
            case "users":
                users_button.click();
                break;
            case "leads":
                leads_button.click();
                break;
            case "bookkeping":
                bookkeeping_button.click();
                break;
            case "1099 form":
                tenNineForm_button.click();
                break;
            case "reconciliations":
                reconciliations_button.click();
                break;
            case "continue":
                BrowserUtils.waitForVisibility(continueButtonOnClient_button,5);
                continueButtonOnClient_button.click();
                BrowserUtils.waitForClickable(tenNineForm_button,3);
                break;


        }

    }
    private void getLOG(String button){

    }

    @FindBy(xpath = "//i/following-sibling::span[.='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//i/following-sibling::span[.='Download']")
    public WebElement downloadButton;

    @FindBy(xpath = "//h1[.='Received docs']")
    public WebElement receivedDocsText;



    @FindBy(xpath = "//h1[.='My uploads']")
    public WebElement myUploadsText;
    @FindBy(xpath = "//span[.='Home']")
    private WebElement home_button;
    @FindBy(xpath = "//span[.='Received docs']")
    private WebElement receivedDocs_button;
    @FindBy(xpath = "//span[.='My uploads']")
    private WebElement myUploads_button;

    @FindBy(xpath = "//span[.='Clients']")
    private WebElement clients_button;
    @FindBy(xpath = "//span[.='Invitations']")
    private WebElement invitations_button;
    @FindBy(xpath = "//span[.='Users']")
    private WebElement users_button;
    @FindBy(xpath = "//span[.='Leads']")
    private WebElement leads_button;
    @FindBy(xpath = "//span[.='Bookkeeping']")
    private WebElement bookkeeping_button;
    @FindBy(xpath = "//span[.='1099 Form']")
    private WebElement tenNineForm_button;
    @FindBy(xpath = "//span[.='Reconciliations']")
    private WebElement reconciliations_button;

    @FindBy(xpath = "//span[.=' Continue ']/..")
    private WebElement continueButtonOnClient_button;
}