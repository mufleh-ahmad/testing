package Steps;

import org.openqa.selenium.WebDriver;

/**
 * Created by Mufleh on 31/12/2018.
 */
public class BaseUtil {

    public String StepInfo;

    public WebDriver driver;

    public String getStepInfo() {
        return StepInfo;
    }

    public void setStepInfo(String stepInfo) {
        StepInfo = stepInfo;
    }
}
