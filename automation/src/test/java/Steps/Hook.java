package Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

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
    }

    @After

    public void teardown(Scenario scenario){

        if (scenario.isFailed()){

            System.out.println("test failed");
        }


        System.out.println("Test ended");
    }



}
