package Steps;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

/**
 * Created by Mufleh on 31/12/2018.
 */
public abstract class BaseClass {

    public String StepInfo;

    public static WebDriver driver;

    public String getStepInfo() {
        return StepInfo;
    }

    public void setStepInfo(String stepInfo) {
        StepInfo = stepInfo;
    }

    public static void init() throws MalformedURLException {
        DriverInit instance = DriverInit.getInstance();
        driver = instance.openBrowser();
    }

}
