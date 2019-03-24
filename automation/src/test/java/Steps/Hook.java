package Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

/**
 * Created by Mufleh on 31/12/2018.
 */
public class Hook extends BaseClass {

    private BaseClass baseClass;

    DesiredCapabilities capabilities;
    public Hook(BaseClass baseClass) {
        this.baseClass = baseClass;
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

    @Before
    public void initialize() throws MalformedURLException {

        String browserProperty = getProperties("browser");
        String seleniumHubUrl = getProperties("selenium-hub-url");

        System.out.println("Starting tests");
        baseClass.StepInfo = "FirefoxDriver";
        init();


    }

    @After
    public void teardown(Scenario scenario){
        if (scenario.isFailed()){
            System.out.println("test failed");
        }

        driver.quit();
        System.out.println("Test ended");
    }



}
