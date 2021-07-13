package com.automation.demo.stepdefinitions;

import com.automation.demo.api.HttpClientHelper;
import com.automation.demo.models.response.GetAllUserBaseResponse;
import com.automation.demo.models.response.GetAllUsersData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class UsersStepdefinitions {

    private HttpClientHelper httpClientHelper;
    private ObjectMapper objectMapper;

    private String httpRequestUrl = "";
    private String reqResBaseUrl = "https://reqres.in";

    private GetAllUserBaseResponse getAllUserBaseResponse;

    private Map<String, String> apiResponseData;

    @Before
    public void setUp() {
        httpClientHelper = new HttpClientHelper();
        objectMapper = new ObjectMapper();
        getAllUserBaseResponse = new GetAllUserBaseResponse();
        apiResponseData = new HashMap<>();
    }

    @Given("User prepares {string} request")
    public void userPreparesRequest(String requestType) {
        switch (requestType) {
            case "Get All Users":
                httpRequestUrl = reqResBaseUrl + "/api/users?page=1";
                break;
            default:
                Assert.fail("Invalid Request Type");
        }
    }

    @Given("User prepares {string} request with below data")
    public void userPreparesRequestWithBelowData(String requestType, DataTable requestData) {
        switch (requestType) {
            case "Create New User":
                httpRequestUrl = reqResBaseUrl + "/api/users";
                break;
            default:
                Assert.fail("Invalid Request Type");
        }
    }

    @When("{string} Request is submitted")
    public void requestIsSubmitted(String httpMethod) {
        switch (httpMethod) {
            case "Get":
                apiResponseData = httpClientHelper.submitGetRequestAndReturnResponse(httpRequestUrl);
                break;
            case "Post":

                break;
            default:
                Assert.fail("Invalid Http Method");
        }
    }

    @Then("Response Code is {string}")
    public void responseCodeIs(String responseCode) {
        Assert.assertEquals("Response code is not as expected", responseCode, apiResponseData.get("ResponseCode"));
    }

    @And("User data in Response is as expected")
    public void userDataInResponseIsAsExpected() throws JsonProcessingException {
        getAllUserBaseResponse = objectMapper.readValue(apiResponseData.get("ResponseBody"), GetAllUserBaseResponse.class);

        Assert.assertTrue("Page value is 0", getAllUserBaseResponse.getPage() > 0);
        Assert.assertTrue("Per Page value is 0", getAllUserBaseResponse.getPerPage() > 0);
        Assert.assertTrue("Total value is 0", getAllUserBaseResponse.getTotal() > 0);
        Assert.assertEquals("Total Pages value is not as expected",
                Optional.of(Math.ceil(getAllUserBaseResponse.getTotal() / getAllUserBaseResponse.getPerPage())),
                Optional.of(Double.valueOf(getAllUserBaseResponse.getTotalPages().toString())));

        Assert.assertEquals("User data count is not as expected", getAllUserBaseResponse.getPerPage(), Integer.valueOf(getAllUserBaseResponse.getData().size()));

        for (GetAllUsersData userDataInResponse : getAllUserBaseResponse.getData()) {
            Assert.assertTrue("Id is 0", userDataInResponse.getId() > 0);
            Assert.assertTrue("Email is empty", userDataInResponse.getEmail().length() > 0);
            Assert.assertTrue("FirstName is empty", userDataInResponse.getFirstName().length() > 0);
            Assert.assertTrue("LastName is empty", userDataInResponse.getLastName().length() > 0);
            Assert.assertTrue("Avatar is empty", userDataInResponse.getAvatar().length() > 0);
        }

        Assert.assertNotNull("Support Information is empty", getAllUserBaseResponse.getSupport());
        Assert.assertFalse("Support Url is empty", getAllUserBaseResponse.getSupport().getUrl().isEmpty());
        Assert.assertFalse("Support Text is empty", getAllUserBaseResponse.getSupport().getText().isEmpty());

    }


}
