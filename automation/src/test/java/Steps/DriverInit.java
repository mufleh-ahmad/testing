package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Mufleh on 24/03/2019.
 */
public class DriverInit {

    private static DriverInit instanceDriver = null;
    private WebDriver driver;
    DesiredCapabilities capabilities;
    private DriverInit(){
    }

    public WebDriver openBrowser() throws MalformedURLException {
        String browserProperty = getProperties("browser");
        String seleniumHubUrl = getProperties("selenium-hub-url");

        if (browserProperty.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserProperty.equals("ChromeGrid")) {
            capabilities = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL(seleniumHubUrl), capabilities);
        } else if (browserProperty.equals("FirefoxGrid")){
            capabilities = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(new URL(seleniumHubUrl), capabilities);
        }
        return driver;
    }

    public static DriverInit getInstance(){
        if (instanceDriver == null) {
            instanceDriver = new DriverInit();
        }
        return instanceDriver;
    }

    public String getProperties(String propertyName) {
        Properties properties = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // load a properties file
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // get the property value and print it out
        return properties.getProperty(propertyName);
    }
}
