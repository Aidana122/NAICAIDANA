package org.naic.step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.naic.pages.LoginPage;
import org.naic.utilities.Driver;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();


    @Given("As user I am on the Home Page")
    public void as_user_I_am_on_the_Home_Page() {
        Driver.getDriver().get("https://eapps.naic.org/lhub");
    }

    @When("As a user I Click the login button")
    public void as_a_user_I_Click_the_login_button() {
        loginPage.loginBttn1.click();

    }

    @When("Enter invalid username and password")
    public void enter_invalid_username_and_password() {
        loginPage.usernameInput.sendKeys("John1212");
        loginPage.passwordInput.sendKeys("121212");
        loginPage.loginBtn2.click();
    }

    @Then("I should see the error message")
    public void i_should_see_the_error_message() {
        String expected = "Login failed, please try again.";
        String actual = loginPage.errorMessage.getText();
        Assert.assertTrue(expected.contains(actual));

    }
}
