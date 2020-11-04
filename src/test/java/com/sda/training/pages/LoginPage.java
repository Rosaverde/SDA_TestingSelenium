package com.sda.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "email")
    WebElement emailField;

    @FindBy(how = How.ID, using = "passwd")
    WebElement passwordField;

    @FindBy(how = How.ID, using = "SubmitLogin")
    WebElement signInButton;

    @FindBy(how = How.CLASS_NAME, using = "alert")
    WebElement alertMessage;

    public void clickSignInButton() {
        signInButton.click();
    }

    public void fillEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public Boolean isErrorMessageDisplayed() {
        return alertMessage.isDisplayed();
    }

    public void verifyIfLoginPageIsOpened() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(signInButton));
    }

    public String getErrorMessage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(alertMessage));
        return alertMessage.getText();
    }

    public void authenticate(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
        clickSignInButton();
    }
}
