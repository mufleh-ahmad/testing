package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Mufleh on 02/01/2019.
 */
public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'About')]")
    public WebElement about;

    public void clickAboutLink(){

        Assert.assertTrue(String.valueOf(about.isDisplayed()), true);
        about.click();

    }
}
