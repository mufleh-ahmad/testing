package Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Mufleh on 31/12/2018.
 */
public class Hook extends BaseUtil {

    private BaseUtil baseUtil;

    public Hook(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Before
    public void initialize(){

        System.out.println("Starting tests");
        baseUtil.StepInfo = "FirefoxDriver";

//        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
//        baseUtil.driver = new ChromeDriver();


        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        try {
            baseUtil.driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



    }

    @After

    public void teardown(Scenario scenario){

        if (scenario.isFailed()){
            System.out.println("test failed");
        }

        baseUtil.driver.close();
        System.out.println("Test ended");
    }



}
