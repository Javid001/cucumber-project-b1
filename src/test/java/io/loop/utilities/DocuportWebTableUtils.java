package io.loop.utilities;

 /*
    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
     */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocuportWebTableUtils {
    public static String returnAnyField(WebDriver driver, String emailAddress, String field) {
        WebElement element = null;
        String xpath = "";

        switch (field.toLowerCase()) {
            case "full name":
                xpath = "//td[2][contains(text(),'" + emailAddress + "')]/preceding-sibling::td//span[2]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "username":
                xpath = "//td[2][contains(text(),'" + emailAddress + "')]//following-sibling::td[1]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "advisor":
                xpath="//td[2][contains(text(),'"+emailAddress+"')]/following-sibling::td[5]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "phone number":
                xpath="//td[2][contains(text(),'"+emailAddress+"')]/following-sibling::td[3]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "role":
                xpath="//td[2][contains(text(),'"+emailAddress+"')]/following-sibling::td[4]";
                element = driver.findElement(By.xpath(xpath));
                break;
        }
        return element.getText();
    }
}