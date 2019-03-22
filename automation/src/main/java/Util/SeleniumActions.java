package Util;

import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

/**
 * Created by Mufleh on 22/03/2019.
 */
public class SeleniumActions {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void waitForElementPresent(WebElement element){
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }

    public void doubleClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement((By) element));
        actions.perform();
    }

    public void close(){
        driver.close();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageSource(){
        return driver.getPageSource();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void quit(){
        driver.quit();
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    public void navigateForward(){
        driver.navigate().forward();
    }

    public void navigateRefresh(){
        driver.navigate().refresh();
    }

    public void navigteTo(URL url){
        driver.navigate().to(url);
    }

    public void clear(WebElement element){
        driver.findElement((By) element).clear();
    }

    public void click(WebElement element){
        driver.findElement((By) element).click();
    }

    public void getText(WebElement element){
        driver.findElement((By) element).getText();
    }

    public boolean isDisplayed(WebElement element){
       return driver.findElement((By) element).isDisplayed();
    }

    public void isEnabled(WebElement element) {
        driver.findElement((By) element).isEnabled();
    }

    public void isSelected(WebElement element) {
        driver.findElement((By) element).isSelected();
    }

    public void sendKeys(WebElement element, String value){
        driver.findElement((By) element).sendKeys(value);
    }

    public void sendKeys(WebElement element){

    }

    public void switchToActiveElement(){
        driver.switchTo().activeElement();
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public void switchToFrame(String id){
        driver.switchTo().frame(id);
    }

    public void switchToFrame(int id){
        driver.switchTo().frame(id);
    }

    public void switchToFrame(WebElement element){
        driver.switchTo().frame(driver.findElement((By) element));
    }

    public String getAttribute(WebElement element, String attribute){
        return driver.findElement((By) element).getAttribute(attribute);
    }

    public Cookie getCookie(String name){
        return driver.manage().getCookieNamed(name);
    }

    public void executeJavaScript(String js, Object paramaters){



    }
}
