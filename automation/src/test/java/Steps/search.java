package Steps;

import Util.User;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

/**
 * Created by Mufleh on 31/12/2018.
 */
public class search extends BaseUtil {

    private BaseUtil baseUtil;

    public search(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Given("^user enters google in url$")
    public void userEntersGoogleInUrl() throws Throwable {

        System.out.println("Entering google");

        System.out.println("Driver is " + baseUtil.StepInfo);
    }

    @When("^user searches automation$")
    public void userSearchesAutomation() throws Throwable {
        System.out.println("Searching");
    }

    @Then("^user is directed to results page$")
    public void userIsDirectedToResultsPage() throws Throwable {
        System.out.println("Entered Results page");
    }

    @Given("^user is logged in$")
    public void userIsLoggedIn() throws Throwable {
        System.out.println("User Logged In");
    }

    @When("^user enters the following details$")
    public void userEntersTheFollowingDetails(List<User> users) throws Throwable {

        for (User user : users) {
            System.out.println(user.getFirstName());
            System.out.println(user.getSurname());
            System.out.println(user.getAge());
        }
    }

    @When("^user enters ([^\"]*), ([^\"]*) and ([^\"]*)$")
    public void userEntersFirstNameSurnameAndAge(String firstName, String surname, int age) throws Throwable {

        System.out.println(firstName);
        System.out.println(surname);
        System.out.println(age);

    }

}
