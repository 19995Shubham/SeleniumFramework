package commonUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtils {

    final WebDriver webdriver;
    final long _INTERVAL;
    public CommonUtils(WebDriver driver){
        this.webdriver = driver;
       _INTERVAL = 20;
    }

    private void waitForElement(By locator, long duration){

        try {
            new WebDriverWait(this.webdriver, Duration.ofSeconds(duration)).until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(locator),
                    ExpectedConditions.presenceOfElementLocated(locator)
            ));
        } catch (Exception ex){
            System.out.println("[-] Exception Occurred: ");
            ex.printStackTrace();
        }
    }

    private void waitForElementToBeClickable(By locator, long duration){

        try {
            new WebDriverWait(this.webdriver, Duration.ofSeconds(duration)).until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(locator),
                    ExpectedConditions.presenceOfElementLocated(locator),
                    ExpectedConditions.elementToBeClickable(locator)
            ));
        } catch (Exception ex){
            System.out.println("[-] Exception Occurred: ");
            ex.printStackTrace();
        }
    }
    public void doClick(By locator) throws Exception {
        this.waitForElementToBeClickable(locator, this._INTERVAL);
        this.webdriver.findElement(locator).click();
    }

    public void doSendkeys(By locator, String text) throws Exception{
        this.waitForElementToBeClickable(locator, this._INTERVAL);
        this.webdriver.findElement(locator).sendKeys(text);
    }

    public String getTitle(String title){
        try {
            new WebDriverWait(this.webdriver, Duration.ofSeconds(this._INTERVAL)).until(ExpectedConditions.titleIs(title));
            return this.webdriver.getTitle();

        } catch (Exception ex) {
            System.out.println("[-] An exception occurred!");
            ex.printStackTrace();
        }

        return null;
    }
}
