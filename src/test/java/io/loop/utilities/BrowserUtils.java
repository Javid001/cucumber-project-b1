package io.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {

    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedUrl = expectedTitle.toLowerCase();
        expectedTitle = expectedTitle.toLowerCase();
        Set<String> windowsHandles = driver.getWindowHandles();
        for (String each : windowsHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * switches to new window by the exact title
     * return to original window if window with given title not found
     *
     * @param targetTitle
     */
    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    public static void validateTitle(WebDriver driver, String expectedTitle) {
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    public static void loopLinkClick(String nameOfthePage) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfthePage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void hoverOver(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * method which scrolls to the given element
     * param web element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * method which scroll to element and click js
     * param element
     */
    public static void scrollAndClick(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click;", element);

    }

    /**
     * Performs double click action on an element
     *
     * @param element
     * @author nsh
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * waits for providing element to be visible
     *
     * @param element
     * @param timeToWait return element
     * @author Nadir
     */

    public static WebElement waitForVisibility(WebElement element, int timeToWait) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWait));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the provided element to be invisible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author nsh
     */
    public static void waitForInVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * method that will wait element becomes clickable
     *
     * @param element
     * @param timeOut
     * @return
     * @author
     */
    public static WebElement waitForClickable(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    /**
     * performs a pause
     *
     * @param seconds
     * @author nsh
     */
    public static void justWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }

        } else {
            if (element.isSelected()) {
                element.click();


            }

        }
    }

    public static void dragDrop(WebElement elementDrag,WebElement elementDrop ){
        new Actions(Driver.getDriver()).dragAndDrop(elementDrag,elementDrop).perform();

    }
}



