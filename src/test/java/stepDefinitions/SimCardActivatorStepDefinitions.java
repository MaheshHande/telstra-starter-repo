package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.junit.Assert;

public class SimCardActivatorStepDefinitions {

    @Autowired
    private RestTemplate restTemplate;

    private String iccid;
    private boolean activationSuccess;
    private String queryResponse;

    @Given("I have a valid ICCID {string}")
    public void i_have_a_valid_iccid(String iccid) {
        this.iccid = iccid;
    }

    @When("I submit the activation request")
    public void i_submit_the_activation_request() {
        // Assuming the activation endpoint is "/activate"
        String activationUrl = "http://localhost:8080/activate";
        try {
            restTemplate.postForObject(activationUrl, iccid, String.class);
            activationSuccess = true;
        } catch (Exception e) {
            activationSuccess = false;
        }
    }

    @Then("the activation should be successful")
    public void the_activation_should_be_successful() {
        Assert.assertTrue(activationSuccess);
    }

    @Then("I should be able to query the activation status and find the record")
    public void i_should_be_able_to_query_the_activation_status_and_find_the_record() {
        // Assuming the query endpoint is "/query"
        String queryUrl = "http://localhost:8080/query?iccid=" + iccid;
        queryResponse = restTemplate.getForObject(queryUrl, String.class);
        Assert.assertNotNull(queryResponse);
        Assert.assertTrue(queryResponse.contains(iccid));
    }

    @Then("the activation should fail")
    public void the_activation_should_fail() {
        Assert.assertFalse(activationSuccess);
    }

    @Then("I should not find any activation record in the database")
    public void i_should_not_find_any_activation_record_in_the_database() {
        // You may need a method to query the database directly
        // Example using some repository or service to check if record exists
        // Assuming an ActivationService that checks for the record by ICCID
        // boolean recordExists = activationService.recordExists(iccid);
        // Assert.assertFalse(recordExists);
    }
}
