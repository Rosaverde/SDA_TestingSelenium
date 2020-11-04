package com.sda.training.steps;

import com.sda.training.pages.HomePage;
import com.sda.training.pages.LoginPage;
import com.sda.training.pages.MyAccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class AuthenticationStepdefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Given("Home page is opened")
    public void homePageIsOpened() {
        homePage.openHomePage();
    }

    @When("I open Login Page")
    public void iOpenLoginPage() {
        homePage.clickSignInButtonOnTopMenu();
    }

    @And("I click Sign In button")
    public void iClickSignInButton() {
        loginPage.clickSignInButton();
    }

    @Then("I can see error message {string}")
    public void iCanSeeErrorMessage(String errorMessage) {
        String visibleMessage = loginPage.getErrorMessage();
        assertThat("Error message should be displayed", loginPage.isErrorMessageDisplayed());
        assertThat("Error message should be as expected", visibleMessage.contains(errorMessage));
    }

    @And("I fill email address field {string}")
    public void iFillEmailAddressField(String emailAddress) {
        loginPage.fillEmailField(emailAddress);
    }

    @And("I fill password field {string}")
    public void iFillPasswordField(String password) {
        loginPage.fillPasswordField(password);
    }

    @Then("Login Page is opened")
    public void loginPageIsOpened() {
        loginPage.verifyIfLoginPageIsOpened();
    }

    @When("I authenticate using credentials")
    public void iAuthenticateUsingCredentials(DataTable credentials) {
        List<String> userCredentials = credentials.row(1);
        String addressEmail = userCredentials.get(0);
        String password = userCredentials.get(1);
        loginPage.fillEmailField(addressEmail);
        loginPage.fillPasswordField(password);
        loginPage.clickSignInButton();
//        loginPage.authenticate(addressEmail, password);
    }

    @Then("I can see My Account Page")
    public void iCanSeeMyAccountPage() {
        myAccountPage.verifyIfMyAccountPageIsOpened();
    }
}
