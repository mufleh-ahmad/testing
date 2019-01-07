package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Mufleh on 07/01/2019.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/FeatureFile/"},
        format = {"pretty", "html:target/cucumber"},
        glue = {"Steps"} )
public class TestRunner {
}
