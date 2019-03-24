package Pages;

import Util.SeleniumActions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Mufleh on 02/01/2019.
 */
public class LoginPage extends SeleniumActions {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    SeleniumActions seleniumActions;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/form/div[2]/div/div[1]/div/div[1]/input")
    public WebElement searchBox;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'About')]")
    public WebElement about;

    @FindBy(how = How.XPATH, using = "//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")
    public WebElement button;

    public void clickAboutLink(){
        Assert.assertTrue(String.valueOf(about.isDisplayed()), true);
    }

    public void enterSearchItem(String searchString){
        searchBox.isDisplayed();
        System.out.println(driver.getCurrentUrl());
        searchBox.sendKeys("Testing");
        searchBox.sendKeys(Keys.TAB);
    }

    public void clickButton(){
        button.isDisplayed();
        button.click();
    }

    public void test(){
    }
}
