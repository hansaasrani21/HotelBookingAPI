package com.stepDefinitions;

import com.Base.APIServiceLibrary;
import cucumber.api.java.en.When;
import java.io.IOException;

public class AuthenticationStepDefinition {
    @When("^I am an authorized user$")
    public void userCreatesAuthTokenWithUseridAsAdminAndPasswordAsPassword() throws IOException {
        APIServiceLibrary.getAuthToken();
    }
}
