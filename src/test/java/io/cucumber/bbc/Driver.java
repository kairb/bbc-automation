package io.cucumber.bbc;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    private WebDriver driver = new ChromeDriver();

    public Driver(String url){
        driver.get(url);
    }

    public WebElement findById (String id){
        return driver.findElement(By.id(id));
    }

    public void click(WebElement element){
        element.click();
    }

    public void type(WebElement element, String input){
        element.sendKeys(input);
    }

    public By returnBy(String id){
        return By.id(id);
    }

    public boolean elementExists(String id) {
        try {
            this.waitForPageLoad(10,returnBy(id));
            this.findById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void waitForPageLoad(long timeout, By element){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void quit(){
        driver.quit();
    }
}
